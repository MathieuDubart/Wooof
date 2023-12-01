package fr.mathieudubart.wooof.models

import android.media.Image
import androidx.compose.ui.graphics.painter.Painter

data class OnBoardingPage(
    var title: String,
    var description: String,
    var imagePainter: Painter,
    var imageAlt: String,
)