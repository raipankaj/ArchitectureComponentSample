package sample.example.archcomponentsample.viewmodels

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import sample.example.archcomponentsample.data.UserRepository

class UserViewmodelFactory(val userRepository: UserRepository) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return UserViewModel(userRepository) as T
    }
}