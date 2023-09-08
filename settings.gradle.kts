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
include(":feature_user_account")
include(":feature_user_account:user_account_data")
include(":api_schema")
include(":feature_user_account:user_account_domain")
include(":core")
include(":feature_user_account:user_account_presentation")
include(":feature_recipes")
include(":feature_recipes:recipes_presentation")
include(":feature_recipes:recipes_data")
include(":feature_recipes:recipes_domain")
