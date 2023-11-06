package com.achmadss.mvi.utils

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import com.achmadss.mvi.SecondaryItemAlpha

fun Modifier.secondaryItemAlpha(): Modifier = this.alpha(SecondaryItemAlpha)