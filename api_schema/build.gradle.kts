plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("com.apollographql.apollo3").version("3.8.2")
    id(Config.hiltPlugin)
    kotlin("kapt")
}

android {
    namespace = Config.namespace("api_schema")
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
}

dependencies {
    implementation(project(":core"))

    implementation(Dependecies.Other.core)
    implementation(Dependecies.Other.appcompat)
    implementation(Dependecies.Apollo.runtime)

    implementation(Dependecies.Hilt.hilt)
    kapt(Dependecies.Hilt.kapt)

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}

apollo {
    service("service") {
        packageName.set("me.elrevin.api_schema")
        generateOptionalOperationVariables.set(false)
        generateApolloMetadata.set(true)
        alwaysGenerateTypesMatching.set(listOf("Query", "Mutation"))
    }
}