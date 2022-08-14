package lk.crud.eyepaxnews.domain.userCase

import kotlinx.coroutines.flow.flow
import lk.crud.eyepaxnews.common.Resource
import lk.crud.eyepaxnews.domain.model.News
import lk.crud.eyepaxnews.domain.repository.NewsRepository
import retrofit2.HttpException
import java.io.IOException
import java.util.concurrent.Flow
import javax.inject.Inject

class GetArticlesUseCase @Inject constructor(private val newsRepository: NewsRepository) {

    operator fun invoke() = flow {
        try{
            emit(Resource.Loading())
            val news = newsRepository.getNews()
            emit(Resource.Success(news))
        } catch(e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch(e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        }
    }
}