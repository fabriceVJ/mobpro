package ch.fvj.mobpro.repositories

import ch.fvj.mobpro.models.User
import ch.fvj.mobpro.models.UserDao

class UsersRepository (private val userDao: UserDao) {
    suspend fun getAllUsers(): List<User> = userDao.getAll()

    suspend fun addUser(user: User) {
        userDao.insert(user)
    }
}