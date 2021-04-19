package com.github.npetrangelo.manimplugin

import com.intellij.execution.lineMarker.RunLineMarkerContributor
import com.intellij.psi.PsiElement
import com.jetbrains.python.PythonFileType
import com.jetbrains.python.psi.*

object ManimMarkerContributor : RunLineMarkerContributor() {
    override fun getInfo(element: PsiElement): Info? {
        if (element.containingFile.fileType !is PythonFileType) {
            return null
        }
        if (element is PyReferenceExpression && element.text == "Scene") {
            println(element)
        }
        return null
    }
}