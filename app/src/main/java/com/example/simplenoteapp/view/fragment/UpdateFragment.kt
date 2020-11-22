package com.example.simplenoteapp.view.fragment

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.simplenoteapp.R
import com.example.simplenoteapp.model.dbmodel.NoteModel
import com.example.simplenoteapp.util.validateImageUrl
import com.example.simplenoteapp.util.validateNoteCreate
import com.example.simplenoteapp.viewmodel.NoteViewModel
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.fragment_update.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.text.SimpleDateFormat
import java.util.*

class UpdateFragment : Fragment() {
    lateinit var noteModel: NoteModel
    lateinit var noteUpdate: Button
    lateinit var noteDelete: Button
    private val homeViewModel: NoteViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_update, container, false)

        val bundle = arguments?.getSerializable("updateModel")
        if (bundle != null) {
            noteModel = bundle as NoteModel
            val titleUpdate = rootView.findViewById<TextView>(R.id.noteHeaderUpdate)
            val descriptionUpdate = rootView.findViewById<TextView>(R.id.noteDescriptionUpdate)
            val imageUpdate = rootView.findViewById<TextView>(R.id.noteImageUrlUpdate)
            noteUpdate = rootView.findViewById(R.id.noteUpdate)
            noteDelete = rootView.findViewById(R.id.noteDelete)

            titleUpdate.text = noteModel.title
            descriptionUpdate.text = noteModel.description
            imageUpdate.text = noteModel.url

            deleteNote(rootView)
            updateNoteButton(rootView)
        }

        return rootView
    }

    private fun deleteNote(rootView: View) {
        noteDelete.setOnClickListener {
            val materialAlert = MaterialAlertDialogBuilder(rootView.context)
            materialAlert.setTitle(rootView.context.getString(R.string.alert))
            materialAlert.setMessage(rootView.context.getString(R.string.want_to_delete))

            materialAlert.setPositiveButton(
                rootView.context.getString(R.string.delete)
            ) { dialogInterface: DialogInterface, i: Int ->
                deleteNoteProcess(rootView)
                dialogInterface.cancel()
            }
            materialAlert.setNegativeButton(
                rootView.context.getString(R.string.cancel)
            ) { dialogInterface: DialogInterface, i: Int ->
                dialogInterface.cancel()
            }
            materialAlert.show()

        }
    }

    private fun deleteNoteProcess(rootView: View) {
        homeViewModel.deleteNote(noteModel)

        Navigation.findNavController(rootView)
            .navigate(R.id.action_updateFragment_to_mainFragment)
    }

    private fun updateNoteButton(rootView: View) {
        noteUpdate.setOnClickListener {
            val materialAlert = MaterialAlertDialogBuilder(rootView.context)
            materialAlert.setTitle(rootView.context.getString(R.string.alert))
            materialAlert.setMessage(rootView.context.getString(R.string.want_to_update))

            materialAlert.setPositiveButton(
                rootView.context.getString(R.string.update)
            ) { dialogInterface: DialogInterface, i: Int ->
                updateNote(rootView)
                dialogInterface.cancel()
            }
            materialAlert.setNegativeButton(
                rootView.context.getString(R.string.cancel)
            ) { dialogInterface: DialogInterface, i: Int ->
                dialogInterface.cancel()
            }
            materialAlert.show()

        }
    }

    private fun updateNote(rootView: View) {
        val noteTitle = noteHeaderUpdate.text.toString()
        val noteDescription = noteDescriptionUpdate.text.toString()
        val noteImageUrl = noteImageUrlUpdate.text.toString()
        val date = Calendar.getInstance().time
        val formatter = SimpleDateFormat.getDateTimeInstance()
        val updatedDate = formatter.format(date)
        val noteId = noteModel.noteId
        val noteDate = noteModel.createDate

        val credentialCheck = validateNoteCreate(noteTitle, noteDescription)
        val imageUrlCheck = validateImageUrl(noteImageUrl)
        if (credentialCheck) {
            val noteModel = NoteModel(
                noteId,
                noteTitle,
                noteDescription,
                noteDate,
                true,
                imageUrlCheck,
                updatedDate
            )
            updateNoteProcess(noteModel)

            Navigation.findNavController(rootView)
                .navigate(R.id.action_updateFragment_to_mainFragment)
        } else {
            Toast.makeText(
                this.context,
                rootView.context.getString(R.string.error_update),
                Toast.LENGTH_LONG
            ).show()
        }
    }

    private fun updateNoteProcess(noteModel: NoteModel) {
        homeViewModel.updateNote(noteModel)
    }
}