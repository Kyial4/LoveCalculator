package com.geektech.lovecalculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.geektech.lovecalculator.databinding.FragmentFirstBinding
import com.geektech.lovecalculator.databinding.FragmentSecondBinding


class SecondFragment : Fragment() {
    private lateinit var binding: FragmentSecondBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentSecondBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val loveModel:LoveModel = arguments?.getSerializable("loveModel") as LoveModel
        binding.tvResult.text = loveModel.result
        binding.tvPercentage.text = loveModel.percentage.plus("%")
        binding.firstNameED.text = loveModel.firstname
        binding.secondNameED.text = loveModel.secondName
    }


}