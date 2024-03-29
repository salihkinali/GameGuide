package com.salihkinali.feature.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.salihkinali.feature.home.databinding.FragmentHomeBinding
import com.salihkinali.ui.common.UiResponseState
import com.salihkinali.ui.extension.visible
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by viewModels()
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val adapter by lazy { HomeAdapter(::passDataId) }

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
                    is UiResponseState.Error -> {
                        Toast.makeText(
                            requireContext(),
                            "This is error message.",
                            Toast.LENGTH_SHORT
                        ).show()
                        binding.progressBar.visible(false)
                    }
                    is UiResponseState.Loading -> binding.progressBar.visible(true)

                    is UiResponseState.Success -> {
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

    private fun passDataId(dataId: Int) {
        val action = HomeFragmentDirections.homeToDetailFragment(dataId)
        findNavController().navigate(action)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}


