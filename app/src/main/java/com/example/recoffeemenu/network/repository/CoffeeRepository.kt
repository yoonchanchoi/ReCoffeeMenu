package com.example.recoffeemenu.network.repository

import com.example.recoffeemenu.network.model.CoffeeCategoryListResult

interface CoffeeRepository {

    fun requestAllCoffee(): ArrayList<CoffeeCategoryListResult>
}


