package com.example.lovecolculator.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.lovecolculator.R
import com.example.lovecolculator.databinding.FragmentResultBinding
import com.example.lovecolculator.remote.LoveModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ResultFragment : Fragment() {

private lateinit var binding: FragmentResultBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       binding = FragmentResultBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        result()
        initListener()
    }

    private fun initListener() {
        binding.btnTryAgain.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun result() {
        val result = arguments?.getSerializable(CalculatorFragment.KEY) as LoveModel
        binding.apply {
            tvYou.text = result.firstName
            tvMe.text = result.secondName
            tvPercent.text = result.percentage + "%"
            tvResult.text = result.result
        }
    }

}