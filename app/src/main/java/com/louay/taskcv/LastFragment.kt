package com.louay.taskcv

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.louay.taskcv.databinding.FragmentLastBinding


class LastFragment : Fragment() {

    private lateinit var binding: FragmentLastBinding
    private lateinit var args: LastFragmentArgs

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.nameVal.text = args.name
        binding.emailVal.text = args.email
        binding.ageVal.text = args.age
        binding.genderVal.text = args.gender
        binding.androidVal.text = args.androidSkill
        binding.iosVal.text = args.iosSkill
        binding.flutterVal.text = args.flutterSkill
        binding.langVal.text = args.language.joinToString()
        binding.hobbiesVal.text = args.hobby.joinToString()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentLastBinding.inflate(inflater, container, false)
        args = LastFragmentArgs.fromBundle(requireArguments())
        return binding.root
    }


}