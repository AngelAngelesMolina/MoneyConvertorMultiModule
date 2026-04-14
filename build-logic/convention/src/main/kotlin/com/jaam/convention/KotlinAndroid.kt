package com.jaam.convention

import org.gradle.api.Project
import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.JavaVersion
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

//internal for just this module
internal fun Project.configureKotlinAndroid() {
    extensions.configure<LibraryExtension> {
        compileSdk {
            version = release(36) {
                minorApiLevel = 1
            }
        }
        defaultConfig {
            minSdk = 24
            testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
            vectorDrawables {
                useSupportLibrary = true
            }
        }

        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_11
            targetCompatibility = JavaVersion.VERSION_11
        }

        configureKotlin()
    }
}

/*CONFIGURE BASE KOTLIN OPTIONS*/
private fun Project.configureKotlin() {
    tasks.withType<KotlinCompile>().configureEach {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)

            val warningsAsErrors = project.findProperty("warningsAsErrors") as String?
            allWarningsAsErrors.set(warningsAsErrors.toBoolean())
            freeCompilerArgs.addAll(
                "-opt-in=kotlinx.coroutines.ExperimentalCoroutinesApi"
            )
        }
    }
}