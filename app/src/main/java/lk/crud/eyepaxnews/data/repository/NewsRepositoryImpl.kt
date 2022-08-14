package lk.crud.eyepaxnews.data.repository

import lk.crud.eyepaxnews.data.remote.NewsApi
import lk.crud.eyepaxnews.data.remote.mapper.ArticleMapper
import lk.crud.eyepaxnews.domain.model.Article
import lk.crud.eyepaxnews.domain.repository.NewsRepository
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(private val api: NewsApi,private val articleMapper: ArticleMapper) :NewsRepository{
    override suspend fun getNews(): List<Article> {
        return api.getEverything().articles.map {
            articleMapper.invoke(it)
        }
    }


}