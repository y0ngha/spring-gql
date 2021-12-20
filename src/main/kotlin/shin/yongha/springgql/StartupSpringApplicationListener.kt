package shin.yongha.springgql

import org.springframework.context.ApplicationListener
import org.springframework.context.event.ContextRefreshedEvent
import org.springframework.stereotype.Component
import javax.inject.Inject

@Component
class StartupSpringApplicationListener @Inject constructor(
    private val initialize: Initialize
) : ApplicationListener<ContextRefreshedEvent> {
    override fun onApplicationEvent(event: ContextRefreshedEvent) {
        /**
         * Spring Application Context 의 Bean 이 모두 초기화 되고 딱 한번 실행됩니다.
         */
        initialize.initialize()
        println("########## initialize Complete #########")
    }
}
