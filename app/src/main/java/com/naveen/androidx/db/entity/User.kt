package com.naveen.androidx.db.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

/**
 * Created by Drish Infotech on 12/26/18.
This class is used in this project
 */
@Parcelize
@Entity(tableName = "UserTbl")
data class User(
    @PrimaryKey(autoGenerate = true) var uid: Int,
    @ColumnInfo(name = "FirstName") var firstName: String,
    @ColumnInfo(name = "LastName") var lastName: String,
    @ColumnInfo(name = "Age") var age: String,
    @ColumnInfo(name = "Mobile") var mobile: String,
    @ColumnInfo(name = "Password") var password: String,
    @ColumnInfo(name = "Address") var address: String
) : Parcelable