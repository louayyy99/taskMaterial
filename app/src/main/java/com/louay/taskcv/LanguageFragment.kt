package com.louay.taskcv

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.louay.taskcv.databinding.FragmentLanguageBinding
import com.louay.taskcv.domain.secondFragment.entity.SecondData
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LanguageFragment : Fragment() {
    private lateinit var binding: FragmentLanguageBinding
    private lateinit var secondData: SecondData
    private val sfViewModel: SecondFragmentViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sfViewModel.getSecondData { secondData = it!! }
        binding.arabicCheckBox.isEnabled = false
        binding.frenchCheckBox.isEnabled = false
        binding.englishCheckBox.isEnabled = false
        binding.arabicCheckBox.isChecked = secondData.isArabic
        binding.frenchCheckBox.isChecked = secondData.isFrench
        binding.englishCheckBox.isChecked = secondData.isEnglish
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentLanguageBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }
}