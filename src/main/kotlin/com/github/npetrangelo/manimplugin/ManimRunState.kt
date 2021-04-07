package com.github.npetrangelo.manimplugin

import com.intellij.execution.ExecutionException
import com.intellij.execution.configurations.CommandLineState
import com.intellij.execution.configurations.GeneralCommandLine
import com.intellij.execution.process.KillableProcessHandler
import com.intellij.execution.process.ProcessHandler
import com.intellij.execution.runners.ExecutionEnvironment

class ManimRunState(
    private val manimRunConfig: ManimConfig,
    environment: ExecutionEnvironment?
) : CommandLineState(environment) {
    @Throws(ExecutionException::class)
    override fun startProcess(): ProcessHandler {
        val filePath = manimRunConfig.runConfigSettings.filePath
        val scene = manimRunConfig.runConfigSettings.scene
        val cmd = GeneralCommandLine("manim", filePath, scene)
        return KillableProcessHandler(cmd)
    }
}