package com.example.simplenoteapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.simplenoteapp.adapter.NoteRecyclerViewAdapter
import com.example.simplenoteapp.viewmodel.NoteViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainFragment : Fragment() {
    lateinit var recycView: RecyclerView
    private val homeViewModel: NoteViewModel by viewModel()
    lateinit var addFab: FloatingActionButton
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_main, container, false)
        addFab = rootView.findViewById(R.id.addFab)

        val noteAdapter = NoteRecyclerViewAdapter()

        addFabOnClick(rootView)

        homeViewModel.getAllNotes().observe(viewLifecycleOwner, {
            with(noteAdapter) {
                if (notes.size == 0) {
                    notes.addAll(it)
                    notifyDataSetChanged()
                }
                notifyDataSetChanged()
            }
        })

        recycView = rootView.findViewById(R.id.mainRv)
        recycView.adapter = noteAdapter
        recycView.layoutManager = LinearLayoutManager(rootView.context)

        return rootView
    }

    private fun addFabOnClick(rootView: View) {
        addFab.setOnClickListener {
            Navigation.findNavController(rootView)
                .navigate(R.id.action_mainFragment_to_createNoteFragment)
        }
    }

}