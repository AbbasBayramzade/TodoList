package com.info.todolist.fragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.info.todolist.R
import com.info.todolist.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment

        binding = FragmentHomeBinding.inflate(inflater, container, false)

        //set adapter

        binding.apply {
            recyclerview.layoutManager = LinearLayoutManager(context)
            recyclerview.adapter = NoteAdapter(viewModel.notes, binding.root.context)

            btnFab.setOnClickListener {
                Navigation.findNavController(it).navigate(R.id.action_homeFragment_to_addFragment)
            }
        }

        return binding.root
    }

}