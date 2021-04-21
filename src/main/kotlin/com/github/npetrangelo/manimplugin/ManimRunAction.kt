package com.github.npetrangelo.manimplugin

import com.github.npetrangelo.manimplugin.runconfig.ManimRunConfig
import com.github.npetrangelo.manimplugin.runconfig.ManimRunConfigProducer
import com.intellij.execution.PsiLocation
import com.intellij.execution.actions.ConfigurationContext
import com.intellij.execution.actions.RunConfigurationProducer
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.psi.PsiFile
import javax.swing.ImageIcon

class ManimRunAction : AnAction() {
    init {
        templatePresentation.icon = ImageIcon("resources/META-INF/pluginIcon.svg")
    }

    private fun createRunConfiguration(file: PsiFile, scene: String): ManimRunConfig? {
        val context = ConfigurationContext.createEmptyContextForLocation(
            PsiLocation<PsiFile>(file.project, file)
        )
        val configurationFromContext = RunConfigurationProducer.getInstance(
            ManimRunConfigProducer::class.java).createConfigurationFromContext(context)
        return configurationFromContext?.configuration as? ManimRunConfig
    }

    override fun actionPerformed(p0: AnActionEvent) {
        TODO("Not yet implemented")
    }
}