package sample.example.archcomponentsample.viewmodels

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import sample.example.archcomponentsample.AppExecutors
import sample.example.archcomponentsample.data.UserRepository
import sample.example.archcomponentsample.db.User

class UserViewModel(val userRepository: UserRepository) : ViewModel() {

    private val userInfo: MutableLiveData<User> = MutableLiveData()

    fun getAllUsersList(): LiveData<List<User>> = userRepository.getListOfAllUsers()

    fun getUsersList(): LiveData<User> {
        return userRepository.getListOfUsers()
    }

    fun insertUser(user: User) {
        userRepository.insertUserDetails(user)
    }

    fun insertListOfUsers(user: List<User>) {
        userRepository.insertBulkUser(user)
    }

}