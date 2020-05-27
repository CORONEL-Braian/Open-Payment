package org.techdev.openpayment.data.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RetrofitService @Inject constructor(
    private val okHttpClientBuilder: OkHttpClient.Builder,
    private val retrofitBuilder: Retrofit.Builder
) {

    /**
     * PRO: Read result of response
     */
    fun <T> createService(originalService: Class<T>): T {
        val okHttpClient = okHttpClientBuilder.build()

        return retrofitBuilder
            .client(okHttpClient)
            .build()
            .create(originalService)

    }

}