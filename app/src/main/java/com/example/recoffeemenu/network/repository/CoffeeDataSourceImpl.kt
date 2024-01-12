package com.example.recoffeemenu.network.repository

import android.content.Context
import android.util.Log
import com.example.recoffeemenu.SharedPreferencesManager
import com.example.recoffeemenu.fragment.CoffeeListFragment
import com.example.recoffeemenu.model.Coffee
import com.google.gson.Gson
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import org.json.JSONObject
import javax.inject.Inject

class CoffeeDataSourceImpl @Inject constructor(
     private val jsonObject: JSONObject,
     ) : CoffeeDataSource {

    override fun requestAllCoffee(): ArrayList<Coffee> {
        val menukeys = jsonObject.keys()
        val coffeeList: ArrayList<Coffee> = arrayListOf()
        for (key in menukeys) {
            val jsonArray = jsonObject.getJSONObject(key).getJSONArray("list")
            for (i in 0 until jsonArray.length()) {
                val coffee: Coffee =
                    Gson().fromJson(jsonArray.get(i).toString(), Coffee::class.java)
                coffee.favorite = SharedPreferencesManager.getBoolean(coffee.product_CD)
                coffeeList.add(coffee)
            }
        }
        return coffeeList
    }
}

//    companion object {
//        private var instance: ArrayList<Coffee>? = null
//
//        fun getInstance(context: Context) =
//            instance ?: ArrayList<Coffee>().also {
//                instance = it
//            }
//    }

