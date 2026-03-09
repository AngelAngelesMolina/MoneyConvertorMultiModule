import org.gradle.kotlin.dsl.task

plugins{
    `kotlin-dsl`
}

group = "com.mc.buildlogic"

java(){
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}
//task.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
//    kotlinOptions {
//        jvmTarget = "17"
//    }
//}