package com.myapdb.myapdb.ui.mySQL

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

class MySQLFragment : Fragment() {

    private var _binding: FragmentConceptListBinding? = null
    private val binding get() = _binding!!

    private val conceptListAdapter = ConceptListAdapter { concept ->
        when(concept) {
            "MySQL" -> { findNavController().navigate(
                R.id.conceptDetailFragment, bundleOf( "title" to getString(
                    R.string.mysql_title_MySQL), "detail" to getString(
                    R.string.mysql_detail_mysql))
            )}
            "CONVENCION DE NOMENCLATURA" -> { findNavController().navigate(
                R.id.conceptDetailFragment, bundleOf( "title" to getString(
                    R.string.mysql_title_nomenclatura), "detail" to getString(
                    R.string.mysql_detail_nomenclatura))
            )}
            "BASE DE DATOS" -> { findNavController().navigate(
                R.id.conceptDetailFragment, bundleOf( "title" to getString(
                    R.string.mysql_title_bdatos), "detail" to getString(
                    R.string.mysql_detail_bdatos))

            )}
            "TABLAS" -> { findNavController().navigate(
                R.id.conceptDetailFragment, bundleOf( "title" to getString(
                    R.string.mysql_title_nametablas), "detail" to getString(
                    R.string.mysql_detail_nametablas))
            )}
            "CAMPOS" -> { findNavController().navigate(
                R.id.conceptDetailFragment, bundleOf( "title" to getString(
                    R.string.mysql_title_namecampos), "detail" to getString(
                    R.string.mysql_detail_namecampos))
            )}
            "TIPO DE DATOS" -> { findNavController().navigate(
                R.id.conceptDetailFragment, bundleOf( "title" to getString(
                    R.string.mysql_title_tipodatos), "detail" to getString(
                    R.string.mysql_detail_tiposdatos))
            )}
            "CHAR Y VARCHAR" -> { findNavController().navigate(
                R.id.conceptDetailFragment, bundleOf( "title" to getString(
                    R.string.mysql_title_usoChar), "detail" to getString(
                    R.string.mysql_detail_usoChar))
            )}
            "EVITAR SELECT *" -> { findNavController().navigate(
                R.id.conceptDetailFragment, bundleOf( "title" to getString(
                    R.string.mysql_title_stopselect), "detail" to getString(
                    R.string.mysql_detail_stopselect))
            )}
            "USO DE EXIST" -> { findNavController().navigate(
                R.id.conceptDetailFragment, bundleOf( "title" to getString(
                    R.string.mysql_title_exist), "detail" to getString(
                    R.string.mysql_detail_exist))
            ) }
            "DELETE" -> { findNavController().navigate(
                R.id.conceptDetailFragment, bundleOf("title" to getString(
                    R.string.mysql_detail_selecfrom), "detail" to "hola123")
            ) }
            "UPDATE" -> { findNavController().navigate(
                R.id.conceptDetailFragment, bundleOf("title" to getString(
                    R.string.mysql_title_update), "detail" to "holaupdate")
            ) }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentConceptListBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val conceptList = arguments?.getStringArrayList("list")?:
        listOf(
            "MySQL",
            "CONVENCION DE NOMENCLATURA",
            "BASE DE DATOS",
            "TABLAS",
            "CAMPOS",
            "TIPO DE DATOS",
            "CHAR Y VARCHAR",
            "EVITAR SELECT *",
            "USO DE EXIST",
            "DELETE",
            "UPDATE",
        )

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