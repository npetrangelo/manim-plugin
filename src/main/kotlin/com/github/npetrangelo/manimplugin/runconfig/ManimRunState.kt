package com.github.npetrangelo.manimplugin.runconfig

import com.intellij.execution.ExecutionException
import com.intellij.execution.configurations.CommandLineState
import com.intellij.execution.configurations.GeneralCommandLine
import com.intellij.execution.process.KillableProcessHandler
import com.intellij.execution.process.ProcessHandler
import com.intellij.execution.runners.ExecutionEnvironment

class ManimRunState(
        private val manimRunConfig: ManimRunConfig,
        environment: ExecutionEnvironment?
) : CommandLineState(environment) {
    @Throws(ExecutionException::class)
    override fun startProcess(): ProcessHandler {
        val filePath = manimRunConfig.runConfigSettings.filePath
        val scene = manimRunConfig.runConfigSettings.scene
        val flags = getFlags(manimRunConfig.runConfigSettings)
        val cmd = GeneralCommandLine("manim", filePath, scene, flags)
        return KillableProcessHandler(cmd)
    }

    private fun getFlags(settings: ManimRunConfigSettings): String {
        val playback = if (settings.playback) "p" else ""
        val flags = "-$playback"
        return if (flags == "-") "" else flags
    }
}