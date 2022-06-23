package com.info.todolist.repos

import com.info.todolist.room.NoteDao
import com.info.todolist.room.model.Note
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class NoteRepository @Inject constructor(
    private val noteDao: NoteDao
) {

    suspend fun getAllNotes(): Flow<List<Note>> {
        return flow {
            val result = noteDao.getAllNotes()
            emit(result)
        }.flowOn(Dispatchers.IO)
    }
}