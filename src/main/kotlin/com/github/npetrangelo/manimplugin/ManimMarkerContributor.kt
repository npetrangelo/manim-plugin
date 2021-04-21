package com.github.npetrangelo.manimplugin

import com.intellij.execution.lineMarker.ExecutorAction
import com.intellij.execution.lineMarker.RunLineMarkerContributor
import com.intellij.icons.AllIcons
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.util.text.StringUtil
import com.intellij.psi.PsiElement
import com.intellij.util.containers.ContainerUtil
import com.jetbrains.python.PythonFileType
import com.jetbrains.python.psi.*


object ManimMarkerContributor : RunLineMarkerContributor() {
    override fun getInfo(element: PsiElement): Info? {
        if (element.containingFile.fileType !is PythonFileType) {
            return null
        }
        if (element is PyClass && isManimScene(element)) {
            // TODO Get better actions
            // File path at element.containingFile.virtualFile.path
            // Scene name at element.name
            val actions: Array<AnAction> = ExecutorAction.getActions()
            val tooltipProvider = { psiElement: PsiElement ->
                StringUtil.join(ContainerUtil.mapNotNull(actions) { action ->
                    getText(
                        action,
                        psiElement
                    )
                }, "\n")
            }
            return Info(AllIcons.RunConfigurations.TestState.Run, tooltipProvider, actions)
        }
        return null
    }

    private fun isManimScene(pyClass: PyClass): Boolean {
        pyClass.getSuperClasses(null).forEach {
            if (it.name == "Scene" &&
                it.containingFile.containingDirectory.parentDirectory!!.name == "manim"
            ) {
                return true
            }
            return isManimScene(it)
        }
        return false
    }
}