plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id(Config.hiltPlugin)
    kotlin("kapt")
}

android {
    namespace = Config.namespace("recipes_presentation")
    compileSdk = Config.compileSdk

    defaultConfig {
        minSdk = Config.minSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlin {
        jvmToolchain(17)
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
}

dependencies {
    implementation(project(Modules.core))
    implementation(project(Modules.coreUi))
    implementation(project(Modules.Recipes.domain))

    implementation(Dependecies.Other.core)
    implementation(Dependecies.Other.appcompat)

    implementation(platform(Dependecies.Compose.bom))
    implementation(Dependecies.Compose.ui)
    implementation(Dependecies.Compose.graphics)
    implementation(Dependecies.Compose.preview)
    implementation(Dependecies.Compose.navigation)
    implementation(Dependecies.Compose.material)
    implementation(Dependecies.Coil.compose)

    implementation(Dependecies.Hilt.hilt)
    implementation(Dependecies.Hilt.navigation)
    kapt(Dependecies.Hilt.kapt)

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}