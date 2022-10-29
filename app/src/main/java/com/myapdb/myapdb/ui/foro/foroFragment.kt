package com.myapdb.myapdb.ui.foro

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.myapdb.myapdb.databinding.FragmentForoBinding
import com.myapdb.myapdb.ui.extensions.openChromeTab

class foroFragment : Fragment() {
    private lateinit var _binding: FragmentForoBinding
    private val binding get() = _binding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val foroViewModel =
            ViewModelProvider(this).get(ForoViewModel::class.java)

        _binding = FragmentForoBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textForo
        foroViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it

            _binding.LinkForo.setOnClickListener() {
                requireContext().openChromeTab("https://t.me/+CB2_G1EvXAdhM2Ix")
            }
        }
        return root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding
    }
}