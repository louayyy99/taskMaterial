package com.louay.taskcv

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.louay.taskcv.databinding.FragmentSecondBinding


class SecondFragment : Fragment() {

    private lateinit var args: SecondFragmentArgs
    private lateinit var binding: FragmentSecondBinding
    private val langList = mutableListOf<String>()
    private val hobbiesList = mutableListOf<String>()


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

                val action = SecondFragmentDirections.actionSecondFragmentToLastFragment(
                    args.name,
                    args.email,
                    args.age,
                    args.gender,
                    binding.androidBar.progress.toString(),
                    binding.iosBar.progress.toString(),
                    binding.flutterBar.progress.toString(),
                    langList.toTypedArray(),
                    hobbiesList.toTypedArray()
                )
                findNavController().navigate(action)
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
        args = SecondFragmentArgs.fromBundle(requireArguments())
        return binding.root
    }
}