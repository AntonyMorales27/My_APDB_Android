package com.myapdb.myapdb.ui.list.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.myapdb.myapdb.R
import com.myapdb.myapdb.databinding.FragmentConceptListBinding

class ConceptListFragment : Fragment() {

    private var _binding: FragmentConceptListBinding? = null
    private val binding get() = _binding!!

    private val conceptListAdapter = ConceptListAdapter { concept ->
        when(concept) {
            "INSERT" -> { findNavController().navigate(R.id.conceptDetailFragment, bundleOf("title" to "INSERT", "detail" to "Agregar cosas")) }
            "SELECT * FROM" -> { findNavController().navigate(R.id.conceptDetailFragment, bundleOf("title" to "SELECT * FROM", "detail" to "Ver cosas")) }
            "DELETE" -> { findNavController().navigate(R.id.conceptDetailFragment, bundleOf("title" to "DELETE", "detail" to "Eliminar cosas")) }
            "UPDATE" -> { findNavController().navigate(R.id.conceptDetailFragment, bundleOf("title" to "UPDATE", "detail" to "Actualizar cosas")) }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentConceptListBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val conceptList = arguments?.getStringArrayList("list")?: listOf("INSERT", "SELECT * FROM", "DELETE", "UPDATE")

        setupRecyclerview()
        initList(conceptList)

        return root
    }

    private fun setupRecyclerview() {
        binding.rvList.apply {
            adapter = conceptListAdapter
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            setHasFixedSize(false)
        }
    }

    private fun initList(list: List<String>) {
        conceptListAdapter.submitList(list)
    }

}