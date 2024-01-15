package com.example.recoffeemenu.util.idmodule

import android.content.Context
import com.example.recoffeemenu.network.repository.CoffeeRepository
import com.example.recoffeemenu.network.repository.CoffeeRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import org.json.JSONObject
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkProviderModule {

    @Singleton
    @Provides
    fun provideLocalData(
        @ApplicationContext context: Context
    ): CoffeeRepository {
        return CoffeeRepositoryImpl(JSONObject(context.assets.open("menu.json").reader().readText()))
    }
}


//    @Singleton
//    @Provides
//    fun provideLocalData(
//        @ApplicationContext context: Context
//    ): JSONObject {
//        return JSONObject(context.assets.open("menu.json").reader().readText()
//        )
//    }

//    @Singleton
//    @Provides
//    fun provideLocalData(
//        @ApplicationContext context: Context
//    ): LocalJson {
//        return LocalJson(context.assets.open("menu.json").reader().readText())
//    }

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