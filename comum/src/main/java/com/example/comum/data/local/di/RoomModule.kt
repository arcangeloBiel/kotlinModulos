package com.example.comum.data.local.di

import androidx.room.Room
import com.example.comum.data.local.database.AppDatabase
import org.koin.dsl.module

val RoomModule = module {
    factory {
        get<AppDatabase>().usuarioSessionDao()
    }

    single {
        Room.databaseBuilder(
            get(),
            AppDatabase::class.java,
            "app_havan_database"
        )
            .fallbackToDestructiveMigration().build()
    }

}