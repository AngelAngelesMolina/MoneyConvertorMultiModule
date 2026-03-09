plugins{
    id("com.android.library")
    id("org.jetbrains.kotlin.plugin.compose")
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

}