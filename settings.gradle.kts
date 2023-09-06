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
include(":feature_view_recipes")
include(":feature_view_recipes:view_recipes_data")
include(":feature_user_account")
include(":feature_user_account:user_account_data")
include(":feature_view_recipes:view_recipes_presentation")
include(":api_schema")
include(":feature_user_account:user_account_domain")
include(":core")
include(":feature_user_account:user_account_presentation")
