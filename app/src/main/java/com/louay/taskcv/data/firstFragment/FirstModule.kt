package com.louay.taskcv.data.firstFragment

import android.content.SharedPreferences
import com.google.gson.Gson
import com.louay.taskcv.data.firstFragment.repo.RepoImpl
import com.louay.taskcv.domain.firstFragment.Repo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object FirstModule {
    @Singleton
    @Provides
    fun provideFirstRepository(
        appPreferences: SharedPreferences,
        gson: Gson,
    ): Repo {
        return RepoImpl(appPreferences, gson)
    }
}