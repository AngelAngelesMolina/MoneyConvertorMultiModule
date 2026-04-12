plugins{
    id("com.android.library")
    id("org.jetbrains.kotlin.plugin.compose")
    kotlin("plugin.serialization")

}

android{
    namespace = "com.mc.network"

    compileSdk {
        version = release(36) {
            minorApiLevel = 1
        }
    }

    defaultConfig {
        minSdk = 24
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    dependencies{
        implementation(libs.retrofit)
        implementation(libs.retrofit.logger)
        implementation(libs.retrofit.kotlin.serialization)
        implementation(libs.kotlin.serialization.json)
    }

}