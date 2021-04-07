package com.github.npetrangelo.manimplugin

import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory
import com.intellij.openapi.options.SettingsEditor
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.TextFieldWithBrowseButton
import com.intellij.ui.components.fields.ExpandableTextField
import com.intellij.ui.layout.panel
import javax.swing.JComponent
import javax.swing.JLabel

class ManimSettingsEditor(private val project : Project) : SettingsEditor<ManimConfig>() {
    private val fileLabel = JLabel("File:")
    private val fileText = TextFieldWithBrowseButton().apply {
        addBrowseFolderListener(
            "Select file",
            "Select the file that contains the scene you want to render.",
            project,
            FileChooserDescriptorFactory.createSingleFileDescriptor(".py")
        )
    }
    private val sceneLabel = JLabel("Scene:")
    private val sceneText = ExpandableTextField()

    override fun resetEditorFrom(m: ManimConfig) {
        fileText.text = m.runConfigSettings.filePath
        sceneText.text = m.runConfigSettings.scene
    }

    override fun applyEditorTo(m: ManimConfig) {
        m.runConfigSettings.filePath = fileText.text
        m.runConfigSettings.scene = sceneText.text
    }

    override fun createEditor(): JComponent = panel {
        row { fileLabel; fileText; }
        row { sceneLabel; sceneText; }
    }
}
