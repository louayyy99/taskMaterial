package com.louay.taskcv.presentation.lastFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.louay.taskcv.databinding.FragmentHobbiesBinding
import com.louay.taskcv.domain.secondFragment.entity.SecondData
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HobbiesFragment : Fragment() {
    private lateinit var binding: FragmentHobbiesBinding
    private lateinit var secondData: SecondData
    private val lfViewModel: LastFragmentViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lfViewModel.getSecondData { secondData = it!! }
        binding.sportsCheckBox.isEnabled = false
        binding.musivCheckBox.isEnabled = false
        binding.gamesCheckBox.isEnabled = false
        binding.sportsCheckBox.isChecked = secondData.isSports
        binding.musivCheckBox.isChecked = secondData.isMusic
        binding.gamesCheckBox.isChecked = secondData.isGames
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentHobbiesBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }
}