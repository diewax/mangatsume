package com.achmadss.mvi.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.Role
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import coil.request.ImageRequest
import com.achmadss.mvi.R
import com.achmadss.mvi.utils.rememberResourceBitmapPainter

enum class MangaCoverRatio(val value: Float) {
    Square(1f / 1f),
    Book(2f / 3f)
}

@Composable
fun MangaCover(
    modifier: Modifier = Modifier,
    data: Any?,
    ratio: MangaCoverRatio = MangaCoverRatio.Book,
    contentDescription: String = "",
    shape: Shape = MaterialTheme.shapes.extraSmall,
    onImageLoad: ((AsyncImagePainter.State.Success) -> Unit)? = null,
    onClick: (() -> Unit)? = null,
) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(data)
            .crossfade(true)
            .build(),
        placeholder = ColorPainter(CoverPlaceholderColor),
        error = rememberResourceBitmapPainter(id = R.drawable.cover_error),
        contentDescription = contentDescription,
        onSuccess = onImageLoad,
        modifier = modifier
            .aspectRatio(ratio.value)
            .clip(shape)
            .then(
                if (onClick != null) {
                    Modifier.clickable(
                        role = Role.Button,
                        onClick = onClick,
                    )
                } else {
                    Modifier
                },
            ),
        contentScale = ContentScale.Crop,
    )
}

private val CoverPlaceholderColor = Color(0x1F888888)