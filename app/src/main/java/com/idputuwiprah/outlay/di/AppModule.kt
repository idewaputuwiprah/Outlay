package com.idputuwiprah.outlay.di

import android.content.Context
import com.idputuwiprah.outlay.data.OutlayDao
import com.idputuwiprah.outlay.data.OutlayRoomDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideOutlayDatabase(
        @ApplicationContext context: Context): OutlayRoomDatabase = OutlayRoomDatabase.getDatabase(context)

    @Singleton
    @Provides
    fun provideOutlayDao(outlayRoomDatabase: OutlayRoomDatabase): OutlayDao = outlayRoomDatabase.outlayDao
}