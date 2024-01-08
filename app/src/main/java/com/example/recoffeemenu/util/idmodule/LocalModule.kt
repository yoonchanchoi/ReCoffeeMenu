package com.football.view.fifa.util.idmodule

import android.content.Context
import android.content.SharedPreferences
import com.example.recoffeemenu.model.Coffee
import com.example.recoffeemenu.model.LocalJson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalModule {

    @Provides
    @Singleton
    fun proviedeEncryptedSharedPreferences(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences(context.packageName+ "_preferences", Context.MODE_PRIVATE)
    }

    @Singleton
    @Provides
    fun provideLocalData(
        @ApplicationContext context: Context
    ): LocalJson {
        return LocalJson(context.assets.open("menu.json").reader().readText())
    }

//    @Singleton
//    @Provides
//    fun provideMovieRepository(
//        movieRemoteDataSource: MovieRemoteDataSource,
//        movieLocalDataSource: MovieLocalDataSource,
//        ktorInterface: KtorInterface,
//    ): MovieRepository {
//        return MovieRepositoryImpl(movieRemoteDataSource, movieLocalDataSource, ktorInterface)
//    }


//    @Provides
//    @Singleton
//    fun provideOkHttpClient(
//        headersInterceptor: HeadersInterceptor
//    ): OkHttpClient {
//        val logInterceptor = HttpLoggingInterceptor()
//        logInterceptor.level = HttpLoggingInterceptor.Level.BODY
//        return OkHttpClient.Builder()
//            .addInterceptor(logInterceptor)
//            .addInterceptor(headersInterceptor)
//            .build()
//    }
//
//    @Provides
//    @Singleton
//    fun provideRetrofit(@FifaOkHttpClient okHttpClient: OkHttpClient): FIFAService {
//        return Retrofit.Builder()
//            .baseUrl(Constants.BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
//            .client(okHttpClient)
//            .build().create(FIFAService::class.java)
//    }
}