package com.github.npetrangelo.manimplugin

import com.github.npetrangelo.manimplugin.runconfig.ManimRunConfig
import com.github.npetrangelo.manimplugin.runconfig.ManimRunConfigSettings
import com.github.npetrangelo.manimplugin.runconfig.ManimRunConfigType
import com.intellij.execution.actions.ConfigurationContext
import com.intellij.execution.actions.LazyRunConfigurationProducer
import com.intellij.execution.configurations.ConfigurationFactory
import com.intellij.execution.configurations.RunnerSettings
import com.intellij.openapi.actionSystem.PlatformDataKeys
import com.intellij.openapi.editor.impl.EditorComponentImpl
import com.intellij.openapi.util.Ref
import com.intellij.psi.PsiElement
import com.intellij.psi.templateLanguages.TemplateLanguageFileViewProvider

class ManimRunConfigProducer() : LazyRunConfigurationProducer<ManimRunConfig>() {
    override fun getConfigurationFactory(): ConfigurationFactory {
        return ManimRunConfigType.getInstance().factory;
    }

    override fun setupConfigurationFromContext(config: ManimRunConfig, context: ConfigurationContext, sourceElement: Ref<PsiElement>): Boolean {
        val location = context.location ?: return false
        val element = location.psiElement
        val psiFile = element.containingFile ?: return false
        if (psiFile.viewProvider is TemplateLanguageFileViewProvider) {
            return false
        }

        val dataContext = context.dataContext
        val contextComponent = PlatformDataKeys.CONTEXT_COMPONENT.getData(dataContext)
        if (contextComponent is EditorComponentImpl) {
            return false
        }

        TODO("Copy RPlugin")
    }

    override fun isConfigurationFromContext(config: ManimRunConfig, context: ConfigurationContext): Boolean {
        TODO("Not yet implemented")
    }
}