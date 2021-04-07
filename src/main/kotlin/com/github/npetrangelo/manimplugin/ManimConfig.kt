package com.github.npetrangelo.manimplugin

import com.intellij.execution.Executor
import com.intellij.execution.configurations.ConfigurationFactory
import com.intellij.execution.configurations.LocatableConfigurationBase
import com.intellij.execution.configurations.RunConfiguration
import com.intellij.execution.configurations.RunProfileState
import com.intellij.execution.runners.ExecutionEnvironment
import com.intellij.openapi.options.SettingsEditor
import com.intellij.openapi.project.Project
import org.jdom.Element

class ManimConfig(
        project: Project,
        factory: ConfigurationFactory,
        name: String?
) : LocatableConfigurationBase<RunProfileState>(project, factory, name) {
    var runConfigSettings = ManimConfigSettings()

    override fun getState(executor: Executor, environment: ExecutionEnvironment): RunProfileState? {
        return ManimRunState(this, environment)
    }

    override fun getConfigurationEditor(): SettingsEditor<out RunConfiguration?> {
        return ManimSettingsEditor(this.project)
    }

    /**
     * This READS any prior persisted configuration from the State/Storage defined by this classes annotations.
     */
    override fun readExternal(element: Element) {
        super.readExternal(element)
        runConfigSettings.readFromElement(element)
    }

    /**
     * This WRITES/persists configurations TO the State/Storage defined by this classes annotations.
     */
    override fun writeExternal(element: Element) {
        super.writeExternal(element)
        runConfigSettings.writeToElement(element)
    }

    /**
     * Must override clone so that a deep-copy of runConfigSettings is made when generating from template
     */
    override fun clone() = (super.clone() as ManimConfig).apply {
        runConfigSettings = runConfigSettings.clone()
    }
}