package com.info.todolist.fragments.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.info.todolist.repos.NoteRepository
import com.info.todolist.room.model.Note
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val noteRepository: NoteRepository) : ViewModel() {

    //create a notes in list
    var notes = listOf<Note>()

    init {
        getAllNotes()
    }



    private fun getAllNotes() {
        viewModelScope.launch {
            noteRepository.getAllNotes().collect() {
                notes = it
            }
        }
//        val db: AppDatabase =
//            Room.databaseBuilder(getApplication(), AppDatabase::class.java, "notes")
//                .allowMainThreadQueries()
//                .fallbackToDestructiveMigration()
//                .build()

        //get a notes
//        notes = db.notedao().getAllNotes()
    }
}