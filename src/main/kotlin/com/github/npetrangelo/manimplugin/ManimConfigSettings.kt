package com.github.npetrangelo.manimplugin

import com.intellij.execution.configurations.CommandLineTokenizer
import com.intellij.openapi.util.JDOMExternalizerUtil
import org.jdom.Element

data class ManimConfigSettings(
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
        filePath = JDOMExternalizerUtil.readField(element, ManimConfigSettings::filePath.name).orEmpty()
        scene = JDOMExternalizerUtil.readField(element, ManimConfigSettings::scene.name).orEmpty()
        arguments = JDOMExternalizerUtil.readField(element, ManimConfigSettings::arguments.name).orEmpty()
    }

    fun writeToElement(element: Element) {
        JDOMExternalizerUtil.writeField(element, ManimConfigSettings::filePath.name, filePath)
        JDOMExternalizerUtil.writeField(element, ManimConfigSettings::scene.name, scene)
        JDOMExternalizerUtil.writeField(element, ManimConfigSettings::arguments.name, arguments)
    }

    public override fun clone() = (super.clone() as ManimConfigSettings).apply {}
}