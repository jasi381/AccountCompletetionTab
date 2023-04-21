package com.example.test.utils

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import com.example.test.R

object Utils {
    private const val backGroundColorStr= "#07132D"
    val backGroundColor= Color(android.graphics.Color.parseColor(backGroundColorStr))

    private const val stroke = "#0D2148"
    val strokeColor= Color(android.graphics.Color.parseColor(stroke))

    private const val checkColor = "#CF0A2C"
    val checkedColor= Color(android.graphics.Color.parseColor(checkColor))

    val acuminProFont  = FontFamily(Font(R.font.acumin_pro_semibold))

    val imageUrls = listOf(
        "https://loodibee.com/wp-content/uploads/nba-atlanta-hawks-logo-300x300.png",
        "https://loodibee.com/wp-content/uploads/nba-boston-celtics-logo-300x300.png",
        "https://loodibee.com/wp-content/uploads/nba-brooklyn-nets-logo-300x300.png",
        "https://loodibee.com/wp-content/uploads/nba-charlotte-hornets-logo-300x300.png",
        "https://loodibee.com/wp-content/uploads/nba-chicago-bulls-logo-300x300.png",
        "https://loodibee.com/wp-content/uploads/nba-cleveland-cavaliers-logo-300x300.png",
        "https://loodibee.com/wp-content/uploads/nba-dallas-mavericks-logo-300x300.png",
        "https://loodibee.com/wp-content/uploads/nba-los-angeles-lakers-logo-300x300.png",
        "https://loodibee.com/wp-content/uploads/nba-detroit-pistons-logo-300x300.png",
    )
}