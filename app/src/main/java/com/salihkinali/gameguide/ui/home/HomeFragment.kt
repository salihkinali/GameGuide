package com.salihkinali.gameguide.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.salihkinali.gameguide.databinding.FragmentHomeBinding
import com.salihkinali.gameguide.utility.visible
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by viewModels()
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val adapter by lazy { HomeAdapter(::showToastMessage) }

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

        lifecycleScope.launchWhenResumed {

            viewModel.homeUidata.collect {
                when (it) {
                    is UiState.Error -> {
                        Toast.makeText(
                            requireContext(),
                            "This is error message.",
                            Toast.LENGTH_SHORT
                        ).show()
                        binding.progressBar.visible(false)
                    }
                    is UiState.Loading -> binding.progressBar.visible(true)

                    is UiState.Success -> {
                        binding.progressBar.visible(false)
                        loadDataToAdapter(it.data)
                    }
                }
            }
        }
    }

    private fun loadDataToAdapter(data: List<TotalGameUiData>) {
        adapter.updateItems(data)
    }

    private fun showToastMessage(l: Int) {
        Toast.makeText(requireContext(),
            "Text Sayısı $l",
            Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}


