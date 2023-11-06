package com.achmadss.data.provider

import android.content.Context
import androidx.room.Room
import com.achmadss.data.local.database.LocalDataSource
import com.achmadss.data.remote.RemoteDataSource
import com.achmadss.data.remote.RemoteDataSourceImpl
import com.achmadss.data.remote.services.RemoteApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DataProvider {
    companion object {
        fun initializeLocalDataSource(
            context: Context
        ): LocalDataSource = Room.databaseBuilder(
            context, LocalDataSource::class.java, LocalDataSource.name
        ).fallbackToDestructiveMigration().build()

        fun initializeRemoteDataSource(baseUrl: String): RemoteDataSource {
            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(
                    HttpLoggingInterceptor()
                    .apply {
                        level = HttpLoggingInterceptor.Level.BODY
                    }
                )
                .build()

            val retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()

            return RemoteDataSourceImpl(retrofit.create(RemoteApiService::class.java))
        }

    }
}