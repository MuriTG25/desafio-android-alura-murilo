package br.com.alura.desasafio_android.di.module

import br.com.alura.desasafio_android.infraestrutura.webservice.PerfilUsuarioService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RestApiModule {
    @Provides
    @Singleton
    fun provideRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://api.github.com/users/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    @Provides
    @Singleton
    fun providePerfilUsuarioService(retrofit: Retrofit): PerfilUsuarioService{
        return retrofit.create(PerfilUsuarioService::class.java)
    }
}