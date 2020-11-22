package com.example.simplenoteapp.view.fragment

import android.content.DialogInterface
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
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.fragment_create_note.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.text.SimpleDateFormat
import java.util.*


class CreateNoteFragment : Fragment() {
    private val homeViewModel: NoteViewModel by viewModel()
    lateinit var noteAdd: Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_create_note, container, false)
        this.activity?.overridePendingTransition(
            R.anim.anim_enter,
            R.anim.anim_leave
        )
        noteAdd = rootView.findViewById(R.id.noteAdd)
        createNoteButton(rootView)
        return rootView
    }

    private fun createNoteButton(rootView: View?) {
        noteAdd.setOnClickListener {

            val materialAlert = MaterialAlertDialogBuilder(rootView!!.context)
            materialAlert.setTitle(rootView.context.getString(R.string.alert))
            materialAlert.setMessage(rootView.context.getString(R.string.want_to_add))

            materialAlert.setPositiveButton(
                rootView.context.getString(R.string.add)
            ) { dialogInterface: DialogInterface, i: Int ->
                createNote(rootView)
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

    private fun createNote(rootView: View?) {

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
            createNoteProcess(noteModel)

            Navigation.findNavController(rootView!!)
                .navigate(R.id.action_createNoteFragment_to_mainFragment)
        } else {
            Toast.makeText(
                this.context,
                rootView!!.context.getString(R.string.want_to_add),
                Toast.LENGTH_LONG
            ).show()
        }
    }

    private fun createNoteProcess(noteModel: NoteModel) {
        homeViewModel.insertNote(noteModel)
    }

}