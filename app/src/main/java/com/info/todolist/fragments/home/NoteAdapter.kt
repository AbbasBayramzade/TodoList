package com.info.todolist.fragments.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.info.todolist.databinding.NoteItemBinding
import com.info.todolist.room.model.Note

class NoteAdapter(
    private val clickListener: NoteItemClickListener,
    private val notes: List<Note>,
) : RecyclerView.Adapter<NoteAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(NoteItemBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(notes[position])
        holder.itemView.setOnClickListener {
            clickListener.onNoteItemClickListener(notes[position])
        }
//        holder.itemView.setOnClickListener {
//
//              Navigation.findNavController(it).navigate(R.id.action_homeFragment_to_noteDetailsFragment)
//        }
    }

    override fun getItemCount(): Int {
        return notes.size
    }

    interface NoteItemClickListener {
        fun onNoteItemClickListener(note: Note)
    }

    class MyViewHolder(var view: NoteItemBinding) : RecyclerView.ViewHolder(view.root) {
        //        val tvTitle:TextView = view.findViewById(R.id.rc_txtview_title)
//        val tvDesc:TextView = view.findViewById(R.id.rc_txtview_title)
        fun bind(note: Note) {
            view.apply {
                rcTxtviewTitle.text = note.title
                rcTxtviewDescription.text = note.description
            }
        }
    }

}