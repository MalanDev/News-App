package lk.crud.eyepaxnews.data.remote

import lk.crud.eyepaxnews.data.remote.entity.ArticleListEntity
import retrofit2.http.GET

interface NewsApi {

    @GET("/v2/everything")
    suspend fun getEverything(): ArticleListEntity
}