package com.example.recoffeemenu.network.repository

import com.example.recoffeemenu.SharedPreferencesManager
import com.example.recoffeemenu.fragment.CoffeeListFragment
import com.example.recoffeemenu.model.Coffee
import com.google.gson.Gson
import io.reactivex.Single
import org.json.JSONObject
import javax.inject.Inject

//class CoffeeDataSourceImpl @Inject constructor(
//     private val jsonObject: JSONObject
//) : CoffeeDataSource {
//
////    override fun requestAllCoffee(): Single<ArrayList<Coffee>> {
////        val menukeys = jsonObject.keys()
////        val test : Single<ArrayList<Coffee>> =
//////        for (key in menukeys) {
//////            val jsonArray = menuJSONObject.getJSONObject(key).getJSONArray("list")
//////            val coffeeList: ArrayList<Coffee> = arrayListOf()
//////            for (i in 0 until jsonArray.length()) {
//////                val coffee: Coffee =
//////                    Gson().fromJson(jsonArray.get(i).toString(), Coffee::class.java)
//////                coffee.favorite = SharedPreferencesManager.getBoolean(coffee.product_CD)
//////            }
//////        }
////        return test
////    }
//
//
//
//}