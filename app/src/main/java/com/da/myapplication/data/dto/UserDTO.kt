package com.da.myapplication.data.dto

class UserDTO(
    val id: Long,
    val name: String,
    val username: String,
    val email: String,
    val phone: String?,
    val website: String?,
    val address: AddressDTO?,
    val company: CompanyDTO?
)
