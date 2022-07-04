package com.info.todolist.fragments.details

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
class NoteDetailsViewModel @Inject constructor(private val noteRepository:NoteRepository):ViewModel() {

    var note = MutableLiveData<Note>()

    fun getNote(noteId:Int){
        viewModelScope.launch {

            noteRepository.getNote(noteId = noteId ).collect(){
                note.value = it
            }
        }


    }

    fun deleteNote(noteId: Int){

        viewModelScope.launch {
            noteRepository.deleteNote(noteId = noteId)
        }

    }

    fun editNote(note: Note){
        viewModelScope.launch {
            noteRepository.editNote(note)
        }
    }

}