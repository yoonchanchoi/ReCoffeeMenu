package com.example.recoffeemenu.network.model

import java.io.Serializable

data class CoffeeResult(
    var content: String = "default",
    var product_CD: String = "default",
    var product_NM: String = "default",
    var file_PATH: String = "default",
    var cate_NAME: String = "default",
    var kcal: String = "0",
    var fat: String = "0",
    var sat_FAT: String ="0",
    var sugars: String ="0",
    var protein: String ="0",
    var sodium: String ="0",
    var caffeine: String ="0",
    var favorite: Boolean = false
) : Serializable {

}
