package com.example.simplenoteapp.model.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.simplenoteapp.model.dbmodel.NoteModel

@Dao
interface NoteDAO {

    @Insert
    suspend fun insertNote(noteModel: NoteModel)

    @Update
    suspend fun updateNote(noteModel: NoteModel)

    @Query("SELECT * FROM note_data_table")
    fun getAllNotes(): LiveData<List<NoteModel>>

    @Delete
    suspend fun deleteNote(noteModel: NoteModel)
}