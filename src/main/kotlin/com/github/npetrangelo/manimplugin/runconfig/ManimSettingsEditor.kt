package com.github.npetrangelo.manimplugin.runconfig

import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory
import com.intellij.openapi.options.SettingsEditor
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.TextFieldWithBrowseButton
import com.intellij.ui.components.CheckBox
import com.intellij.ui.components.fields.ExpandableTextField
import com.intellij.ui.layout.panel
import javax.swing.JComponent

class ManimSettingsEditor(private val project : Project) : SettingsEditor<ManimRunConfig>() {
    private val fileText = TextFieldWithBrowseButton().apply {
        addBrowseFolderListener(
            "Select file",
            "Select the file that contains the scene you want to render.",
            project,
            FileChooserDescriptorFactory.createSingleFileDescriptor(".py")
        )
    }
    private val sceneText = ExpandableTextField()
    private val playback = CheckBox("Render with playback")

    override fun resetEditorFrom(m: ManimRunConfig) {
        fileText.text = m.runConfigSettings.filePath
        sceneText.text = m.runConfigSettings.scene
        playback.isSelected = m.runConfigSettings.playback
    }

    override fun applyEditorTo(m: ManimRunConfig) {
        m.runConfigSettings.filePath = fileText.text
        m.runConfigSettings.scene = sceneText.text
        m.runConfigSettings.playback = playback.isSelected
    }

    override fun createEditor(): JComponent = panel {
        row ("Select file") {
            fileText()
        }
        row ("Select scene") {
            sceneText()
        }
        row {
            playback()
        }
    }
}
