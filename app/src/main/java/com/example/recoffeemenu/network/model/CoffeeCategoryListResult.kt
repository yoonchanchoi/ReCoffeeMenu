package com.example.recoffeemenu.network.model

import java.io.Serializable

data class CoffeeCategoryListResult(
    var category: String ="",
    var coffeeList: ArrayList<CoffeeResult>? = null
) : Serializable
