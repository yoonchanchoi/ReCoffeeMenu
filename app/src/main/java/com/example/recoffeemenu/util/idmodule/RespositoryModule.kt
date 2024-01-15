package com.example.recoffeemenu.util.idmodule

import com.example.recoffeemenu.network.repository.CoffeeRepository
import com.example.recoffeemenu.network.repository.CoffeeRepositoryImpl
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
    abstract fun bindRepository(coffeeRepositoryImpl: CoffeeRepositoryImpl): CoffeeRepository

}