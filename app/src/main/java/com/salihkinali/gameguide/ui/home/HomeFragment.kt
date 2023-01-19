package com.salihkinali.gameguide.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.salihkinali.gameguide.databinding.FragmentHomeBinding
import com.salihkinali.gameguide.utility.visible
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by viewModels()
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val adapter = HomeAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeUiData()
        handledata()
    }

    private fun handledata() {
        binding.gamesRecylerview.adapter = adapter
    }

    private fun observeUiData() {
        viewModel.homeUidata.observe(viewLifecycleOwner) {
            when (it) {
                is UiState.Error -> Log.e("ERROR HATASI", it.error.toString())
                is UiState.Loading -> binding.progressBar.visible(true)

                is UiState.Success -> {
                    binding.progressBar.visible(false)
                    binding.textView.text = it.data.toString()
                }

            }
        }
    }

    private fun loadDataToAdapter(data: List<TotalGameUiData>) {
        adapter.updateGames(data)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}