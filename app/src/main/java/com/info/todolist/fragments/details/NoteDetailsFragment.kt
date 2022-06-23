package com.info.todolist.fragments.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.info.todolist.R
import com.info.todolist.databinding.FragmentNoteDetailsBinding

class NoteDetailsFragment : Fragment() {
    private lateinit var binding: FragmentNoteDetailsBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View? {
        binding = FragmentNoteDetailsBinding.inflate(inflater,container,false)

        binding.backImgBtn.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_noteDetailsFragment_to_homeFragment)
        }

        // Inflate the layout for this fragment
        return binding.root
    }

}