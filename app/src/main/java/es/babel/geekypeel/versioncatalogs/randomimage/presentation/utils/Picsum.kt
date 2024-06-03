package es.babel.geekypeel.versioncatalogs.randomimage.presentation.utils

import android.app.Activity
import es.babel.geekypeel.versioncatalogs.randomimage.R
import es.babel.geekypeel.versioncatalogs.randomimage.presentation.extensions.getHeight
import es.babel.geekypeel.versioncatalogs.randomimage.presentation.extensions.getWidth
import es.babel.geekypeel.versioncatalogs.randomimage.presentation.model.ScreenSize
import es.babel.geekypeel.versioncatalogs.randomimage.presentation.extensions.getQuarter

object Picsum {

    fun getRandomImageURL(activity: Activity, screenSize: ScreenSize): String {
        return activity.getString(
            R.string.main_activity_load_image_url_pattern,
            screenSize.getWidth().getQuarter(), screenSize.getHeight().getQuarter()
        )
    }
}
