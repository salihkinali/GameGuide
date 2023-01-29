package com.salihkinali.gameguide.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.salihkinali.gameguide.databinding.FragmentDetailBinding
import com.salihkinali.gameguide.ui.common.UiResponseState
import com.salihkinali.gameguide.utility.downloadImage
import com.salihkinali.gameguide.utility.visible
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class DetailFragment : Fragment() {
    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    private val viewModel: DetailViewModel by viewModels()

    private val args: DetailFragmentArgs by navArgs()

    private val adapter by lazy { DetailScreenShotAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getDataFromSource(args.gameId)
        setGameScreenShot()
        showData()
    }

    private fun setGameScreenShot() {
        binding.gameScreenShotRecylerView.adapter = adapter
    }

    private fun showData() {
        lifecycleScope.launchWhenResumed {

            // This is Detail Page
            viewModel.detailUiData.collectLatest {
                when (it) {
                    is UiResponseState.Error -> {
                        binding.detailProgressBar.visible(false)
                        binding.gameScreenShotText.visible(false)
                    }

                    UiResponseState.Loading -> {
                        binding.detailProgressBar.visible(true)
                        binding.gameScreenShotText.visible(false)
                    }
                    is UiResponseState.Success -> {
                        binding.detailProgressBar.visible(false)
                        showDetailInformation(it.data)
                    }
                }
            }

            // This is Game ScreenShot information
            viewModel.detailScreenShot.observe(viewLifecycleOwner) {
                when (it) {
                    is UiResponseState.Error -> {
                        binding.detailProgressBar.visible(false)
                        binding.gameScreenShotText.visible(false)
                    }
                    UiResponseState.Loading -> {
                        binding.detailProgressBar.visible(true)
                        binding.gameScreenShotText.visible(false)
                    }

                    is UiResponseState.Success -> {
                        binding.detailProgressBar.visible(false)
                        binding.gameScreenShotText.visible(true)
                        showScreenShot(it.data)
                    }
                }
            }
        }
    }

    private fun showScreenShot(data: List<GameScreenShotUiData>) {
        adapter.updateItems(data)
    }

    private fun showDetailInformation(data: SingleGameUiData) {

        binding.gameNameText.text = data.name
        binding.detailImageView.downloadImage(data.backgroundImage)
        binding.gameDescriptionText.text = data.description
        binding.releasedText.text = data.released
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}