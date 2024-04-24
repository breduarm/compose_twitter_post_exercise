package com.beam.compose_twitter_post_exercise.domain.data

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import com.beam.compose_twitter_post_exercise.R

enum class PostIconAction(
    @DrawableRes val focusIconRes: Int,
    @DrawableRes val unFocusIconRes: Int,
    @ColorRes val focusIconColor: Color,
    @ColorRes val unFocusIconColor: Color,
) {
    CHAT(
        focusIconRes = R.drawable.ic_chat_filled,
        unFocusIconRes = R.drawable.ic_chat,
        focusIconColor = Color(0xFF89939B),
        unFocusIconColor = Color(0xFF89939B),
    ),
    RT(
        focusIconRes = R.drawable.ic_rt,
        unFocusIconRes = R.drawable.ic_rt,
        focusIconColor = Color(0xFF77ED6D),
        unFocusIconColor = Color(0xFF89939B),
    ),
    LIKE(
        focusIconRes = R.drawable.ic_like_filled,
        unFocusIconRes = R.drawable.ic_like,
        focusIconColor = Color(0xFFEA3324),
        unFocusIconColor = Color(0xFF89939B),
    )
}