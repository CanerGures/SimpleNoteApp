package com.example.simplenoteapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simplenoteapp.model.dbmodel.NoteModel
import com.example.simplenoteapp.model.repository.NoteRepository
import kotlinx.coroutines.launch

class NoteViewModel(private val noteRepository: NoteRepository) : ViewModel() {

    fun insertNote(noteModel: NoteModel) =
        viewModelScope.launch { noteRepository.insertNotes(noteModel) }

    fun deleteNote(noteModel: NoteModel) =
        viewModelScope.launch { noteRepository.deleteNotes(noteModel) }

    fun updateNote(noteModel: NoteModel) =
        viewModelScope.launch { noteRepository.updateNotes(noteModel) }

    fun getAllNotes(): LiveData<List<NoteModel>> = noteRepository.getAllNotes()

}