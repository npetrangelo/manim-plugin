package com.github.npetrangelo.manimplugin

import com.intellij.execution.configurations.ConfigurationFactory
import com.intellij.execution.configurations.RunConfiguration
import com.intellij.execution.configurations.SimpleConfigurationType
import com.intellij.execution.configurations.runConfigurationType
import com.intellij.icons.AllIcons
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.NotNullLazyValue

class ManimConfigType : SimpleConfigurationType(
        id = ID,
        name = "Manim",
        icon = NotNullLazyValue.createValue {  AllIcons.General.Information }
) {
    val factory: ConfigurationFactory get() = configurationFactories.single()

    companion object {
        const val ID = "Manim"

        fun getInstance() = runConfigurationType<ManimConfigType>()
    }

    override fun createTemplateConfiguration(project: Project): RunConfiguration {
        return ManimConfig(project, this, name)
    }
}