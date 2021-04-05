package com.github.npetrangelo.manimplugin;

import com.intellij.execution.configurations.ConfigurationFactory;
import com.intellij.execution.configurations.ConfigurationType;
import com.intellij.icons.AllIcons;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class ManimConfigurationType implements ConfigurationType {

    @Override
    public @NotNull @Nls(capitalization = Nls.Capitalization.Title) String getDisplayName() {
        return "Manim";
    }

    @Override
    public @Nls(capitalization = Nls.Capitalization.Sentence) String getConfigurationTypeDescription() {
        return null;
    }

    @Override
    public Icon getIcon() {
        return AllIcons.General.Information;
    }

    @Override
    public @NotNull String getId() {
        return "Manim";
    }

    @Override
    public ConfigurationFactory[] getConfigurationFactories() {
        return new ConfigurationFactory[]{new ManimConfigurationFactory(this)};
    }
}
