package com.boilerplate.kotlin.di

import android.content.Context
import androidx.room.Room
import com.boilerplate.kotlin.api.ApiService
import com.boilerplate.kotlin.interceptors.LoggingInterceptor
import com.boilerplate.kotlin.repositories.network.UsersRepository
import com.boilerplate.kotlin.repositories.room.DummyRoomRepository
import com.boilerplate.kotlin.room.dummy.DummyDao
import com.boilerplate.kotlin.room.dummy.DummyDatabase
import com.boilerplate.kotlin.room.dummy.DummyRoomRepositoryImpl
import com.boilerplate.kotlin.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        val loggingInterceptor = LoggingInterceptor()

        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .connectTimeout(10, TimeUnit.SECONDS) // Set connection timeout if needed
            .readTimeout(10, TimeUnit.SECONDS) // Set read timeout if needed
            .build()
    }

    @Provides
    fun providesBaseUrl(): String {
        return Constants.BASE_URL
    }

    @Provides
    fun providesApiService(baseUrl: String, okHttpClient: OkHttpClient): ApiService {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }


    /** Network Repository ------------------------------------ */

    /** --- Dummy ---------------- */
    @Provides
    fun providesDummyRepository(apiService: ApiService) = UsersRepository(apiService)


    /** Room Database ---------------------------------------- */

    /** --- Dummy ------------------------- */
    @Provides
    fun providesDummyDatabase(
        @ApplicationContext
        context: Context
    ): DummyDatabase {
        return Room.databaseBuilder(
            context,
            DummyDatabase::class.java,
            "dummy_database"
        ).build()
    }

    @Provides
    fun providesDummyDao(dummyDatabase: DummyDatabase) = dummyDatabase.dummyDao

    @Provides
    fun providesDummyRoomRepository(dummyDao: DummyDao): DummyRoomRepository =
        DummyRoomRepositoryImpl(dummyDao)
}