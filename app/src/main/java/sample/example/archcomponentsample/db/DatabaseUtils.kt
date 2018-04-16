package sample.example.archcomponentsample.db

import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

object DatabaseUtils {

    fun getUserDatabase(context: Context): UserDao {
        return Room.databaseBuilder(context, UserDatabase::class.java,"user-database").build().userDao()
    }
}