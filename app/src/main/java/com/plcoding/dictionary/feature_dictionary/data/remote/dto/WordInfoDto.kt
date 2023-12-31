package com.plcoding.dictionary.feature_dictionary.data.remote.dto

import com.plcoding.dictionary.feature_dictionary.data.local.entity.WordInfoEntity
import com.plcoding.dictionary.feature_dictionary.domain.model.WordInfo

data class WordInfoDto(
    val license: License,
    val meanings: List<MeaningDto>,
    val phonetic: String,
    val phonetics: List<PhoneticDto>,
    val sourceUrls: List<String>,
    val word: String
)

fun WordInfoDto.toWordInfo(): WordInfo {
    return WordInfo(
        meaning = meanings.map { it.toMeaning() },
        word = word,
        phonetic = phonetic,
    )
}

fun WordInfoDto.toWordInfoEntity(): WordInfoEntity {
    return WordInfoEntity(
        word = word,
        phonetic = phonetic,
        meanings = meanings.map { it.toMeaning() }
    )
}