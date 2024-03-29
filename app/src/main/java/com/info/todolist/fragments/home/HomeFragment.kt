package com.info.todolist.fragments.home

import android.annotation.TargetApi
import android.app.Activity
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.info.todolist.R
import com.info.todolist.databinding.FragmentHomeBinding
import com.info.todolist.room.model.Note
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(), NoteAdapter.NoteItemClickListener {
    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by viewModels()

    private var adapter = NoteAdapter(this)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment

        binding = FragmentHomeBinding.inflate(inflater, container, false)

        //set adapter

        binding.apply {

            viewModel.notes.observe(viewLifecycleOwner) {
                recyclerview.layoutManager = LinearLayoutManager(context)
                adapter.setData(it)
                recyclerview.adapter = adapter
            }

            btnFab.setOnClickListener {
                Navigation.findNavController(it).navigate(R.id.action_homeFragment_to_addFragment)
            }

        }

        binding.searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.filter.filter(newText)
                return false
            }
        })

        return binding.root

        //searchview


    }

    override fun onNoteItemClickListener(note: Note) {
        findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToNoteDetailsFragment(note.noteId))
    }

    override fun onResume() {
        super.onResume()
        viewModel.getAllNotes()
    }

//    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
//        inflater.inflate(R.menu.menu_fragment,menu)
//
//        val searchItem = menu.findItem(R.id.action_search)
//        val searchView = searchItem.actionView as SearchView
//
//        searchView.onQueryTextChanged {
//            //update search query
//
//        }
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        return when(item.itemId){
//
//            R.id.action_mode ->{
//
//                true
//
//            }
//
//            R.id.action_sign_in ->{
//
//                true
//
//            }
//
//            R.id.action_sign_up ->{
//
//                true
//
//            }else -> super.onOptionsItemSelected(item)
//
//
//        }
//    }

}