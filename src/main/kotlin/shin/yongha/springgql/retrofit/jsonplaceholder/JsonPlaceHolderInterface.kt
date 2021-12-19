package shin.yongha.springgql.retrofit.jsonplaceholder

import retrofit2.Call
import retrofit2.http.GET
import shin.yongha.springgql.model.api.CommentDTO
import shin.yongha.springgql.model.api.PostDTO

interface JsonPlaceHolderInterface {
    @GET("/posts")
    fun getPosts(): Call<List<PostDTO>>
    @GET("/comments")
    fun getComments(): Call<List<CommentDTO>>
//    @GET("/albums")
//    fun getAlbums()
//    @GET("/photos")
//    fun getPhotos()
//    @GET("/todos")
//    fun getTodos()
//    @GET("/users")
//    fun getUsers()
}
