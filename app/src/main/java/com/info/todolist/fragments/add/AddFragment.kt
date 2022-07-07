package com.info.todolist.fragments.add

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.info.todolist.room.AppDatabase
import com.info.todolist.room.model.Note
import com.info.todolist.R
import com.info.todolist.databinding.FragmentAddBinding
import com.info.todolist.fragments.details.NoteDetailsViewModel
import dagger.hilt.android.AndroidEntryPoint
import okhttp3.internal.notify

@AndroidEntryPoint
class AddFragment : Fragment() {

    private lateinit var binding: FragmentAddBinding //? = null
//    private val binding get() = _binding!!

    private val viewModel: AddFragmentViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View? {

        binding = FragmentAddBinding.inflate(inflater,container,false)

        binding.imgSave.setOnClickListener {
            if (binding.edttxtTitle.text.isEmpty() || binding.edttxtTyping.text.isEmpty()){
                Toast.makeText(context, "boş buraxmaginən", Toast.LENGTH_SHORT).show()
            }else{
                val note: Note = Note(binding.edttxtTitle.text.toString(),binding.edttxtTyping.text.toString())
                viewModel.addNote(note)
                Navigation.findNavController(it).navigate((R.id.action_addFragment_to_homeFragment))
            }
        }

        binding.backImgBtn.setOnClickListener {

            Navigation.findNavController(it).navigate(R.id.action_addFragment_to_homeFragment)

        }

        return binding.root

    }
}