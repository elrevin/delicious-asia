class Dependecies {
    object Compose {
        const val bom = "androidx.compose:compose-bom:2023.08.00"

        const val ui = "androidx.compose.ui:ui"
        const val graphics = "androidx.compose.ui:ui-graphics"
        const val material = "androidx.compose.material3:material3"
        const val navigation = "androidx.navigation:navigation-compose:2.7.1"
        const val tooling = "androidx.compose.ui:ui-tooling"
        const val preview = "androidx.compose.ui:ui-tooling-preview"
    }

    object Lifecycle {
        private const val lifecycleVersion = "2.6.1"
        private const val composeViewModelVersion = "2.4.0-rc01"
        private const val activityVersion = "1.7.2"

        const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:$lifecycleVersion"
        const val lifecycleViewmodel = "androidx.lifecycle:lifecycle-viewmodel-compose:$composeViewModelVersion"
        const val activity = "androidx.activity:activity-compose:$activityVersion"
    }

    object Other {
        private const val coreVersion = "1.10.1"

        const val core = "androidx.core:core-ktx:$coreVersion"
        const val appcompat = "androidx.appcompat:appcompat:1.6.1"
    }

    object Hilt {
        const val version = "2.47"
        private const val navigationVersion = "1.0.0"

        const val hilt = "com.google.dagger:hilt-android:$version"
        const val kapt = "com.google.dagger:hilt-android-compiler:$version"
        const val navigation = "androidx.hilt:hilt-navigation-compose:$navigationVersion"
    }

    object Coil {
        const val version = "2.4.0"

        const val compose = "io.coil-kt:coil-compose:$version"
    }

    object Apollo {
        private const val version = "3.8.2"
        const val runtime = "com.apollographql.apollo3:apollo-runtime:${version}"
    }

    object Room {
        private const val version = "2.5.2"
        const val runtime = "androidx.room:room-runtime:${version}"
        const val compiler = "androidx.room:room-compiler:${version}"
        const val ktx = "androidx.room:room-ktx:${version}"
    }

}