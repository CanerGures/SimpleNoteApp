package com.example.simplenoteapp.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.simplenoteapp.R
import com.example.simplenoteapp.adapter.NoteRecyclerViewAdapter
import com.example.simplenoteapp.model.dbmodel.NoteModel
import com.example.simplenoteapp.viewmodel.NoteViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainFragment : Fragment() {
    lateinit var recycView: RecyclerView
    private val homeViewModel: NoteViewModel by viewModel()
    lateinit var addFab: FloatingActionButton
    private val note: MutableList<NoteModel> = mutableListOf()
    private val notes: MutableList<NoteModel> = mutableListOf()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_main, container, false)
        addFab = rootView.findViewById(R.id.addFab)
        val noteAdapter = NoteRecyclerViewAdapter(notes) {
            val bundle = Bundle()
            bundle.putSerializable("updateModel", it)
            Navigation.findNavController(rootView)
                .navigate(R.id.action_mainFragment_to_updateFragment, bundle)
        }

        homeViewModel.getAllNotes().observe(viewLifecycleOwner, {
            with(noteAdapter) {
                if (notes.size == 0) {
                    notes.addAll(it)
                    note.addAll(it)
                    notifyDataSetChanged()
                }
                notifyDataSetChanged()
            }
        })

        recycView = rootView.findViewById(R.id.mainRv)
        recycView.adapter = noteAdapter
        recycView.layoutManager = LinearLayoutManager(rootView.context)

        addFabOnClick(rootView)

        return rootView
    }

    private fun addFabOnClick(rootView: View) {
        addFab.setOnClickListener {
            Navigation.findNavController(rootView)
                .navigate(R.id.action_mainFragment_to_createNoteFragment)
        }
    }

}