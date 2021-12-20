package shin.yongha.springgql

import org.springframework.stereotype.Component
import shin.yongha.springgql.env.FakeDatabase
import shin.yongha.springgql.service.ApiService
import javax.inject.Inject

@Component
class Initialize @Inject constructor(
    private val fakeDatabase: FakeDatabase,
    private val apiService: ApiService
) {

   fun initialize() {
       // 가짜 Database에 데이터를 채워넣는 역할
       fakeDatabase.postList.addAll(apiService.getPosts())
       fakeDatabase.commentList.addAll(apiService.getComments())
   }
}
