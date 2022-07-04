package com.info.todolist.fragments.home

import androidx.lifecycle.MutableLiveData
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
    var notes = MutableLiveData<List<Note>>()

     fun getAllNotes() {
        viewModelScope.launch {
            noteRepository.getAllNotes().collect() {
                notes.value = it
            }
        }
    }
}