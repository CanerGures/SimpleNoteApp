package com.example.simplenoteapp.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.simplenoteapp.R
import com.example.simplenoteapp.model.dbmodel.NoteModel
import com.example.simplenoteapp.util.validateImageUrl
import com.example.simplenoteapp.util.validateNoteCreate
import com.example.simplenoteapp.viewmodel.NoteViewModel
import kotlinx.android.synthetic.main.fragment_create_note.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.text.SimpleDateFormat
import java.util.*


class CreateNoteFragment : Fragment() {
    private val homeViewModel: NoteViewModel by viewModel()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_create_note, container, false)
        this.activity?.overridePendingTransition(
            R.anim.anim_enter,
            R.anim.anim_leave
        )
        val noteAdd: Button = rootView.findViewById(R.id.noteAdd)
        noteAdd.setOnClickListener {
            val noteTitle = noteHeader.text.toString()
            val noteDescription = noteDescription.text.toString()
            val noteImageUrl = noteImageUrl.text.toString()
            val date = Calendar.getInstance().time
            val formatter = SimpleDateFormat.getDateTimeInstance()
            val formatedDate = formatter.format(date)
            val credentialCheck = validateNoteCreate(noteTitle, noteDescription)
            val imageUrlCheck = validateImageUrl(noteImageUrl)
            if (credentialCheck) {
                val noteModel = NoteModel(
                    null,
                    noteTitle,
                    noteDescription,
                    formatedDate,
                    false,
                    imageUrlCheck,
                    null
                )
                createNote(noteModel)

                Navigation.findNavController(rootView)
                    .navigate(R.id.action_createNoteFragment_to_mainFragment)
            } else {
                Toast.makeText(
                    this.context,
                    "Title and Note Description must not be empty, please check the entries.",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
        return rootView
    }

    private fun createNote(noteModel: NoteModel) {
        homeViewModel.insertNote(noteModel)
    }

}