package com.info.todolist.fragments.add

import androidx.lifecycle.ViewModel
import com.info.todolist.repos.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddFragmentViewModel @Inject constructor(private val noteRepository: NoteRepository) :
    ViewModel() {

//    var noteAd = MutableLiveData<Note>()
//
//    fun addNote(note: Note){
//
//        viewModelScope.launch {
//
//            noteRepository.addNote(note)
//
//        }
//
//    }
//
//    fun back(){
//
//
//
//    }

}