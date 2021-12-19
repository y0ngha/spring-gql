package shin.yongha.springgql

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication


@SpringBootApplication(scanBasePackages = ["shin.yongha.springgql"])
class SpringGqlApplication {
    fun main(args: Array<String>) {
        SpringApplication.run(SpringGqlApplication::class.java, *args)
    }
}

fun main() {
    SpringApplication.run(SpringGqlApplication::class.java)
}
