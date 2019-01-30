package ir.logicbase.circularbitmapshader.network

import io.reactivex.Single
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Url

interface GenericApi {
    @GET
    fun download(@Url url: String): Single<ResponseBody>
}