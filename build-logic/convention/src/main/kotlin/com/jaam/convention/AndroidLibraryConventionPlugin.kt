package com.jaam.convention

import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

//Our fist cumtom plugin
class AndroidLibraryConventionPlugin : Plugin<Project> { //You build a plugin into other plugin
    override fun apply(target: Project) {
        /*id("com.android.library")
        id("org.jetbrains.kotlin.plugin.compose")*/
        with(target) {
            with(pluginManager) {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.plugin.compose")
            }

            //Here we are going to configure kind of module
            //We need to add an extension en gradlePlugin
            extensions.configure<LibraryExtension> {
                //new we can apply this for every module but we need to register
                // n build.gradle.kts (convention)
                configureKotlinAndroid()
            }
        }
    }

}