package lk.crud.eyepaxnews.domain.model

import lk.crud.eyepaxnews.data.remote.entity.ArticleEntity


data class News(
    val articles: List<ArticleEntity>,
    val status: String,
    val totalResults: Int
)
