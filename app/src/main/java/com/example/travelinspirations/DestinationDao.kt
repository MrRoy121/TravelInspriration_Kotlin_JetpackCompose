package com.example.travelinspirations
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DestinationDao(private val context: Context) {
    private val dbHelper = DatabaseHelper(context)

    fun insert(destination: Destination): Long {
        val db = dbHelper.writableDatabase
        val values = ContentValues().apply {
            put("name", destination.name)
            put("description", destination.description)
            put("imageUrl", destination.imageUrl)
        }
        return db.insert("destinations", null, values)
    }

    fun getAll(): List<Destination> {
        val db = dbHelper.readableDatabase
        val cursor: Cursor = db.query("destinations", null, null, null, null, null, null)
        val destinations = mutableListOf<Destination>()
        with(cursor) {
            while (moveToNext()) {
                val id = getInt(getColumnIndexOrThrow("id"))
                val name = getString(getColumnIndexOrThrow("name"))
                val description = getString(getColumnIndexOrThrow("description"))
                val imageUrl = getString(getColumnIndexOrThrow("imageUrl"))
                destinations.add(Destination(id, name, description, imageUrl))
            }
        }
        cursor.close()
        return destinations
    }

    fun getById(id: Int): Destination? {
        val db = dbHelper.readableDatabase
        val cursor: Cursor = db.query(
            "destinations", null, "id=?", arrayOf(id.toString()),
            null, null, null
        )
        with(cursor) {
            if (moveToFirst()) {
                val name = getString(getColumnIndexOrThrow("name"))
                val description = getString(getColumnIndexOrThrow("description"))
                val imageUrl = getString(getColumnIndexOrThrow("imageUrl"))
                cursor.close()
                return Destination(id, name, description, imageUrl)
            }
        }
        cursor.close()
        return null
    }

    fun getFavorites(): List<Destination> {
        // Placeholder for fetching favorite destinations from the database
        return emptyList()
    }
}

