package com.example.travelinspirations

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("CREATE TABLE destinations (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, description TEXT, imageUrl TEXT)")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS destinations")
        onCreate(db)
    }

    companion object {
        private const val DATABASE_NAME = "travelinspirations.db"
        private const val DATABASE_VERSION = 1
    }
}
