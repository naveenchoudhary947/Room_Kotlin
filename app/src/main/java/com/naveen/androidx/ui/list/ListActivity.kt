package com.naveen.androidx.ui.list

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.naveen.androidx.R
import com.naveen.androidx.db.entity.User
import com.naveen.androidx.ui.add.AddActivity
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_list.*
import timber.log.Timber
import javax.inject.Inject

class ListActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var listViewModel: ListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        AndroidInjection.inject(this)
        setSupportActionBar(toolbar)

        val (w, x, y, z) = listOf(1, 2, 3, 4)
        println(w)
        println(x)

        fab.setOnClickListener {
            showDialog()
        }


        listViewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(ListViewModel::class.java)

        listViewModel.allUser.observe(this, Observer { list ->
            list?.let {
                Timber.i("THE SIZE OF LIST : ${list.size}")
            }
        }
        )


    }

    private fun showDialog(){
        val alertDialog = AlertDialog.Builder(this)
            .setMessage("Add or Delete user")
            .setNegativeButton("Delete") { _, _ ->
                // User clicked OK button
                listViewModel.deleteAllUsers()
            }
            .setPositiveButton("Add") { _, _ ->
                // User clicked OK button
                startActivityForResult(Intent(this,AddActivity::class.java), GET_NEW_USER)
            }
            .create()
        alertDialog.show()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == GET_NEW_USER && resultCode == Activity.RESULT_OK) {
            val user = data?.getParcelableExtra<User>(AddActivity.SAVE_USER)
            if (user != null) {
                listViewModel.insertUser(user)
            }

        }
    }

    companion object {
        const val GET_NEW_USER = 123
    }
}