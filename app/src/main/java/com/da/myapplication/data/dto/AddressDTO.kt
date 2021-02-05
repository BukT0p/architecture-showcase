package com.da.myapplication.data.dto

class AddressDTO(
    val street: String?,
    val suite: String?,
    val city: String?,
    val zipcode: String?,
    val geo: GeoDTO?
)

class GeoDTO(
    val lat: String,
    val lng: String
)
