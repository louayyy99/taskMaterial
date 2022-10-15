package com.louay.taskcv

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.louay.taskcv.data.secondFragment.dto.DataRequest
import com.louay.taskcv.databinding.FragmentSecondBinding
import com.louay.taskcv.utils.UiState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding
    private val sfViewModel: SecondFragmentViewModel by viewModels()
    private val langList = mutableListOf<String>()
    private val hobbiesList = mutableListOf<String>()

    private fun observe() {
        sfViewModel.state.observe(viewLifecycleOwner) { state ->
            when (state) {
                is UiState.Success -> {
                    Toast.makeText(requireContext(), state.data, Toast.LENGTH_SHORT).show()
                    findNavController().navigate(R.id.action_secondFragment_to_lastFragment)
                    println("works")
                }
                is UiState.Error -> {
                    Toast.makeText(requireActivity(), "Error saving data", Toast.LENGTH_SHORT)
                        .show()
                    println("oops")
                }
                is UiState.Loading -> {
                    println("lol")
                    Toast.makeText(requireActivity(), "Still saving", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        langList.clear()
        hobbiesList.clear()

        binding.submitBtn.setOnClickListener {
            getLanguages()
            getHobbies()
            if (langList.isEmpty() || hobbiesList.isEmpty()) {
                Toast.makeText(context, "please check at least one lang/hobby", Toast.LENGTH_SHORT)
                    .show()
            } else {
                observe()
                val dataRequest = DataRequest(
                    binding.androidBar.progress,
                    binding.iosBar.progress,
                    binding.flutterBar.progress,
                    langList.contains("Arabic"),
                    langList.contains("English"),
                    langList.contains("French"),
                    hobbiesList.contains("Music"),
                    hobbiesList.contains("Sports"),
                    hobbiesList.contains("Games"),
                    )
                sfViewModel.saveData(dataRequest)
            }
        }
    }

    private fun getLanguages() {
        if (binding.arabicCheckBox.isChecked) {
            langList.add(binding.arabicCheckBox.text.toString())

        }
        if (binding.englishCheckBox.isChecked) {
            langList.add(binding.englishCheckBox.text.toString())
        }
        if (binding.frenchCheckBox.isChecked) {
            langList.add(binding.frenchCheckBox.text.toString())
        }
    }

    private fun getHobbies() {
        if (binding.sportsCheckBox.isChecked) {
            hobbiesList.add(binding.sportsCheckBox.text.toString())
        }
        if (binding.musivCheckBox.isChecked) {
            hobbiesList.add(binding.musivCheckBox.text.toString())
        }
        if (binding.gamesCheckBox.isChecked) {
            hobbiesList.add(binding.gamesCheckBox.text.toString())
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        //args = SecondFragmentArgs.fromBundle(requireArguments())
        return binding.root
    }
}