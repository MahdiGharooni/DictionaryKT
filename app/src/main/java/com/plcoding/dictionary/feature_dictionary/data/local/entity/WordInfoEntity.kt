package com.plcoding.dictionary.feature_dictionary.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.plcoding.dictionary.feature_dictionary.domain.model.Meaning
import com.plcoding.dictionary.feature_dictionary.domain.model.WordInfo

@Entity
data class WordInfoEntity(
    val word: String,
    val phonetic: String,
    val meanings: List<Meaning>,
    @PrimaryKey(autoGenerate = true) val id: Int = 0
)

fun WordInfoEntity.toWordInfo(): WordInfo {
    return WordInfo(
        meaning = meanings,
        phonetic = phonetic,
        word = word,
    )
}
