package com.example.lovecolculator.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.lovecolculator.databinding.FragmentHistoryBinding
import com.example.lovecolculator.di.App
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HistoryFragment : Fragment() {

    private lateinit var binding: FragmentHistoryBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHistoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val list = App.appDatabase.loveDao().getAllSort()

        list.forEachIndexed { _, love ->
            val result =
                "${love.firstName}\n ${love.secondName}\n ${love.percentage}\n ${love.result}\n\n"
            binding.tvHistory.append(result)
        }
    }

}