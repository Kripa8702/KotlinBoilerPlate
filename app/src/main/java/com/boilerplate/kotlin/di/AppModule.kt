package com.boilerplate.kotlin.di

import com.boilerplate.kotlin.api.ApiService
import com.boilerplate.kotlin.interceptors.LoggingInterceptor
import com.boilerplate.kotlin.repositories.network.DummyRepository
import com.boilerplate.kotlin.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
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

    /** Dummy Repository ---------------- */
    @Provides
    fun providesDummyRepository(apiService: ApiService) = DummyRepository(apiService)

    /** Room Database ---------------------------------------- */

//    /** Cart ------------------------- */
    // DB
//    @Provides
//    fun providesCartDatabase(
//        @ApplicationContext
//        context: Context
//    ) = Room.databaseBuilder(
//        context,
//        CartDatabase::class.java,
//        "cart_database"
//    ).build()
//
    // Dao
//    @Provides
//    fun providesCartDao(cartDatabase: CartDatabase) = cartDatabase.cartDao
//
    // Repository
//    @Provides
//    fun providesCartRepository(cartDao: CartDao): CartEventRepository =
//        CartEventRepositoryImpl(cartDao)

}