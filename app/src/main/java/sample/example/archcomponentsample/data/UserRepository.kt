package sample.example.archcomponentsample.data

import android.arch.lifecycle.LiveData
import sample.example.archcomponentsample.AppExecutors
import sample.example.archcomponentsample.db.User
import sample.example.archcomponentsample.db.UserDao

class UserRepository(val userDao: UserDao) {

    fun getListOfAllUsers(): LiveData<List<User>> {
        return userDao.getAllUsersList()
    }

    fun getListOfUsers(): LiveData<User> {
        return userDao.getAllUsers()
    }

    fun insertUserDetails(user: User) {
        AppExecutors.diskIO().execute {
            userDao.insertUser(user)
        }
    }

    fun insertBulkUser(user: List<User>) {
        AppExecutors.diskIO().execute {
            userDao.insertBulkUsers(user)
        }
    }

}