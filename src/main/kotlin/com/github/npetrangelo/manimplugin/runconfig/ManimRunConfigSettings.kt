package com.github.npetrangelo.manimplugin.runconfig

import com.intellij.execution.configurations.CommandLineTokenizer
import com.intellij.openapi.util.JDOMExternalizerUtil
import org.jdom.Element

data class ManimRunConfigSettings(
        var filePath: String = "",
        var scene: String = "",
        var arguments: String = ""
) : Cloneable {
    /**
     * Returns the arguments field as a list of properly-delimited strings,
     * accounting for things like multi-word arguments in quotes.
     */
    fun getArgsAsList(): List<String> {
        val argsList = mutableListOf<String>()
        with(CommandLineTokenizer(arguments)) {
            while (hasMoreTokens()) {
                argsList.add(nextToken())
            }
        }
        return argsList
    }

    fun readFromElement(element: Element) {
        filePath = JDOMExternalizerUtil.readField(element, ManimRunConfigSettings::filePath.name).orEmpty()
        scene = JDOMExternalizerUtil.readField(element, ManimRunConfigSettings::scene.name).orEmpty()
        arguments = JDOMExternalizerUtil.readField(element, ManimRunConfigSettings::arguments.name).orEmpty()
    }

    fun writeToElement(element: Element) {
        JDOMExternalizerUtil.writeField(element, ManimRunConfigSettings::filePath.name, filePath)
        JDOMExternalizerUtil.writeField(element, ManimRunConfigSettings::scene.name, scene)
        JDOMExternalizerUtil.writeField(element, ManimRunConfigSettings::arguments.name, arguments)
    }

    public override fun clone() = (super.clone() as ManimRunConfigSettings).apply {}
}