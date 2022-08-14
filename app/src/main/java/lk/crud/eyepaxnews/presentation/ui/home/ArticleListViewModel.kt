package lk.crud.eyepaxnews.presentation.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import lk.crud.eyepaxnews.common.Resource
import lk.crud.eyepaxnews.domain.userCase.GetArticlesUseCase
import javax.inject.Inject

@HiltViewModel
class ArticleListViewModel @Inject constructor(
    private val getArticlesUseCase: GetArticlesUseCase
):ViewModel() {
    private val _state = MutableLiveData(ArticleListState())
    val state: LiveData<ArticleListState> = _state

    init {
        getArticles()
    }

    private fun getArticles() {
        getArticlesUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    result.data?.let {
                        _state.value = ArticleListState(news = it)
                    }

                }
                is Resource.Loading -> {
                    _state.value = ArticleListState(isLoading = true)
                }
                is Resource.Error -> {
                    _state.value =
                        ArticleListState(error = result.message ?: "An unexpected error occured")
                }
            }
        }.launchIn(viewModelScope)
    }
}