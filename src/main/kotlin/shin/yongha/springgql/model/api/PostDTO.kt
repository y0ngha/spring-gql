package shin.yongha.springgql.model.api

import com.google.gson.annotations.SerializedName

data class PostDTO(
    @SerializedName("userId")
    val userId: Long,
    @SerializedName("id")
    val id: Long,
    @SerializedName("title")
    val title: String,
    @SerializedName("body")
    val body: String,
)
