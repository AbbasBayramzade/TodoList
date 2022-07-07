package com.info.todolist.fragments.add

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.Navigation
import androidx.room.Room
import com.info.todolist.R
import com.info.todolist.databinding.FragmentAddBinding
import com.info.todolist.repos.NoteRepository
import com.info.todolist.room.AppDatabase
import com.info.todolist.room.model.Note
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddFragmentViewModel @Inject constructor(private val noteRepository: NoteRepository) : ViewModel() {

    fun addNote(note: Note){
        viewModelScope.launch(Dispatchers.IO) {
            noteRepository.addNote(note)
        }
    }
}