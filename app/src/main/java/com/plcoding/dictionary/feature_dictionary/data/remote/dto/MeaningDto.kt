package com.plcoding.dictionary.feature_dictionary.data.remote.dto

import com.plcoding.dictionary.feature_dictionary.domain.model.Meaning

data class MeaningDto(
    val antonyms: List<Any>,
    val definitions: List<DefinitionDto>,
    val partOfSpeech: String,
    val synonyms: List<Any>
)

fun MeaningDto.toMeaning(): Meaning {
    return Meaning(
        definitions = definitions.map {
            it.toDefinition()
        },
        partOfSpeech = partOfSpeech,
    )
}