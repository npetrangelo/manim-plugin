package com.github.npetrangelo.manimplugin

import com.intellij.execution.lineMarker.RunLineMarkerContributor
import com.intellij.psi.PsiElement
import com.jetbrains.python.PyTokenTypes;
import com.jetbrains.python.codeInsight.dataflow.scope.ScopeUtil;
import com.jetbrains.python.psi.PyFile;
import com.jetbrains.python.psi.PyIfStatement;
import com.jetbrains.python.psi.PyUtil;

class ManimMarkerContributor() : RunLineMarkerContributor() {
    override fun getInfo(element: PsiElement): Info? {
        if (isMainClauseOnTopLevel(element)) {

        }
        return null
    }

    private fun isMainClauseOnTopLevel(element: PsiElement): Boolean {
        if (element.node.elementType == PyTokenTypes.IF_KEYWORD) {

        }
        return false
    }
}