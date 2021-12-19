package shin.yongha.springgql.service

import ApiServiceContext
import org.springframework.core.env.Environment
import org.springframework.stereotype.Service
import retrofit2.Call
import shin.yongha.springgql.model.api.CommentDTO
import shin.yongha.springgql.model.api.PostDTO
import shin.yongha.springgql.retrofit.jsonplaceholder.JsonPlaceHolderInterface
import javax.inject.Inject

@Service
class ApiService @Inject constructor(
    private val environment: Environment
) {
    private var jsonPlaceHolderInterface: JsonPlaceHolderInterface? = null
    init {
        val apiAddress = environment.getProperty("jsonPlaceHolder.apiAddress")
        if(!apiAddress.isNullOrEmpty()) {
            jsonPlaceHolderInterface = ApiServiceContext(apiAddress, 60L).getApiService()
        } else {
            throw Exception("API 주소가 정의되지 않았습니다.")
        }
    }

    fun getPosts(): List<PostDTO> {
        return call(jsonPlaceHolderInterface?.getPosts())
    }

    fun getComments(): List<CommentDTO> {
        return call(jsonPlaceHolderInterface?.getComments())
    }

    private fun<T> call(t: Call<T>?): T {
        if(t == null) {
            throw Exception("API Service 가 없습니다.")
        }  else {
            val result = t.execute().body()
            if (result == null) {
                throw Exception("${t.javaClass.simpleName} 을 불러오지 못했습니다.")
            } else {
                return result
            }
        }
    }

}
