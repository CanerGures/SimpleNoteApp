package com.example.simplenoteapp.module

import com.example.simplenoteapp.viewmodel.NoteViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module { viewModel { NoteViewModel(get()) } }