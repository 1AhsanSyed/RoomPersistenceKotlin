package com.ahsan.roompersistencekotlin

import android.database.Cursor
import androidx.lifecycle.LiveData
import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface ContactDao {

    //suspend keyword shows this function runs on background
    @Insert
    suspend fun insertContact(contact: Contact)

    @Update
    suspend fun updateContact(contact: Contact)

    @Delete
    suspend fun deleteContact(contact: Contact)

    @Query("select * from contact")
    fun getContact() : LiveData<List<Contact>>

    @Query("select name from contact")
    fun getUserName() : LiveData<List<String>>

    @Query("select id from contact")
    fun getUserId() : LiveData<List<Int>>

    @Query("select phone from contact")
    fun  getUserPhoneNumber() : LiveData<List<String>>




/*
    @Query("SELECT * FROM contact WHERE name LIKE '%' || :search || '%'")
    fun searchKeyWord(search: String?): Flow<List<Contact>>


    @Query("Select * FROM contact where name = hanzala"  )
    fun getSearchedItem(identifier: String): String

    @Query("SELECT * FROM contact WHERE name =  name")
    fun getCompanies(companyName: String?): List<Contact?>?


    @Query("SELECT * FROM contact WHERE id > :minAge LIMIT 5")
    fun loadRawUsersOlderThan(minAge: Int): Cursor

*/



}