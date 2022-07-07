package com.info.todolist.fragments.home

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.info.todolist.databinding.NoteItemBinding
import com.info.todolist.room.model.Note
import java.util.*

class NoteAdapter(
    private val clickListener: NoteItemClickListener,
) : RecyclerView.Adapter<NoteAdapter.MyViewHolder>(), Filterable {


    private var notes = listOf<Note>()
    private var noteFilterList = listOf<Note>()

    fun setData(data: List<Note>) {
        notes = data
        noteFilterList = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(NoteItemBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(noteFilterList[position])
        holder.itemView.setOnClickListener {
            clickListener.onNoteItemClickListener(noteFilterList[position])
        }
    }

    override fun getItemCount(): Int {
        return noteFilterList.size
    }

    interface NoteItemClickListener {
        fun onNoteItemClickListener(note: Note)
    }

    class MyViewHolder(var view: NoteItemBinding) : RecyclerView.ViewHolder(view.root) {
        fun bind(note: Note) {
            view.apply {
                rcTxtviewTitle.text = note.title
                rcTxtviewDescription.text = note.description
            }
        }
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charSearch = constraint.toString()
                if (charSearch.isEmpty()) {
                    noteFilterList = notes
                } else {
                    val resultList = ArrayList<Note>()
                    for (row in notes) {
                        if (row.title.lowercase(Locale.ROOT)
                                .contains(charSearch.lowercase(Locale.ROOT))
                        ) {
                            resultList.add(row)
                        }
                    }
                    noteFilterList = resultList
                }
                val filterResults = FilterResults()
                filterResults.values = noteFilterList
                return filterResults
            }

            @Suppress("UNCHECKED_CAST")
            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                noteFilterList = results?.values as ArrayList<Note>
                notifyDataSetChanged()
            }
        }
    }

}