package com.example.lovecolculator.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.lovecolculator.remote.LoveModel

@Dao
interface LoveDao {

    @Query("SELECT * FROM love_table")
    fun getAll(): List<LoveModel>

    @Insert
    fun insertLove(loveModel: LoveModel)

    @Query("SELECT * FROM love_table ORDER BY firstName ASC")
    fun getAllSort(): List<LoveModel>
}