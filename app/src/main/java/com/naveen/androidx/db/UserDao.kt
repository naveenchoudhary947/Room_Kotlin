package com.naveen.androidx.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.naveen.androidx.db.entity.User

/**
 * Created by Drish Infotech on 12/26/18.
This class is used in this project
 */
@Dao
interface UserDao {

    @Query("SELECT * FROM UserTbl")
    fun getAllUser(): LiveData<List<User>>

    @Insert
    fun insertUser(user: User)

    @Query("DELETE FROM UserTbl")
    fun deleteAllUsers()

}