package com.geektech.lovecalculator

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.geektech.lovecalculator.databinding.FragmentFirstBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FirstFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentFirstBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClicker()
    }

    private fun initClicker() {
        with(binding){
            okBtn.setOnClickListener {
                doRequest()
            }
        }
    }

    private fun doRequest() {
        val firstName = binding.firstNameED.text.toString()
        val secondName = binding.secondNameED.text.toString()
        App.api.calculate(firstName,secondName).enqueue(object : Callback<LoveModel> {
            override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                Log.e("ololo", "onResponce:${response.body()}")
                val loveModel = response.body()
                val bundle = Bundle()
                bundle.putSerializable("loveModel",loveModel)
                findNavController().navigate(R.id.secondFragment,bundle)
                binding.firstNameED.text.clear()
                binding.secondNameED.text.clear()
            }

            override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                Log.e("ololo", "onFailure:${t.message}")
            }
        })

    }

}