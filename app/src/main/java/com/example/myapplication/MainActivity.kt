package com.example.myapplication

import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private var mDBHelper: DatabaseHelper? = null
    private val mDb: SQLiteDatabase? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mDBHelper =  DatabaseHelper(this)
        try {
            mDBHelper!!.updateDataBase()
        }
        catch (e: Exception) {
            Toast.makeText(this,"Невозможно обновить БД",Toast.LENGTH_SHORT).show()
        }
    }
}