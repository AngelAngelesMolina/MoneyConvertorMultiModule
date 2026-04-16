plugins {
  alias(libs.plugins.moneyconvertor.jvm)
  kotlin("plugin.serialization")
}

dependencies{
  implementation(libs.kotlin.serialization.json)


}
