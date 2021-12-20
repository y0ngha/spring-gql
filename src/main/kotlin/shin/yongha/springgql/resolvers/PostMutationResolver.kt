package shin.yongha.springgql.resolvers

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import com.coxautodev.graphql.tools.GraphQLQueryResolver
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Component
import shin.yongha.springgql.env.FakeDatabase
import shin.yongha.springgql.model.api.CommentDTO
import shin.yongha.springgql.model.api.PostDTO
import shin.yongha.springgql.service.ApiService
import javax.inject.Inject

@RequiredArgsConstructor
@Component
class PostMutationResolver @Inject constructor(
    private val fakeDatabase: FakeDatabase
) : GraphQLMutationResolver {
    fun deletePostById(id: Long): Boolean {
        fakeDatabase.postList = fakeDatabase.postList.filter { it.id != id }.toMutableList()
        return true
    }

    fun insertPost(post: PostDTO): Boolean {
        fakeDatabase.postList.add(PostDTO(
            post.userId,
            fakeDatabase.postList.maxOf { it.id } + 1L,
            post.title,
            post.body
        ))
        return true
    }

    fun insertPostAfterView(post: PostDTO): PostDTO {
        if(!insertPost(post)) {
            throw Exception("Insert Post Failed")
        }
        return fakeDatabase.postList.last()
    }
}
