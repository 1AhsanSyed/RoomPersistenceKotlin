package com.ahsan.roompersistencekotlin

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contact")
data class Contact(

    @PrimaryKey(autoGenerate = true)
    val id : Long,
    val name : String,
    val phone : String


) {
    override fun toString(): String {
        return "Contact(id=$id, name='$name', phone='$phone')"
    }
}


