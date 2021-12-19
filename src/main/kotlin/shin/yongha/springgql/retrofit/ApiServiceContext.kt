import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import shin.yongha.springgql.retrofit.jsonplaceholder.JsonPlaceHolderInterface
import java.time.LocalDateTime
import java.util.concurrent.TimeUnit

class ApiServiceContext(
    private val baseApiUrl: String,
    private val timeoutSecond: Long
) {

    private lateinit var retrofit: Retrofit

    init {
        val baseUrl = if(!baseApiUrl.endsWith("/")) {
            "$baseApiUrl/"
        } else {
            baseApiUrl
        }

        val loggingInterceptor = HttpLoggingInterceptor {
            val time = LocalDateTime.now()
            println("${time.hour}:${time.minute.toString().padStart(2, '0')}:${time.second.toString().padStart(2, '0')} : $it")
        }.apply { level = HttpLoggingInterceptor.Level.BODY }

        val client = OkHttpClient.Builder()
            .connectTimeout(timeoutSecond, TimeUnit.SECONDS)
            .writeTimeout(timeoutSecond, TimeUnit.SECONDS)
            .readTimeout(timeoutSecond, TimeUnit.SECONDS)
            .cache(null)
            .addInterceptor(loggingInterceptor)
            .build()

        retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getApiService(): JsonPlaceHolderInterface {
        return retrofit.create(JsonPlaceHolderInterface::class.java)
    }
}
