package com.myapdb.myapdb.ui.sqlServer

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
import com.myapdb.myapdb.ui.list.detail.ConceptListAdapter


class SQLServerFragment: Fragment() {

    private var _binding: FragmentConceptListBinding? = null
    private val binding get() = _binding!!

    private val conceptListAdapter = ConceptListAdapter { concept ->
        when(concept) {
            "BASE DE DATOS" -> { findNavController().navigate(
                R.id.conceptDetailFragment, bundleOf("title" to getString(
                    R.string.sql_title_basededatos), "detail" to getString(
                    R.string.sql_detail_basededatos))

            )  }
            "TABLAS"-> { findNavController().navigate(
                R.id.conceptDetailFragment, bundleOf( "title" to getString(
                    R.string.sql_title_tablas), "detail" to getString(
                    R.string.sql_detail_tablas))

            )   }
            "CAMPOS"-> { findNavController().navigate(
                R.id.conceptDetailFragment, bundleOf( "title" to getString(
                    R.string.sql_title_Campos), "detail" to getString(
                    R.string.sql_detail_Campos))

            )   }
            "TIPOS DE DATOS" -> {findNavController().navigate(
                R.id.conceptDetailFragment, bundleOf( "title" to getString(
                    R.string.sql_title_tipoDatos), "detail" to getString(
                    R.string.sql_detail_tipoDatos))

            )   }
            "RELACIONES" -> { findNavController().navigate(
                R.id.conceptDetailFragment, bundleOf( "title" to getString(
                    R.string.sql_title_relaciones), "detail" to getString(
                    R.string.sql_detail_relaciones))

            )   }

            "SENTENCIA SELECT" -> { findNavController().navigate(
                R.id.conceptDetailFragment, bundleOf("title" to getString(
                    R.string.sql_title_Select), "detail" to getString(
                    R.string.sql_detail_Select))

            )   }
            "SENTENCIA INSERT" -> { findNavController().navigate(
                R.id.conceptDetailFragment, bundleOf("title" to getString(
                    R.string.sql_title_insert), "detail" to getString(
                    R.string.sql_detail_insert))

            )   }
            "SENTENCIA UPDATE" -> { findNavController().navigate(
                R.id.conceptDetailFragment, bundleOf("title" to getString(
                    R.string.sql_title_update), "detail" to getString(
                    R.string.sql_detail_update))

            )   }
            "SENTENCIA DELETE" -> { findNavController().navigate(
                R.id.conceptDetailFragment, bundleOf("title" to getString(
                    R.string.sql_title_delete), "detail" to getString(
                    R.string.sql_detail_delete))

            )   }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentConceptListBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val conceptList = arguments?.getStringArrayList("list")?: listOf(
            "BASE DE DATOS",
            "TABLAS",
            "CAMPOS",
            "TIPOS DE DATOS",
            "RELACIONES",
            "SENTENCIA SELECT",
            "SENTENCIA INSERT",
            "SENTENCIA UPDATE",
            "SENTENCIA DELETE",)

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