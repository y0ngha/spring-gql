package shin.yongha.springgql.resolvers

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import com.coxautodev.graphql.tools.GraphQLQueryResolver
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Component
import shin.yongha.springgql.env.FakeDatabase
import shin.yongha.springgql.model.api.CommentDTO
import shin.yongha.springgql.service.ApiService
import javax.inject.Inject

@RequiredArgsConstructor
@Component
class CommentMutationResolver @Inject constructor(
    private val fakeDatabase: FakeDatabase
) : GraphQLMutationResolver {

    fun deleteCommentByPostId(postId: Long): Boolean {
        fakeDatabase.commentList = fakeDatabase.commentList.filter { it.postId != postId }.toMutableList()
        return true

    }

    fun deleteCommentById(id: Long): Boolean {
        fakeDatabase.commentList = fakeDatabase.commentList.filter { it.id != id }.toMutableList()
        return true
    }

    fun insertComment(postId: Long, comment: CommentDTO): Boolean {
        fakeDatabase.commentList.add(
            CommentDTO(
                postId,
                fakeDatabase.commentList.maxOf { it.id } + 1L,
                comment.name,
                comment.email,
                comment.body
            )
        )
        return true
    }
}
