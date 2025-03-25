package ch.fvj.mobpro

import android.content.Context
import ch.fvj.mobpro.database.AppDatabase
import ch.fvj.mobpro.repositories.UsersRepository

object DependencyProvider {
    fun provideUsersRepository(context: Context): UsersRepository {
        val userDao = AppDatabase.getDatabase(context).userDao()
        return UsersRepository(userDao)
    }
}