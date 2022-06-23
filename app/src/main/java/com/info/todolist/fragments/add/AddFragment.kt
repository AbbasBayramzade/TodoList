package com.info.todolist.fragments.add

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.room.Room
import com.info.todolist.room.AppDatabase
import com.info.todolist.room.model.Note
import com.info.todolist.R
import com.info.todolist.databinding.FragmentAddBinding

class AddFragment : Fragment() {

    private lateinit var binding: FragmentAddBinding //? = null
//    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View? {

        binding = FragmentAddBinding.inflate(inflater,container,false)

        val db: AppDatabase = Room.databaseBuilder(context!!, AppDatabase::class.java,"notes")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
        
        binding.imgSave.setOnClickListener { 
            if (binding.edttxtTitle.text.isEmpty() || binding.edttxtTyping.text.isEmpty()){
                Toast.makeText(context, "bos biraxmaginen", Toast.LENGTH_SHORT).show()
            }else{
                val note: Note = Note(binding.edttxtTitle.text.toString(),binding.edttxtTyping.text.toString())
                db.notedao().insertAll(note)
                Navigation.findNavController(it).navigate((R.id.action_addFragment_to_homeFragment))
            }
        }

        binding.backImgBtn.setOnClickListener {

            Navigation.findNavController(it).navigate(R.id.action_addFragment_to_homeFragment)

        }

        return binding.root

    }
}