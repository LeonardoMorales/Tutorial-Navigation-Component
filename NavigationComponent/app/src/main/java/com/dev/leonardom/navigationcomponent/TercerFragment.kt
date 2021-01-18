package com.dev.leonardom.navigationcomponent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.dev.leonardom.navigationcomponent.databinding.FragmentTerceroBinding

class TercerFragment : Fragment() {

    private var _binding: FragmentTerceroBinding? = null
    private val binding get() = _binding!!

    private val args: TercerFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTerceroBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnGlobalAction.setOnClickListener {
            val action = NavGraphDirections.actionGlobalCuartoFragment()
            findNavController().navigate(action)
        }

        args.texto?.let {
            binding.tvTitulo.text = it
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}