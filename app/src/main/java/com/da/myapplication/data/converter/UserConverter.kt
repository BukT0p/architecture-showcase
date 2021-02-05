package com.da.myapplication.data.converter

import com.da.myapplication.data.dto.AddressDTO
import com.da.myapplication.data.dto.CompanyDTO
import com.da.myapplication.data.dto.GeoDTO
import com.da.myapplication.data.dto.UserDTO
import com.da.myapplication.domain.entity.Address
import com.da.myapplication.domain.entity.Company
import com.da.myapplication.domain.entity.LongLat
import com.da.myapplication.domain.entity.User

fun UserDTO.toEntity() = User(
    id = id,
    name = name,
    username = username,
    email = email,
    phone = phone,
    website = website,
    company = company?.toEntity(),
    address = address?.toEntity()
)

fun CompanyDTO.toEntity() = Company(
    name = name,
    catchPhrase = catchPhrase,
    bs = bs
)

fun AddressDTO.toEntity() = Address(
    street = street,
    suite = suite,
    city = city, zipcode = zipcode,
    geo = geo?.toEntity()
)

fun GeoDTO.toEntity(): LongLat = LongLat(
    long = lng,
    lat = lat
)
