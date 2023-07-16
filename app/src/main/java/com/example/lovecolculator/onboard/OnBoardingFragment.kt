package com.example.lovecolculator.onboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.lovecolculator.Pref
import com.example.lovecolculator.R
import com.example.lovecolculator.databinding.FragmentOnBoardingBinding
import dagger.hilt.android.AndroidEntryPoint
import me.relex.circleindicator.CircleIndicator3
import javax.inject.Inject
@AndroidEntryPoint
class OnBoardingFragment : Fragment() {

    private lateinit var binding: FragmentOnBoardingBinding
    private var adapter = OnBoardingAdapter(this::onStartClick)
    @Inject
    lateinit var pref: Pref

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnBoardingBinding.inflate(inflater, container, false)
        pref = Pref(requireContext())
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewPager2.adapter = adapter
        setIndicator()
        if (pref.isUserSeen()) {
            findNavController().navigate(R.id.calculatorFragment)
        }
    }

    private fun setIndicator() {
        val indicator: CircleIndicator3 = binding.indicator
        val viewPager2 = binding.viewPager2
        indicator.setViewPager(viewPager2)
    }

    private fun onStartClick() {
        pref.saveUserSeen()
        findNavController().navigate(R.id.onBoardingFragment)
    }


}