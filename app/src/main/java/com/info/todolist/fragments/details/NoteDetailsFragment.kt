package com.info.todolist.fragments.details

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.info.todolist.R
import com.info.todolist.databinding.FragmentNoteDetailsBinding
import com.info.todolist.room.model.Note
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NoteDetailsFragment : Fragment() {
    private lateinit var binding: FragmentNoteDetailsBinding
    private val safeArgs: NoteDetailsFragmentArgs by navArgs()
    private val viewModel: NoteDetailsViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View {



        binding = FragmentNoteDetailsBinding.inflate(inflater,container,false)

        viewModel.getNote(noteId = safeArgs.id)

        viewModel.note.observe(viewLifecycleOwner){

            binding.apply {

                 etTitle.setText(it.title)
                 etDescription.setText(it.description)

            }

        }

        binding.imgDelete.setOnClickListener {

            val ad = AlertDialog.Builder(binding.root.context)
            ad.setTitle("Bu notunuz silinəcək")
            ad.setMessage("Silinsinmi?")
            ad.setIcon(R.drawable.logo)
            ad.setPositiveButton("Bəlİ"){View,dialogInterface ->
                viewModel.deleteNote(noteId = safeArgs.id)
                findNavController().popBackStack()
            }
            ad.setNegativeButton("Xeyr"){View,dialogInterface ->
                findNavController().popBackStack()
            }
            ad.create().show()

        }

        binding.imgEdit.setOnClickListener {
//            val note = Note(binding.etTitle.text.toString(),binding.etDescription.text.toString())
//            var a = binding.etTitle.text.toString()
//            var b = binding.etTitle.text.toString()
            var note = Note(title = binding.etTitle.setText("").toString(),binding.etDescription.setText("").toString())
            viewModel.editNote(note)

            findNavController().popBackStack()
        }

        Log.d("ABBAS =>", "NOTE idsi ${safeArgs.id}")
        binding.backImgBtn.setOnClickListener {
            findNavController().popBackStack()
        }

        // Inflate the layout for this fragment
        return binding.root
    }

}