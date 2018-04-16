package sample.example.archcomponentsample.db

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface UserDao {

    @Insert
    fun insertUser(user: User)

    @Insert
    fun insertBulkUsers(user: List<User>)

    @Query("SELECT * FROM user WHERE id = :user_id")
    fun getUserBasedOnId(user_id: Int): User

    @Query("SELECT * FROM user")
    fun getAllUsers(): LiveData<User>

    @Query("SELECT * FROM user")
    fun getAllUsersList(): LiveData<List<User>>
}