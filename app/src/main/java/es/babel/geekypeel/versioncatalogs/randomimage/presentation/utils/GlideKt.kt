package es.babel.geekypeel.versioncatalogs.randomimage.presentation.utils

import android.content.Context
import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target

object GlideKt {

    fun loadNewImage(
        context: Context,
        url: String,
        requestListener: RequestListener<Drawable>?,
        imageView: ImageView
    ) = Glide.with(context)
        .load(url)
        .diskCacheStrategy(DiskCacheStrategy.NONE)
        .skipMemoryCache(true)
        .addListener(requestListener)
        .into(imageView)

    fun getRequestListener(
        onLoadFailed: () -> Boolean,
        onResourceReady: () -> Boolean
    ): RequestListener<Drawable> {
        return object : RequestListener<Drawable> {
            override fun onLoadFailed(
                e: GlideException?,
                model: Any?,
                target: Target<Drawable>,
                isFirstResource: Boolean
            ) = onLoadFailed.invoke()

            override fun onResourceReady(
                resource: Drawable,
                model: Any,
                target: Target<Drawable>?,
                dataSource: DataSource,
                isFirstResource: Boolean
            ) = onResourceReady.invoke()
        }
    }
}
