package lk.crud.eyepaxnews.presentation.ui.home

import lk.crud.eyepaxnews.data.remote.entity.ArticleEntity
import lk.crud.eyepaxnews.domain.model.Article

data class ArticleListState (
    val isLoading: Boolean = false,
    val news :List<Article> = emptyList(),
    val error: String = ""
)