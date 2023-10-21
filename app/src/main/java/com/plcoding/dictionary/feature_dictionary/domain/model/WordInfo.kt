package com.plcoding.dictionary.feature_dictionary.domain.model

import com.plcoding.dictionary.feature_dictionary.data.remote.dto.License
import com.plcoding.dictionary.feature_dictionary.data.remote.dto.MeaningDto
import com.plcoding.dictionary.feature_dictionary.data.remote.dto.PhoneticDto

data class WordInfo(
    val license: License,
    val meaning: List<Meaning>,
    val phonetic: String,
    val sourceUrls: List<String>,
    val word: String
)
