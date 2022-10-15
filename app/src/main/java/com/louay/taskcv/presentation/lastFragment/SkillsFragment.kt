package com.louay.taskcv.presentation.lastFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.louay.taskcv.databinding.FragmentSkillsBinding
import com.louay.taskcv.domain.secondFragment.entity.SecondData
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SkillsFragment : Fragment() {
    private lateinit var binding: FragmentSkillsBinding
    private lateinit var secondData: SecondData
    private val lfViewModel: LastFragmentViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lfViewModel.getSecondData { secondData = it!! }
        binding.androidBar.isEnabled = false
        binding.iosBar.isEnabled = false
        binding.flutterBar.isEnabled = false
        binding.androidBar.progress = secondData.androidValue
        binding.iosBar.progress = secondData.IosValue
        binding.flutterBar.progress = secondData.flutterValue
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentSkillsBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }
}