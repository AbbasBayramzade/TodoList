package com.info.todolist.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.info.todolist.room.model.Note

@Database(entities = [Note::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun notedao(): NoteDao
}