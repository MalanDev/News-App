package lk.crud.eyepaxnews.data.remote.mapper

import lk.crud.eyepaxnews.data.remote.entity.ArticleEntity
import lk.crud.eyepaxnews.domain.model.Article

class ArticleMapper {

    fun invoke(it: ArticleEntity): Article {
        return Article(
           author = it.author,
           content = it.content,
           description = it.description,
           publishedAt = it.publishedAt,
           source = null,
           title =it.title,
           url = it.url,
           urlToImage = it.urlToImage

        )
    }

}