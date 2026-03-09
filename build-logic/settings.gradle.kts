
dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
    //Define a version catalog for the project
    versionCatalogs {
        create("libs"){
            from(files("../gradle/libs.versions.toml"))
        }
    }
}

rootProject.name = "build-logic"
include(":convention")