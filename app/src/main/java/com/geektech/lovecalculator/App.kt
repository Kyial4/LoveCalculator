package com.geektech.lovecalculator

import android.app.Application
import com.geektech.lovecalculator.network.LoveApi
import retrofit2.Retrofit

class App:Application() {
    companion object {
        lateinit var api:LoveApi
    }

    override fun onCreate() {
        super.onCreate()
        val retrofit=RetrofitService()
        api=retrofit.api
    }
}