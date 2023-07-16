package com.example.lovecolculator.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.lovecolculator.remote.LoveModel

@Database(entities = [LoveModel::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun loveDao(): LoveDao
}