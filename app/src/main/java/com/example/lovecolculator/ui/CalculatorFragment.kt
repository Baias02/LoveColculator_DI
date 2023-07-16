package com.example.lovecolculator.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.lovecolculator.LoveViewModel
import com.example.lovecolculator.R
import com.example.lovecolculator.databinding.FragmentCalculatorBinding
import com.example.lovecolculator.di.App

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CalculatorFragment : Fragment() {

    private lateinit var binding: FragmentCalculatorBinding
    private val viewModel: LoveViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCalculatorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()
    }

    private fun initListener() {
        with(binding) {
            btnHistory.setOnClickListener {
                findNavController().navigate(R.id.historyFragment)
            }
            btnCalculate.setOnClickListener {
                viewModel.getLiveData(
                    etFirstName.text.toString(),
                    etSecondName.text.toString()
                ).observe(viewLifecycleOwner, Observer {
                    App.appDatabase.loveDao().insertLove(it)
                    val result = it
                    findNavController().navigate(R.id.resultFragment, bundleOf(KEY to result))
                })
            }
        }
    }
    companion object{
        const val KEY = "key_percent"
    }
}