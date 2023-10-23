package com.plcoding.dictionary.feature_dictionary.data.repository

import com.plcoding.dictionary.core.util.Resource
import com.plcoding.dictionary.feature_dictionary.data.local.WordInfoDao
import com.plcoding.dictionary.feature_dictionary.data.local.entity.toWordInfo
import com.plcoding.dictionary.feature_dictionary.data.remote.DictionaryApi
import com.plcoding.dictionary.feature_dictionary.data.remote.dto.toWordInfo
import com.plcoding.dictionary.feature_dictionary.data.remote.dto.toWordInfoEntity
import com.plcoding.dictionary.feature_dictionary.domain.model.WordInfo
import com.plcoding.dictionary.feature_dictionary.domain.repository.WordInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class WordInfoRepositoryImpl @Inject constructor(
    private val api: DictionaryApi,
    private val dao: WordInfoDao,
) : WordInfoRepository {
    override fun getWordInfo(word: String): Flow<Resource<List<WordInfo>>> = flow {
        emit(Resource.Loading())

        val wordInfo = dao.getWord(word).map { it.toWordInfo() }
        emit(Resource.Loading(wordInfo))//todo: why

        try {
            val apiWordInfo = api.getWord(word)
            dao.deleteWordInfos(apiWordInfo.map { it.toWordInfo() })
            dao.insertWordInfos(apiWordInfo.map { it.toWordInfoEntity() })
        } catch (e: HttpException) {
            emit(Resource.Error("Oops, something went wrong", wordInfo))
        } catch (e: IOException) {
            emit(Resource.Error("Check your internet connection", wordInfo))
        }

        val newWordInfo = dao.getWord(word).map { it.toWordInfo() }
        emit(Resource.Success(newWordInfo))
    }
}