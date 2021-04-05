package com.github.npetrangelo.manimplugin.services

import com.github.npetrangelo.manimplugin.MyBundle
import com.intellij.openapi.project.Project

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
