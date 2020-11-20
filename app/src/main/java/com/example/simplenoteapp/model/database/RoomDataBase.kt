package com.example.simplenoteapp.model.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.simplenoteapp.model.dao.NoteDAO
import com.example.simplenoteapp.model.dbmodel.NoteModel

@Database(
    entities = [NoteModel::class],
    version = 1
)
abstract class RoomDataBase : RoomDatabase() {

    abstract fun noteDAO(): NoteDAO

}