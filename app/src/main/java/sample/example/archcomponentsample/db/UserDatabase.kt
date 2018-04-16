package sample.example.archcomponentsample.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

@Database(entities = arrayOf(User::class), version = 1)
abstract class UserDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
}