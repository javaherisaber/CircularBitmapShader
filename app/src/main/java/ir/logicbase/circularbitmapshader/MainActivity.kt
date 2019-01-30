package ir.logicbase.circularbitmapshader

import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import ir.logicbase.circularbitmapshader.network.ApiClient
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import okhttp3.ResponseBody

class MainActivity : AppCompatActivity() {

    companion object {
        private const val BITMAP_URL = "http://s8.picofile.com/file/8343026392/logo3.png"
    }

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        loadMarkers(BITMAP_URL)
    }

    private fun loadMarkers(url: String) {
        compositeDisposable.add(
            ApiClient.getGenericApi()
                .download(url)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<ResponseBody>() {
                    override fun onSuccess(t: ResponseBody) {
                        val bitmap = BitmapFactory.decodeStream(t.byteStream())
                        CircularBitmapShader(bitmap)
                            .into(imageView1)
                            .into(imageView2)
                            .into(imageView3)
                            .into(imageView4)
                            .into(imageView5)
                            .into(imageView6)
                            .recycleSrcBitmap()
                    }

                    override fun onError(e: Throwable) {
                        // do nothing
                    }
                })
        )
    }

    override fun onDestroy() {
        compositeDisposable.clear()
        super.onDestroy()
    }
}
