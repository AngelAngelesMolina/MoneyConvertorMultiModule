import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

/*Custom plugins*/
plugins {
    `kotlin-dsl`
}

group = "com.mc.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

//Configure compiler for kt
tasks.withType<KotlinCompile>().configureEach {
    compilerOptions {
        jvmTarget.set(JvmTarget.JVM_17)
    }
}
//validation for our custom plugins
//TODO: What is the purpose of this plugin?
tasks {
    validatePlugins {
        enableStricterValidation = true
        failOnWarning = true
    }
}