package ch.fvj.mobpro.repositories

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import ch.fvj.mobpro.models.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserRepository(private val context: Context) {


    val user: Flow<User> = context.dataStore.data.map { preferences ->
        val userName = preferences[PreferenceKeys.USER_NAME] ?: ""
        val userAge = preferences[PreferenceKeys.USER_AGE] ?: -1
        val userAuthorized = preferences[PreferenceKeys.USER_AUTHORIZED] ?: false
        User(
            name = userName, age = userAge, authorized = userAuthorized
        )
    }

    suspend fun setUserName(name: String) {
        context.dataStore.edit { preferences ->
            preferences[PreferenceKeys.USER_NAME] = name
        }
    }

    suspend fun setUserAge(age: Int) {
        context.dataStore.edit { preferences ->
            preferences[PreferenceKeys.USER_AGE] = age
        }
    }

    suspend fun setUserAuthorized(authorized: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[PreferenceKeys.USER_AUTHORIZED] = authorized
        }
    }

    companion object {
        private const val USER_PREFERENCES_NAME = "user_preferences"
        private val Context.dataStore by preferencesDataStore(name = USER_PREFERENCES_NAME)
    }


}

private object PreferenceKeys {
    val USER_NAME = stringPreferencesKey("user_name")
    val USER_AGE = intPreferencesKey("user_age")
    val USER_AUTHORIZED = booleanPreferencesKey("user_authorized")

}