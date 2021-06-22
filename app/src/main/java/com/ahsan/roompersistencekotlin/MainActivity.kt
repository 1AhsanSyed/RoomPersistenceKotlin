package com.ahsan.roompersistencekotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.room.Room
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var  database : ContactDatabase
    lateinit var btnShow : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // for testing purpose, we need to create singleton object of this  database class
       /* database = Room.databaseBuilder(applicationContext,
                ContactDatabase::class.java,
                "contactDB").build()*/


        database = ContactDatabase.getDatabase(this)




//        coroutine thread
        GlobalScope.launch {

            database.contactDao().insertContact(Contact(0,"Hanzala","+12345678910"))
        }

        btnShow = findViewById(R.id.btnShow);
        btnShow.setOnClickListener(View.OnClickListener {

            database.contactDao().getContact().observe(this, {

                Log.e("ContactList", it.toString() + "")
            })


            database.contactDao().getUserName().observe(this, {

                Log.e("UserName", it.toString() )

            })

            database.contactDao().getUserId().observe(this, {

                Log.e("UserId", it.toString() )

            })


            database.contactDao().getUserPhoneNumber().observe(this, {

                Log.e("userPhoneNumber", it.toString() )

            })


        })





    }
}