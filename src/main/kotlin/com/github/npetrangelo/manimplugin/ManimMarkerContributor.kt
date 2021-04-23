package com.github.npetrangelo.manimplugin

import com.intellij.execution.lineMarker.ExecutorAction
import com.intellij.execution.lineMarker.RunLineMarkerContributor
import com.intellij.icons.AllIcons
import com.intellij.psi.PsiElement
import com.jetbrains.python.PythonFileType
import com.jetbrains.python.psi.PyClass


object ManimMarkerContributor : RunLineMarkerContributor() {
    override fun getInfo(element: PsiElement): Info? {
        if (element.containingFile.fileType !is PythonFileType) {
            return null
        }
        if (ManimUtil.isManimScene(element)) {
            return Info(AllIcons.RunConfigurations.TestState.Run,
                {"[Manim] Render ${(element as PyClass).name}"},
                *ExecutorAction.getActions(0))
        }
        return null
    }
}