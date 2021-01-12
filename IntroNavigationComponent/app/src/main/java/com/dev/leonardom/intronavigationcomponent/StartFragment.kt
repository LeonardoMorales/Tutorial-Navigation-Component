package com.dev.leonardom.intronavigationcomponent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.dev.leonardom.intronavigationcomponent.databinding.FragmentStartBinding

class StartFragment : Fragment() {

    private var _binding: FragmentStartBinding? = null
    private val binding get() = _binding!!

    private var mOpcionSeleccionada = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnGameMode.setOnClickListener {
            val action = StartFragmentDirections.actionStartFragmentToGameModeDialog()
            findNavController().navigate(action)
        }


        binding.btnLogin.setOnClickListener {
            iniciarSesion()
        }

        observarSuscriptores()
    }

    private fun iniciarSesion() {
        val usuario = binding.textInputEditTextUsuario.text.toString()
        val contra = binding.textInputEditTextContrasena.text.toString()
        val modoJuego = mOpcionSeleccionada

        val login = Login(modoJuego, usuario, contra)

        val action = StartFragmentDirections.actionStartFragmentToGameFragment(login)
        findNavController().navigate(action)
    }

    private fun observarSuscriptores() {
        findNavController()
                .currentBackStackEntry
                ?.savedStateHandle
                ?.getLiveData("gameModeKey", "")
                ?.observe(viewLifecycleOwner){ result ->
                    mOpcionSeleccionada = result
                }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}