package com.louay.taskcv.data.secondFragment

import android.content.SharedPreferences
import com.google.gson.Gson
import com.louay.taskcv.data.secondFragment.repo.RepoImpl
import com.louay.taskcv.domain.secondFragment.Repo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SecondModule {
    @Singleton
    @Provides
    fun provideSecondRepository(
        appPreferences: SharedPreferences,
        gson: Gson,
    ): Repo {
        return RepoImpl(appPreferences, gson)
    }
}