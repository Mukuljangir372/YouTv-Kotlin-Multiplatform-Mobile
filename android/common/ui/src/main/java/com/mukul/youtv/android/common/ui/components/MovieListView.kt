package com.mukul.youtv.android.common.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.mukul.youtv.android.common.ui.Dimens
import com.mukul.youtv.shared.data.movie.models.Movie

@Composable
fun MovieListView(
    modifier: Modifier,
    movie: Movie
) {
    val context = LocalContext.current

    Box(
        modifier = modifier.clip(RoundedCornerShape(Dimens.One)),
    ) {
        AsyncImage(
            modifier = modifier,
            model = ImageRequest.Builder(context)
                .data(movie.poster)
                .build(),
            contentScale = ContentScale.Crop,
            contentDescription = null
        )
    }
}