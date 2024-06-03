package es.babel.geekypeel.versioncatalogs.randomimage.presentation.utils

import android.app.Activity
import android.os.Build
import android.util.DisplayMetrics
import android.view.WindowManager
import androidx.annotation.RequiresApi
import es.babel.geekypeel.versioncatalogs.randomimage.presentation.model.ScreenSize

object ScreenMetric {

    val DEFAULT = ScreenSize(first = 1980, second = 1080)

    fun getScreenSize(activity: Activity) : Result<ScreenSize>{
        return runCatching {
            when {
                (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) -> getScreenSizeNew(activity)
                else -> getScreenSizeOld(activity)
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.R)
    private fun getScreenSizeNew(activity: Activity): ScreenSize {
        val windowMetrics =
            activity.getSystemService(WindowManager::class.java).currentWindowMetrics
        return ScreenSize(
            first = windowMetrics.bounds.height(),
            second = windowMetrics.bounds.width()
        )
    }

    @Suppress("DEPRECATION")
    private fun getScreenSizeOld(activity: Activity): ScreenSize {
        val displayMetrics = DisplayMetrics()
        activity.windowManager.defaultDisplay.getMetrics(displayMetrics)
        return ScreenSize(first = displayMetrics.heightPixels, second = displayMetrics.widthPixels)
    }
}
