package com.example.simplenoteapp.model.repository

import androidx.lifecycle.LiveData
import com.example.simplenoteapp.model.dao.NoteDAO
import com.example.simplenoteapp.model.dbmodel.NoteModel

class NoteRepository(private val noteDao: NoteDAO) {

    suspend fun insertNotes(noteModel: NoteModel) =
        noteDao.insertNote(noteModel)

    suspend fun updateNotes(noteModel: NoteModel) =
        noteDao.updateNote(noteModel)

    suspend fun deleteNotes(noteModel: NoteModel) =
        noteDao.deleteNote(noteModel)

    fun getAllNotes(): LiveData<List<NoteModel>> = noteDao.getAllNotes()

}