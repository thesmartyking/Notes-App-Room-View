package com.example.roomwithview

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface WordDao {

    @Query("SELECT * from word_table ORDER BY word ASC")
    fun getAlphabetizedWords(): LiveData<List<Word>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(word: Word)

    @Query("DELETE FROM word_table")
    suspend fun deleteAll()

    @Delete
    suspend fun deleteword(word: Word)

  /*  @Delete
    suspend fun delword(txt:String)*/

/*    @Update
    suspend fun updateword(word: String)*/

/*
    @Query("UPDATE word_table SET word=:neww WHERE word=:word")
    suspend fun updateword(neww:Word,word: Word)*/

}