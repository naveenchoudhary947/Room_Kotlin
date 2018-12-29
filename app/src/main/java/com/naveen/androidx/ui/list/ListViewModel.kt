package com.naveen.androidx.ui.list

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.naveen.androidx.db.entity.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

/**
 * Created by Drish Infotech on 12/26/18.
This class is used in this project
 */
class ListViewModel @Inject constructor(
    val userRepo: UserRepo,
    application: Application
) :
    AndroidViewModel(application) {

    private val privateJob = Job()
    private val coroutineContext: CoroutineContext
        get() = privateJob + Dispatchers.Main
    private val scope = CoroutineScope(coroutineContext)

    @Suppress("JoinDeclarationAndAssignment")
    val allUser: LiveData<List<User>>


    init {
        allUser = userRepo.getAll()
    }

    fun insertUser(user: User) = scope.launch(Dispatchers.IO) {
        userRepo.insertUser(user)
    }


    fun deleteAllUsers() = scope.launch(Dispatchers.IO) {
        userRepo.deleteAllUser()
    }


}