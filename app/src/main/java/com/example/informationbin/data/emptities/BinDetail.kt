package com.example.informationbin.data.emptities

data class BinDetail(
    val numberBin: NumberBin = NumberBin(),
    val scheme: String = "",
    val type: String = "",
    val brand: String = "",
    val prepaid: Boolean = false,
    val country: Country = Country(),
    val bank: Bank = Bank()
)