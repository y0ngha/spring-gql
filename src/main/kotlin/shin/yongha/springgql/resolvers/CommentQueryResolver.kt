package shin.yongha.springgql.resolvers

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Component
import shin.yongha.springgql.env.FakeDatabase
import shin.yongha.springgql.model.api.CommentDTO
import shin.yongha.springgql.service.ApiService
import javax.inject.Inject

@RequiredArgsConstructor
@Component
class CommentQueryResolver @Inject constructor(
    private val fakeDatabase: FakeDatabase
) : GraphQLQueryResolver {
    fun getComment(): List<CommentDTO> {
        return fakeDatabase.commentList
    }

    fun getCommentByPostId(postId: Long): List<CommentDTO> {
        if(postId <= 0) {
            throw Exception("ID는 1 이상이어야 합니다.")
        }
        return fakeDatabase.commentList
            .filter { comment ->
                return@filter comment.postId == postId
            }
    }
}
