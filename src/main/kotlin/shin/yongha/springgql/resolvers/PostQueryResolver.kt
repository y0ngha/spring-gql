package shin.yongha.springgql.resolvers

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Component
import shin.yongha.springgql.env.FakeDatabase
import shin.yongha.springgql.model.api.PostDTO
import shin.yongha.springgql.service.ApiService
import javax.inject.Inject

@RequiredArgsConstructor
@Component
class PostQueryResolver @Inject constructor(
    private val fakeDatabase: FakeDatabase
) : GraphQLQueryResolver {
    fun getPost(): List<PostDTO> {
        return fakeDatabase.postList
    }

    fun getPostById(id: Long): PostDTO {
        if(id <= 0) {
            throw Exception("ID는 1 이상이어야 합니다.")
        }
        return fakeDatabase.postList
            .find { post ->
                post.id == id
            } ?: throw Exception("데이터가 없습니다.")
    }
}
