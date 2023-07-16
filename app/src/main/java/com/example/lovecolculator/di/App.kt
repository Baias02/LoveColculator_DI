package com.example.lovecolculator.di

import android.app.Application
import androidx.room.Room
import com.example.lovecolculator.database.AppDatabase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {


    override fun onCreate() {
        super.onCreate()
        appDatabase =
            Room.databaseBuilder(applicationContext, AppDatabase::class.java, "love-table")
                .allowMainThreadQueries().build()
    }

    companion object {
        lateinit var appDatabase: AppDatabase
    }
}