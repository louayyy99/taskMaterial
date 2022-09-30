package com.louay.taskcv

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.louay.taskcv.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val name = binding.nameField.editText?.text
        val email = binding.emailField.editText?.text
        val age = binding.ageField.editText?.text
        val genderId = binding.radioGroup.checkedRadioButtonId
        val gender = binding.root.findViewById<RadioButton>(genderId).text

        binding.nextBtn.setOnClickListener {
            var i = 0
            if (name.isNullOrEmpty()) {
                binding.nameField.error = "Name is required"
                i++
            } else {
                binding.nameField.error = null
            }
            if (email.isNullOrEmpty()||!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                binding.emailField.error = "Email is required"
                i++
            } else {
                binding.emailField.error = null
            }
            if (age.isNullOrEmpty()) {
                binding.ageField.error = "Age is required"
                i++
            } else {
                binding.ageField.error = null
            }
            if (i == 0) {
                val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(
                    name.toString(),
                    email.toString(),
                    age.toString(),
                    gender.toString()
                )
                findNavController().navigate(action)
            }
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }
}
