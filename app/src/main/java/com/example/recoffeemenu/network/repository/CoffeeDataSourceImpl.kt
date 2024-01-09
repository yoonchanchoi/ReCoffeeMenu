package com.example.recoffeemenu.network.repository

import io.reactivex.Single
import javax.inject.Inject

class CoffeeDataSourceImpl @Inject constructor(
     private val service: FIFAService
) : CoffeeDataSource {

    override fun requestAllCoffee(nickname: String): Single<UserInfoResult> =
        service.requestUserInfo(nickname)
}