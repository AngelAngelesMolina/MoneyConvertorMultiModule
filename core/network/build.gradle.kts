plugins{
    //!! commented for customAndroidLibrary plugin
/*    id("com.android.library")
    id("org.jetbrains.kotlin.plugin.compose")
    kotlin("plugin.serialization")*/
    //** 1. Normal customPlugin
    //id("moneyConvertor.android.library")
    //** 2.  libs catalog -> go to libs.versions.toml
    alias(libs.plugins.moneyConvertor.android.library)

}

android{
    namespace = "com.mc.network"

    /*compileSdk {
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
    }*/

}