package com.example.roomwithview

import androidx.lifecycle.LiveData
//import androidx.annotation.WorkerThread

class WordRepository(private val wordDao: WordDao)
{
    val allWords: LiveData<List<Word>> = wordDao.getAlphabetizedWords()
    suspend fun insert(word: Word)
    {
        wordDao.insert(word)
    }
    suspend fun deleteword(word: Word)
    {
        wordDao.deleteword(word)
    }
  /*  suspend fun updateword(word: String)
    {
        wordDao.updateword(word)
    }*/
    /*suspend fun delword(txt: String)
    {
        wordDao.delword(txt)
    }*/


}