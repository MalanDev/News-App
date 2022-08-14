package lk.crud.eyepaxnews.domain.repository

import lk.crud.eyepaxnews.domain.model.Article

interface NewsRepository {

    suspend fun getNews():List<Article>
}