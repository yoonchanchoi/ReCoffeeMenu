package com.example.recoffeemenu.network.repository

import com.example.recoffeemenu.model.Coffee
import io.reactivex.Single

interface CoffeeDataSource {

    fun requestAllCoffee(): ArrayList<Coffee>
}


