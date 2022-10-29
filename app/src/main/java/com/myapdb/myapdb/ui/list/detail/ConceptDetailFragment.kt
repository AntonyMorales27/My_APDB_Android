package com.myapdb.myapdb.ui.list.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.myapdb.myapdb.databinding.FragmentConceptDetailBinding

class ConceptDetailFragment : Fragment() {

    private var _binding: FragmentConceptDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentConceptDetailBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.tvTitle.text = arguments?.getString("title")?: "No se mando el titulo"
        binding.tvDetail.text = arguments?.getString("detail")?: "No se mando el detalle"

        return root
    }

}