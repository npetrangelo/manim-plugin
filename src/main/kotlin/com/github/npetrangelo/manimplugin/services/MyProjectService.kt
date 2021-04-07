package com.github.npetrangelo.manimplugin.services

import com.github.npetrangelo.manimplugin.MyBundle
import com.intellij.openapi.project.Project

class MyProjectService(project: Project) {

    init {
        println(MyBundle.msg("projectService", project.name))
    }
}
