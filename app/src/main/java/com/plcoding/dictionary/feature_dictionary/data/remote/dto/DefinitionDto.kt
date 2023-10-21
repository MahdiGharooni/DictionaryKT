package com.plcoding.dictionary.feature_dictionary.data.remote.dto

import com.plcoding.dictionary.feature_dictionary.domain.model.Definition

data class DefinitionDto(
    val antonyms: List<String>,
    val definition: String,
    val synonyms: List<String>,
    val example: String?,
)

fun DefinitionDto.toDefinition(): Definition {
    return Definition(
        antonyms = antonyms,
        definition = this.definition,
        synonyms = this.synonyms,
        example = this.example,
    )
}