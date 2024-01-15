package com.example.recoffeemenu.network.repository

import com.example.recoffeemenu.network.model.CoffeeCategoryListResult
import com.example.recoffeemenu.network.model.CoffeeResult
import com.example.recoffeemenu.util.Pref
import com.google.gson.Gson
import org.json.JSONObject
import javax.inject.Inject

class CoffeeRepositoryImpl @Inject constructor(
    private val jsonObject: JSONObject,
     ) : CoffeeRepository {

    @Inject
    lateinit var pref: Pref

    override fun requestAllCoffee(): ArrayList<CoffeeCategoryListResult> {
        val menukeys = jsonObject.keys()
        val arrayCoffeeCategoryListResult = ArrayList<CoffeeCategoryListResult>()
        for (key in menukeys) {
            val jsonArray = jsonObject.getJSONObject(key).getJSONArray("list")
            val coffeeCategoryListResult = CoffeeCategoryListResult()
            coffeeCategoryListResult.category = key
            for (i in 0 until jsonArray.length()) {
                val coffeeResult: CoffeeResult =
                    Gson().fromJson(jsonArray.get(i).toString(), CoffeeResult::class.java)
                coffeeResult.favorite = pref.getBoolean(coffeeResult.product_CD)
                coffeeCategoryListResult.coffeeList?.add(coffeeResult)
            }
            arrayCoffeeCategoryListResult.add(coffeeCategoryListResult)
        }
        return arrayCoffeeCategoryListResult
    }

}



