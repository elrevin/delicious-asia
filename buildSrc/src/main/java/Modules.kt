object Modules {
    const val app = ":app"
    const val core = ":core"
    const val coreUi = ":core_ui"
    const val apiSchema = ":api_schema"
    object Onboarding {
        const val presentation = ":feature_onboarding:onboarding_presentation"
    }
    object UserAccount {
        const val presentation = ":feature_user_account:user_account_presentation"
        const val data = ":feature_user_account:user_account_data"
        const val domain = ":feature_user_account:user_account_domain"
    }
    object Recipes {
        const val presentation = ":feature_recipes:recipes_presentation"
        const val data = ":feature_recipes:recipes_data"
        const val domain = ":feature_recipes:recipes_domain"
    }
}