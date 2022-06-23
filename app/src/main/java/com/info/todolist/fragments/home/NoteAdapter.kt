package com.info.todolist.fragments.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.info.todolist.R
import com.info.todolist.room.model.Note

class NoteAdapter(private val notes:List<Note>, val context: Context):RecyclerView.Adapter<NoteAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(context).inflate(R.layout.note_item,parent,false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tvTitle.text = notes[position].title
        holder.tvDesc.text = notes[position].description
        holder.itemView.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_homeFragment_to_noteDetailsFragment)
        }
    }

    override fun getItemCount(): Int {
        return notes.size
    }

    class MyViewHolder(view:View):RecyclerView.ViewHolder(view){
        val tvTitle:TextView = view.findViewById(R.id.rc_txtview_title)
        val tvDesc:TextView = view.findViewById(R.id.rc_txtview_title)
    }

}