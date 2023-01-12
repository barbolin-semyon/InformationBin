package com.example.informationbin.data.emptities

data class Country(
    val numeric: String = "",
    val alpha2: String = "",
    val name: String = "",
    val emoji: String = "",
    val currency: String = "",
    val latitude: Int = 0,
    val longitude: Int = 0
)