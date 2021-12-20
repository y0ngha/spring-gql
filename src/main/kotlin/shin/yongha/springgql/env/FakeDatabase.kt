package shin.yongha.springgql.env

import org.springframework.stereotype.Component
import shin.yongha.springgql.model.api.CommentDTO
import shin.yongha.springgql.model.api.PostDTO

@Component
class FakeDatabase {
    var postList: MutableList<PostDTO> = mutableListOf()
    var commentList: MutableList<CommentDTO> = mutableListOf()
}
