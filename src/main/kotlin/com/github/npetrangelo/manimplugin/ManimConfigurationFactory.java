package com.github.npetrangelo.manimplugin;

import com.intellij.execution.configurations.ConfigurationFactory;
import com.intellij.execution.configurations.ConfigurationType;
import com.intellij.execution.configurations.RunConfiguration;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;

public class ManimConfigurationFactory extends ConfigurationFactory {
    private static final String FACTORY_NAME = "Manim configuration factory";

    public ManimConfigurationFactory(ConfigurationType type) {
        super(type);
    }

    @Override
    public @NotNull RunConfiguration createTemplateConfiguration(@NotNull Project project) {
        return new ManimRunConfiguration(project, this, "Manim");
    }

    @Override
    public String getName() {
        return FACTORY_NAME;
    }
}
