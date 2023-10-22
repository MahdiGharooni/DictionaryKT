package com.plcoding.dictionary.feature_dictionary.domain.model


data class WordInfo(
    val meaning: List<Meaning>,
    val phonetic: String,
    val word: String
)
