package com.salihkinali.gameguide.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.salihkinali.gameguide.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by viewModels()
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observerDataChanged()
    }

    private fun observerDataChanged() {
        viewModel.homeUidata.observe(viewLifecycleOwner) {
            when (it) {
                is UiState.Error -> Log.e("Hatalı","Veriler eksik geliyor")
                UiState.Loading -> println("veriler load haldedir.")
                is UiState.Success -> {
                    it.data.forEach {
                        Log.e("${it.name}","${it.backgroundImage}")
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}