package com.naveen.androidx.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.naveen.androidx.db.entity.User

/**
 * Created by Drish Infotech on 12/26/18.
This class is used in this project
 */
@Database(entities = arrayOf(User::class), version = 1)
abstract class AndroidXDataBase : RoomDatabase() {
    abstract fun userDao():UserDao
}