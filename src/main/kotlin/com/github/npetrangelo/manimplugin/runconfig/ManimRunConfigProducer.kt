package com.github.npetrangelo.manimplugin.runconfig

import com.github.npetrangelo.manimplugin.ManimUtil
import com.intellij.execution.actions.ConfigurationContext
import com.intellij.execution.actions.LazyRunConfigurationProducer
import com.intellij.execution.configurations.ConfigurationFactory
import com.intellij.openapi.util.Ref
import com.intellij.psi.PsiElement
import com.jetbrains.python.psi.PyClass

class ManimRunConfigProducer : LazyRunConfigurationProducer<ManimRunConfig>() {
    override fun getConfigurationFactory(): ConfigurationFactory {
        return ManimRunConfigType.getInstance().factory
    }

    override fun setupConfigurationFromContext(config: ManimRunConfig,
                                               context: ConfigurationContext,
                                               sourceElement: Ref<PsiElement>): Boolean {
        val location = context.location ?: return false
        val file = location.virtualFile ?: return false
        if (!ManimUtil.isManimScene(sourceElement.get())) return false
        if (context.module == null) return false
        config.name = "Render " + (sourceElement.get() as PyClass).name!!
        config.runConfigSettings.filePath = file.path
        config.runConfigSettings.scene = (sourceElement.get() as PyClass).name!!
        config.runConfigSettings.playback = true
        return true
    }

    override fun isConfigurationFromContext(config: ManimRunConfig,
                                            context: ConfigurationContext): Boolean {
        val location = context.location ?: return false
        val file = location.virtualFile ?: return false
        if (location.psiElement !is PyClass) return false
        val sourceElement = location.psiElement as PyClass
        val settings = config.runConfigSettings
        return settings.filePath == file.path && settings.scene == sourceElement.name
    }
}
