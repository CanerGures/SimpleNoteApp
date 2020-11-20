package com.example.simplenoteapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.simplenoteapp.R
import com.example.simplenoteapp.model.dbmodel.NoteModel
import kotlinx.android.synthetic.main.note_item.view.*

class NoteRecyclerViewAdapter(val notes: MutableList<NoteModel> = mutableListOf()) :
    RecyclerView.Adapter<NoteRecyclerViewAdapter.NotesViewHolder>() {

    inner class NotesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val noteTitle: TextView = itemView.noteTitle
        val noteText: TextView = itemView.noteText
        val noteDate: TextView = itemView.noteDate
        val noteImage: ImageView = itemView.noteImage

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.note_item, parent, false)
        return NotesViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        val currentItem = notes[position]
        holder.noteTitle.text = currentItem.title
        holder.noteText.text = currentItem.description
        holder.noteDate.text = currentItem.createDate
        Glide.with(holder.itemView.context)
            .load(currentItem.url)
            .fitCenter()
            .into(holder.noteImage)

    }

    override fun getItemCount(): Int {
        return notes.size
    }
}