package com.naveen.androidx.ui.list

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.naveen.androidx.db.UserDao
import com.naveen.androidx.db.entity.User
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Drish Infotech on 12/26/18.
This class is used in this project
 */
@Singleton
class UserRepo @Inject constructor(private val userDao: UserDao) {


    fun getAll(): LiveData<List<User>> {
        Timber.i("Get Method")
        return userDao.getAllUser()
    }


    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insertUser(user: User) {
        Timber.i("Insert user ${user.firstName}")
        userDao.insertUser(user)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun deleteAllUser() {
        Timber.i("Delete all user")
        userDao.deleteAllUsers()
    }
}