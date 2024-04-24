package com.beam.compose_twitter_post_exercise

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.MoreHoriz
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.beam.compose_twitter_post_exercise.domain.data.PostIconAction
import com.beam.compose_twitter_post_exercise.ui.theme.Compose_twitter_post_exerciseTheme

@Composable
fun PostScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF161D26))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            ProfileAvatar()
            Spacer(modifier = Modifier.width(16.dp))
            PostItem()
        }
        Divider(modifier = Modifier.fillMaxWidth().height(0.5.dp), color = Color.Gray)
    }
}

@Composable
fun ProfileAvatar() {
    Image(
        painter = painterResource(id = R.drawable.profile),
        contentDescription = "Profile avatar",
        modifier = Modifier
            .size(50.dp)
            .clip(CircleShape),
    )
}

@Composable
fun PostItem() {
    Column {
        PostItemHeader()
        PostItemBody()
        PostItemFooter()
    }
}

@Composable
fun PostItemHeader() {
    Row {
        Text(text = "Beam", fontWeight = FontWeight.ExtraBold, color = Color.White)
        Text(
            text = "@BryanArm",
            color = Color.Gray,
            modifier = Modifier.padding(start = 12.dp)
        )
        Text(
            text = "4h",
            color = Color.Gray,
            modifier = Modifier.padding(start = 12.dp)
        )
        Icon(
            imageVector = Icons.Outlined.MoreHoriz,
            contentDescription = "More icon",
            modifier = Modifier
                .weight(1f)
                .wrapContentSize(Alignment.CenterEnd),
            tint = Color.White
        )
    }
}

@Composable
fun PostItemBody() {
    Column {
        Text(
            text = LoremIpsum(35).values.first(),
            color = Color.White,
            fontSize = 14.sp,
            letterSpacing = (-0.2).sp,
            lineHeight = 18.sp,
            modifier = Modifier.padding(top = 4.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.profile),
            contentDescription = "Content post image",
            modifier = Modifier
                .padding(top = 24.dp)
                .clip(RoundedCornerShape(24.dp))
        )
    }
}

@Composable
fun PostItemFooter() {
    Row(modifier = Modifier.fillMaxWidth()) {
        PostItemIconAction(
            iconData = PostIconAction.CHAT,
            modifier = Modifier.weight(1f)
        )
        PostItemIconAction(
            iconData = PostIconAction.RT,
            modifier = Modifier.weight(1f)
        )
        PostItemIconAction(
            iconData = PostIconAction.LIKE,
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
fun PostItemIconAction(
    iconData: PostIconAction,
    modifier: Modifier
) {
    var isFocused by rememberSaveable { mutableStateOf(false) }
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        val (iconRes, iconColor) = if (isFocused) {
            iconData.focusIconRes to iconData.focusIconColor
        } else {
            iconData.unFocusIconRes to iconData.unFocusIconColor
        }
        IconButton(onClick = { isFocused = !isFocused }) {
            Icon(
                painter = painterResource(id = iconRes),
                contentDescription = "Social icon",
                tint = iconColor
            )
        }
        Text(text = if (isFocused) "2" else "1", color = Color(0xFF89939B))
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    Compose_twitter_post_exerciseTheme {
        PostScreen()
    }
}