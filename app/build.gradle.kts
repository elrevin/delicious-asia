plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id(Config.hiltPlugin)
    kotlin("kapt")
}

android {
    namespace = Config.packageName
    compileSdk = Config.compileSdk

    defaultConfig {
        applicationId = Config.packageName
        minSdk = Config.minSdk
        targetSdk = Config.targetSdk
        versionCode = Config.versionCode
        versionName = Config.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

}

dependencies {

    implementation(project(Modules.core))
    implementation(project(Modules.coreUi))
    implementation(project(Modules.Onboarding.presentation))
    implementation(project(Modules.UserAccount.data))
    implementation(project(Modules.UserAccount.domain))
    implementation(project(Modules.UserAccount.presentation))
    implementation(project(Modules.Recipes.data))
    implementation(project(Modules.Recipes.domain))
    implementation(project(Modules.Recipes.presentation))

    implementation(Dependecies.Other.core)

    implementation(Dependecies.Lifecycle.lifecycleRuntime)
    implementation(Dependecies.Lifecycle.activity)

    implementation(platform(Dependecies.Compose.bom))
    implementation(Dependecies.Compose.ui)
    implementation(Dependecies.Compose.graphics)
    implementation(Dependecies.Compose.preview)
    implementation(Dependecies.Compose.material)
    implementation(Dependecies.Compose.navigation)


    implementation(Dependecies.Hilt.hilt)
    kapt(Dependecies.Hilt.kapt)

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
}