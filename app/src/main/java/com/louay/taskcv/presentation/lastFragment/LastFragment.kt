package com.louay.taskcv.presentation.lastFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.louay.taskcv.R
import com.louay.taskcv.databinding.FragmentLastBinding
import com.louay.taskcv.domain.firstFragment.entity.FirstData
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LastFragment : Fragment() {

    private lateinit var binding: FragmentLastBinding
    private lateinit var firstData: FirstData
    private val lfViewModel: LastFragmentViewModel by viewModels()

    private fun goToSkillsFragment() {
        childFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView2, SkillsFragment())
            .commit()
    }

    private fun goToLanguageFragment() {
        childFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView2, LanguageFragment())
            .commit()
    }

    private fun goToHobbyFragment() {
        childFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView2, HobbiesFragment())
            .commit()

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.hbBtn.setOnClickListener { goToHobbyFragment() }
        binding.langBtn.setOnClickListener { goToLanguageFragment() }
        binding.skillsBtn.setOnClickListener { goToSkillsFragment() }
        lfViewModel.getFirstData { firstData = it!! }
        binding.email.text = firstData.email
        binding.name.text = firstData.name
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentLastBinding.inflate(inflater, container, false)
        return binding.root
    }
}