package com.myapdb.myapdb.ui.mongoDB

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

class MongoFragment : Fragment() {

    private var _binding: FragmentConceptListBinding? = null
    private val binding get() = _binding!!

    private val conceptListAdapter = ConceptListAdapter { concept ->
        when(concept) {
            "DOCUMENTOS" -> { findNavController().navigate(
                R.id.conceptDetailFragment, bundleOf( "title" to getString(
                    R.string.mongo_title_Bdd), "detail" to getString(
                    R.string.mongo_detail_Bd))
            )}
            "COLECCIONES Y VISTAS" -> { findNavController().navigate(
                R.id.conceptDetailFragment, bundleOf( "title" to getString(
                    R.string.mongo_title_colectiones), "detail" to getString(
                    R.string.mongo_detail_colection))
            )}
            "COLECCIONES" -> { findNavController().navigate(
                R.id.conceptDetailFragment, bundleOf( "title" to getString(
                    R.string.mongo_title_coleciones), "detail" to getString(
                    R.string.mongo_detail_coleciones))
            )}
            "CREACION DE UNA COLECCION" -> { findNavController().navigate(
                R.id.conceptDetailFragment, bundleOf( "title" to getString(
                    R.string.mongo_title_creacion), "detail" to getString(
                    R.string.mongo_detail_creacion))
            )}
            "RESTRICCION DE NOMBRES" -> { findNavController().navigate(
                R.id.conceptDetailFragment, bundleOf( "title" to getString(
                    R.string.mongo_title_Restricciones), "detail" to getString(
                    R.string.mongo_detail_Restriciones))
            )}
            "CREACION EXPLICITA" -> { findNavController().navigate(
                R.id.conceptDetailFragment, bundleOf( "title" to getString(
                    R.string.mongo_title_explicita), "detail" to getString(
                    R.string.mongo_detail_explicita))
            )}
            "VALIDACION DE DOCUMENTOS" -> { findNavController().navigate(
                R.id.conceptDetailFragment, bundleOf( "title" to getString(
                    R.string.mongo_title_validacion), "detail" to getString(
                    R.string.mongo_detail_validacion))
            )}
            "CREAR OPERACIONES" -> { findNavController().navigate(
                R.id.conceptDetailFragment, bundleOf( "title" to getString(
                    R.string.mongo_title_crearoperaciones), "detail" to getString(
                    R.string.mongo_detail_crearoperaciones))
            )}
            "OPERACIONES DE LECTURA" -> { findNavController().navigate(
                R.id.conceptDetailFragment, bundleOf( "title" to getString(
                    R.string.mongo_title_lectura), "detail" to getString(
                    R.string.mongo_detail_lectura))
            )}
            "OPERACIONES DE ACTUALIZACION" -> { findNavController().navigate(
                R.id.conceptDetailFragment, bundleOf( "title" to getString(
                    R.string.mongo_title_actualizar), "detail" to getString(
                    R.string.mongo_detail_actualizar))
            )}
            "BORRAR OPERACIONES" -> { findNavController().navigate(
                R.id.conceptDetailFragment, bundleOf( "title" to getString(
                    R.string.mongo_title_borrar), "detail" to getString(
                    R.string.mongo_detail_borrar))
            )}
            "INSERT" -> { findNavController().navigate(
                R.id.conceptDetailFragment, bundleOf("title" to getString(
                    R.string.mysql_title_insert), "detail" to "insert")
            ) }
            "SELECT * FROM" -> { findNavController().navigate(
                R.id.conceptDetailFragment, bundleOf("title" to getString(
                    R.string.mysql_title_selecfrom), "detail" to  "holis")
            ) }
            "DELETE" -> { findNavController().navigate(
                R.id.conceptDetailFragment, bundleOf("title" to getString(
                    R.string.mysql_detail_selecfrom), "detail" to "hola123")
            ) }
            "UPDATE" -> { findNavController().navigate(
                R.id.conceptDetailFragment, bundleOf("title" to getString(
                    R.string.mysql_title_update), "detail" to "holaupdate")
            ) }
            "UNO" -> { findNavController().navigate(
                R.id.conceptDetailFragment, bundleOf( "title" to getString(
                    R.string.mysql_title_UNO), "detail" to "holauno")
            ) }
            "DOS" -> { findNavController().navigate(
                R.id.conceptDetailFragment, bundleOf( "title" to getString(
                    R.string.mysql_title_DOS), "detail" to "Holados")

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
            "DOCUMENTOS",
            "COLECCIONES Y VISTAS",
            "COLECCIONES",
            "CREACION DE UNA COLECCION",
            "RESTRICCION DE NOMBRES",
            "CREACION EXPLICITA",
            "VALIDACION DE DOCUMENTOS",
            "CREAR OPERACIONES",
            "OPERACIONES DE LECTURA",
            "OPERACIONES DE ACTUALIZACION",
            "BORRAR OPERACIONES",
            "INSERT",
            "SELECT * FROM",
            "DELETE",
            "UPDATE",
            "UNO",
            "DOS"
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