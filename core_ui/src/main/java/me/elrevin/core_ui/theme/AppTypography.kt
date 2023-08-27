package me.elrevin.core_ui.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import me.elrevin.core_ui.R


val appFamily = FontFamily(
    Font(R.font.poppins_bold, FontWeight.Bold),
    Font(R.font.poppins_regular, FontWeight.Normal),
)

object AppTypography {
    val head = TextStyle(
        fontFamily = appFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 56.sp,
        lineHeight = 68.sp
    )

    val H4Bold = TextStyle(
        fontFamily = appFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        lineHeight = 32.sp
    )

    val body = TextStyle(
        fontFamily = appFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 16.sp
    )

    val bodyBold = TextStyle(
        fontFamily = appFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        lineHeight = 16.sp
    )
}