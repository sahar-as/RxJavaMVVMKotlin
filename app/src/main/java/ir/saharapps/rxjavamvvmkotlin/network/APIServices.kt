package ir.saharapps.rxjavamvvmkotlin.network

import io.reactivex.Observable
import ir.saharapps.rxjavamvvmkotlin.model.PostModel
import retrofit2.http.GET

interface APIServices {
    @GET("posts")
    fun getPosts(): Observable<MutableList<PostModel>>
}