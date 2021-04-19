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
        if (element is PyReferenceExpression && element.text == "Scene") {
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
}