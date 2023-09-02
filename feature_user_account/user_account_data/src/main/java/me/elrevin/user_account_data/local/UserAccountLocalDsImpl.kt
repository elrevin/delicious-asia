package me.elrevin.user_account_data.local

import android.content.SharedPreferences
import me.elrevin.user_account_data.entity.UserEntity

class UserAccountLocalDsImpl(
    private val sharedPreferences: SharedPreferences
) : UserAccountLocalDs {
    override fun getUser(): UserEntity? =
        if (
            sharedPreferences.contains("userName") &&
            sharedPreferences.contains("userToken") &&
            sharedPreferences.getString("userName", "")!!.isNotEmpty() &&
            sharedPreferences.getString("userToken", "")!!.isNotEmpty()
        )
            UserEntity(
                name = sharedPreferences.getString("userName", "")!!,
                token = sharedPreferences.getString("userToken", "")!!
            )
        else null
}