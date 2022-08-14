package lk.crud.eyepaxnews.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import lk.crud.eyepaxnews.common.Constants
import lk.crud.eyepaxnews.data.remote.NewsApi
import lk.crud.eyepaxnews.data.remote.mapper.ArticleMapper
import lk.crud.eyepaxnews.data.repository.NewsRepositoryImpl
import lk.crud.eyepaxnews.domain.repository.NewsRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    @Singleton
    fun providerNewsApi():NewsApi{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsRepository(api: NewsApi,articleMapper: ArticleMapper):NewsRepository{
        return NewsRepositoryImpl(api,articleMapper)
    }

    @Provides
    @Singleton
    fun provideArticleMapper():ArticleMapper{
        return ArticleMapper()
    }
}