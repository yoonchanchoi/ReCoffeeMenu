package com.example.recoffeemenu.util.idmodule

import com.example.recoffeemenu.network.repository.CoffeeDataSource
import com.example.recoffeemenu.network.repository.CoffeeDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RespositoryModule {

    @Binds
    @Singleton
    abstract fun bindRepository(CoffeeDataSourceImpl: CoffeeDataSourceImpl): CoffeeDataSource

}