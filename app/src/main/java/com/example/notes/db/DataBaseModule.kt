package com.example.notes.db

import android.content.Context
import androidx.room.Room
import com.example.notes.util.buildDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataBaseModule {

    @Provides
    @Singleton
    fun provideNoteDao(@ApplicationContext context: Context): NoteDao {
        return Room.buildDB(context).getNoteDao()
    }

    @Provides
    @Singleton
    fun provideUserDao(@ApplicationContext context: Context): UserDao {
        return Room.buildDB(context).getUserDao()
    }
}