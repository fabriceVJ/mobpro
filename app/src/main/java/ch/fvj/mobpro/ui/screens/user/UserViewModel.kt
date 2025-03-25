package ch.fvj.mobpro.ui.screens.user

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import ch.fvj.mobpro.DependencyProvider
import ch.fvj.mobpro.models.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class UserViewModel(application: Application): AndroidViewModel(application) {
    private val usersRepository = DependencyProvider.provideUsersRepository(application)
    private val _users = MutableStateFlow<List<User>>(emptyList())
    val users: StateFlow<List<User>> get() = _users


    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        viewModelScope.launch {
            _users.value = usersRepository.getAllUsers()
        }
    }
    fun addUser(user: User) {
        viewModelScope.launch {
            usersRepository.addUser(user)
            fetchUsers()
        }
    }

}