package com.github.npetrangelo.manimplugin

import com.intellij.psi.PsiElement
import com.jetbrains.python.PythonFileType
import com.jetbrains.python.psi.PyClass

class ManimUtil {
    companion object {
        fun isManimScene(element: PsiElement): Boolean {
            if (element.containingFile.fileType !is PythonFileType) {
                return false
            }
            if (element !is PyClass) return false
            element.getSuperClasses(null).forEach {
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
}