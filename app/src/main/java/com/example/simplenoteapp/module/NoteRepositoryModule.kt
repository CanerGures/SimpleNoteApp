package com.example.simplenoteapp.module

import com.example.simplenoteapp.model.repository.NoteRepository
import org.koin.dsl.module

val noteRepositoryModule = module { single { NoteRepository(get()) } }