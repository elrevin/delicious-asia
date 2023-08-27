object Config {
    fun namespace(module: String) = "me.elrevin.${module}"
    const val packageName = "me.elrevin.deliciousasia"

    const val compileSdk = 34
    const val minSdk = 26
    const val targetSdk = 34

    const val versionCode = 1
    const val versionName = "1.0"

    const val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

    const val hiltPluginVlasspath = "com.google.dagger:hilt-android-gradle-plugin:${Dependecies.Hilt.version}"

    const val hiltPlugin = "com.google.dagger.hilt.android"
}