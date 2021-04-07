package com.github.npetrangelo.manimplugin

import com.github.npetrangelo.manimplugin.runconfig.ManimRunConfig
import com.github.npetrangelo.manimplugin.runconfig.ManimRunConfigType
import com.intellij.execution.actions.ConfigurationContext
import com.intellij.execution.actions.LazyRunConfigurationProducer
import com.intellij.execution.configurations.ConfigurationFactory
import com.intellij.openapi.util.Ref
import com.intellij.psi.PsiElement

class ManimRunConfigProducer() : LazyRunConfigurationProducer<ManimRunConfig>() {
    override fun getConfigurationFactory(): ConfigurationFactory {
        return ManimRunConfigType.getInstance().factory;
    }

    override fun setupConfigurationFromContext(config: ManimRunConfig, context: ConfigurationContext, sourceElement: Ref<PsiElement>): Boolean {
        TODO("Not yet implemented")
    }

    override fun isConfigurationFromContext(config: ManimRunConfig, context: ConfigurationContext): Boolean {
        TODO("Not yet implemented")
    }
}