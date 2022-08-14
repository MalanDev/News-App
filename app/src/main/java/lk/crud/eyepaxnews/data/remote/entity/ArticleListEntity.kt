package lk.crud.eyepaxnews.data.remote.entity


data class ArticleListEntity(
    val articles: List<ArticleEntity>,
    val status: String,
    val totalResults: Int
)

