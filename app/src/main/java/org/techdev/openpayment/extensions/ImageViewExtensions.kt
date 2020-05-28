package org.techdev.openpayment.extensions

import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.ImageView
import android.widget.ProgressBar
import com.bumptech.glide.Glide
import org.techdev.openpayment.R

fun ImageView.loadFromUrl(url: String, progressBar: ProgressBar? = null) {
    progressBar?.let { it.visibility = VISIBLE }
    Glide.with(context)
        .load(url)
        .centerCrop()
        .placeholder(android.R.drawable.stat_notify_error)
        .error(Glide.with(this)
        .load(R.drawable.ic_baseline_error))
        .into(this)
    progressBar?.let { it.visibility = GONE }
}