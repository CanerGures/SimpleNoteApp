package com.example.simplenoteapp.module

import androidx.room.Room
import com.example.simplenoteapp.model.database.RoomDataBase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val roomModule = module {
    single {
        Room.databaseBuilder(
            androidContext(), RoomDataBase::class.java,
            "simpleNoteDatabase"
        ).allowMainThreadQueries().build()
    }
    single { get<RoomDataBase>().noteDAO() }
}