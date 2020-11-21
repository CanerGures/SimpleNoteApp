package com.example.simplenoteapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.simplenoteapp.R
import com.example.simplenoteapp.model.dbmodel.NoteModel
import kotlinx.android.synthetic.main.note_item.view.*

class NoteRecyclerViewAdapter(
    val notes: MutableList<NoteModel> = mutableListOf(),
    private val listener: (NoteModel) -> Unit
) :
    RecyclerView.Adapter<NoteRecyclerViewAdapter.NotesViewHolder>() {

    inner class NotesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val noteTitle: TextView = itemView.noteTitle
        val noteText: TextView = itemView.noteText
        val noteDate: TextView = itemView.noteDate
        val noteUpdatedDate: TextView = itemView.noteUpdatedDate
        val noteUpdatedDateText: TextView = itemView.noteUpdatedDateText
        val noteImage: ImageView = itemView.noteImage
        val updatedInfoIcon: ImageView = itemView.infoIcon
        val parentCard: CardView = itemView.parentItemCard

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.note_item, parent, false)
        return NotesViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        val currentItem = notes[position]
        holder.parentCard.animation =
            AnimationUtils.loadAnimation(holder.itemView.context, R.anim.anim_item_list)

        holder.noteTitle.text = currentItem.title
        holder.noteText.text = currentItem.description
        holder.noteDate.text = currentItem.createDate
        if (currentItem.edited) {
            holder.noteUpdatedDate.text = currentItem.updatedDate
            holder.noteUpdatedDate.visibility = View.VISIBLE
            holder.noteUpdatedDateText.visibility = View.VISIBLE
            holder.updatedInfoIcon.visibility = View.VISIBLE
        }

        Glide.with(holder.itemView.context)
            .load(currentItem.url)
            .fitCenter()
            .into(holder.noteImage)

        itemClick(holder, currentItem)

    }

    override fun getItemCount(): Int {
        return notes.size
    }

    private fun itemClick(holder: NotesViewHolder, currentItem: NoteModel) {
        holder.itemView.setOnClickListener {
            listener(currentItem)
        }
    }
}