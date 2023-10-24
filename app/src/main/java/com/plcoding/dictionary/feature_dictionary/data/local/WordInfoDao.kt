package com.plcoding.dictionary.feature_dictionary.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.plcoding.dictionary.feature_dictionary.data.local.entity.WordInfoEntity
import com.plcoding.dictionary.feature_dictionary.domain.model.WordInfo

@Dao
interface WordInfoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWordInfos(infos: List<WordInfoEntity>)

    @Query(value = "DELETE FROM wordinfoentity WHERE word IN(:infos)")
    suspend fun deleteWordInfos(infos: List<String>)

    @Query("SELECT * FROM wordinfoentity WHERE word LIKE '%'||:myWord||'%'")
    suspend fun getWord(myWord: String): List<WordInfoEntity>
}