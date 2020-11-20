package com.example.simplenoteapp.model.dbmodel

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note_data_table")
data class NoteModel(
    @PrimaryKey(autoGenerate = true)
    val noteId: Int,
    @ColumnInfo(name = "note_title")
    val title: String,
    @ColumnInfo(name = "note_desc")
    val description: String,
    @ColumnInfo(name = "note_date")
    val createDate: String,
    @ColumnInfo(name = "note_edited")
    val edited: Boolean,
    @ColumnInfo(name = "image_url")
    val url: String
)