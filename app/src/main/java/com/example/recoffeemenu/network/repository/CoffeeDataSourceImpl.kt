package com.example.recoffeemenu.network.repository

import com.example.recoffeemenu.model.Coffee
import com.example.recoffeemenu.util.Pref
import com.google.gson.Gson
import org.json.JSONObject
import javax.inject.Inject

class CoffeeDataSourceImpl @Inject constructor(
    private val jsonObject: JSONObject,
     ) : CoffeeDataSource {

    @Inject
    lateinit var pref: Pref

    override fun requestAllCoffee(): ArrayList<Coffee> {
        val menukeys = jsonObject.keys()
        val coffeeList: ArrayList<Coffee> = arrayListOf()
        for (key in menukeys) {
            val jsonArray = jsonObject.getJSONObject(key).getJSONArray("list")
            for (i in 0 until jsonArray.length()) {
                val coffee: Coffee =
                    Gson().fromJson(jsonArray.get(i).toString(), Coffee::class.java)
                coffee.favorite = pref.getBoolean(coffee.product_CD)
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

