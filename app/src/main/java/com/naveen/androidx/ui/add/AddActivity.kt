package com.naveen.androidx.ui.add

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.naveen.androidx.R
import com.naveen.androidx.db.entity.User
import kotlinx.android.synthetic.main.activity_add.*

class AddActivity : AppCompatActivity() {

    companion object {
        const val SAVE_USER = "com.naveen.androidx.ui.add.AddActivity.USER"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        saveButtom.setOnClickListener { saveUserData() }
    }

    private fun saveUserData() {
        val firstName = firstNameEditText.text.toString().trim()
        val lastName = lastNameEditText.text.toString().trim()
        val age = ageEditText.text.toString().trim()
        val mobile = mobileEditText.text.toString().trim()
        val password = passwordEditText.text.toString().trim()
        val address = addressEditText.text.toString().trim()

        when {
            firstName.isEmpty() -> showError(firstNameEditText)
            lastName.isEmpty() -> showError(lastNameEditText)
            age.isEmpty() -> showError(ageEditText)
            mobile.isEmpty() -> showError(mobileEditText)
            password.isEmpty() -> showError(passwordEditText)
            address.isEmpty() -> showError(addressEditText)

            else -> saveUser(
                firstName,
                lastName,
                age,
                mobile,
                password,
                address
            )
        }
    }

    private fun showError(view: EditText) {
        view.isFocusable = true
        view.error = "Field cannot be empty"

    }

    private fun saveUser(
        firstName: String,
        lastName: String,
        age: String,
        mobile: String,
        password: String,
        address: String
    ) {
        val user =
            User(0, firstName, lastName, age, mobile, password, address)// 0 primary key for auto increment
        val intent = Intent()
        intent.putExtra(SAVE_USER, user)
        setResult(Activity.RESULT_OK, intent)
        this@AddActivity.finish()
    }
}


