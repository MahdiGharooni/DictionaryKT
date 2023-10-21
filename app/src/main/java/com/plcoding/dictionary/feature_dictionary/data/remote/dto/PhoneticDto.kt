package com.plcoding.dictionary.feature_dictionary.data.remote.dto

data class PhoneticDto(
    val audio: String,
    val license: License,
    val sourceUrl: String,
    val text: String
)