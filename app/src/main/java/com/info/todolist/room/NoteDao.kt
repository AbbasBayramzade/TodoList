package com.info.todolist.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.info.todolist.room.model.Note

@Dao
interface NoteDao {
    @Query("SELECT * FROM note_table")
    fun getAllNotes():List<Note>

    @Insert
    fun insertAll(vararg note: Note)

    @Query("DELETE FROM note_table WHERE noteId = :noteId ")
    fun deleteById(vararg noteId:Int):Int

    @Query("SELECT * FROM note_table WHERE noteId = :noteId")
    fun getNote(vararg noteId: Int?): Note

    @Update
    fun updateNote(vararg note: Note)
}