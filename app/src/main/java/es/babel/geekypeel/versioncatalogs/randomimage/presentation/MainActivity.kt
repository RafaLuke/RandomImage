package es.babel.geekypeel.versioncatalogs.randomimage.presentation

import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AlertDialog.Builder
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import es.babel.geekypeel.versioncatalogs.randomimage.R
import es.babel.geekypeel.versioncatalogs.randomimage.databinding.ActivityMainBinding
import es.babel.geekypeel.versioncatalogs.randomimage.presentation.utils.GlideKt
import es.babel.geekypeel.versioncatalogs.randomimage.presentation.utils.Picsum
import es.babel.geekypeel.versioncatalogs.randomimage.presentation.utils.ScreenMetric


class MainActivity : AppCompatActivity() {

    private var requestListener = GlideKt.getRequestListener(::onLoadFailed, ::onResourceReady)

    private lateinit var binding: ActivityMainBinding

    private lateinit var url: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        hideStatusAndNavBar()

        binding = ActivityMainBinding.inflate(layoutInflater)
        with(binding) {
            setContentView(this.root)
            this.ivPhotoViewer.setOnClickListener { _: View? ->
                loadRandomImage()
            }
        }

        val screenSize = ScreenMetric
            .getScreenSize(this@MainActivity)
            .getOrDefault(null)

        url = Picsum.getRandomImageURL(
            activity = this@MainActivity,
            screenSize = (screenSize ?: ScreenMetric.DEFAULT)
        )
    }

    override fun onResume() {
        super.onResume()
        loadRandomImage()
    }

    private fun loadRandomImage() {
        binding.pbProgress.isVisible = true
        GlideKt.loadNewImage(
            context = this@MainActivity,
            url = url,
            requestListener = requestListener,
            imageView = binding.ivPhotoViewer
        )
    }

    private fun onLoadFailed(): Boolean {
        binding.pbProgress.isVisible = false
        Builder(this@MainActivity)
            .setTitle(R.string.main_activity_load_image_error_dialog_title)
            .setMessage(R.string.main_activity_load_image_error_dialog_message)
            .setPositiveButton(R.string.main_activity_load_image_error_dialog_button) { dialog, _ ->
                dialog.dismiss()
                finish()
            }.create().show()
        return false
    }

    private fun onResourceReady(): Boolean {
        binding.pbProgress.isVisible = false
        return false
    }

    private fun hideStatusAndNavBar() {
        window.apply {
            addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
            decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or
                    View.SYSTEM_UI_FLAG_FULLSCREEN or
                    View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        }
    }
}
