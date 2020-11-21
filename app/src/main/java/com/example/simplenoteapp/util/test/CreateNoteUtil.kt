package com.example.simplenoteapp.util.test

object CreateNoteUtil {

    /**
     * input is not valid if...
     * ...title of the note is empty
     * ...description of the note is empty
     */
    fun validateNoteCreation(
        title: String,
        description: String
    ): Boolean {
        if (title.isNotEmpty() && description.isNotEmpty()) {
            return true
        }
        if (title.isNotEmpty() && description.isEmpty()) {
            return false
        }
        if (title.isEmpty() && description.isEmpty()) {
            return false
        }
        if (title.isEmpty() && description.isNotEmpty()) {
            return false
        }

        return true
    }
}