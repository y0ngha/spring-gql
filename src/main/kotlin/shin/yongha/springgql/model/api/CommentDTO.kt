package shin.yongha.springgql.model.api

import com.google.gson.annotations.SerializedName

data class CommentDTO(
    @SerializedName("postId")
    val postId: Long,
    @SerializedName("id")
    val id: Long,
    @SerializedName("name")
    val name: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("body")
    val body: String,
)
