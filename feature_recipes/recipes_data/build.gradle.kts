plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("com.apollographql.apollo3").version("3.8.2")
    id(Config.hiltPlugin)
    kotlin("kapt")
}

android {
    namespace = Config.namespace("recipes_data")
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
    apollo {
        service("service") {
            packageName.set("me.elrevin.recipes_data")
            generateOptionalOperationVariables.set(false)
        }
    }
}

dependencies {
    implementation(project(Modules.core))
    implementation(project(Modules.Recipes.domain))
    implementation(project(Modules.apiSchema))
    apolloMetadata(project(Modules.apiSchema))

    implementation(Dependecies.Other.core)
    implementation(Dependecies.Other.appcompat)

    implementation(Dependecies.Hilt.hilt)
    kapt(Dependecies.Hilt.kapt)

    implementation(Dependecies.Apollo.runtime)


    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}