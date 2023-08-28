pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "DeliciousAsia"
include(":app")
include(":feature_onboarding")
include(":feature_onboarding:onboarding_presentation")
include(":core_ui")
include(":feature_home_screen")
include(":feature_home_screen:home_screen_presentation")
include(":core")
