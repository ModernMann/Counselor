package com.example.myapplication

import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.view.View
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

    fun onClickEnter(view: View) {
        var users = ""


        try {
            
            val cursor: Cursor = mDb!!.rawQuery("Select ID_Users from Users", null)
            cursor.moveToFirst()
            while (!cursor.isAfterLast) {
                users += cursor.getString(1) + " | "
                cursor.moveToNext()
            }
            cursor.close()
            Toast.makeText(this,users,Toast.LENGTH_LONG).show()
        }
        catch (e: Exception){
            Toast.makeText(this,"Ошибка подключения к БД",Toast.LENGTH_LONG).show()
        }
    }
}