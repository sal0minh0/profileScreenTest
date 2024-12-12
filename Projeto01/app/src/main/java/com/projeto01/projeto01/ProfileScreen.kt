package com.projeto01.projeto01

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.material3.MaterialTheme

@Composable
fun ProfileScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            TopBar()
            UserInfo()
            DailyAverageCard()
            TaskClassificationCard()
            Achievements()
        }
    }
}

@Composable
fun TopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = R.drawable.arrow_left),
            contentDescription = stringResource(R.string.back_arrow_description),
            modifier = Modifier.size(24.dp)
        )
        Icon(
            painter = painterResource(id = R.drawable.settings),
            contentDescription = stringResource(R.string.settings_icon_description),
            modifier = Modifier.size(24.dp)
        )
    }
}

@Composable
fun UserInfo() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.generic_avatar),
            contentDescription = stringResource(R.string.user_avatar_description),
            modifier = Modifier
                .size(75.dp)
                .clip(CircleShape)
        )

        Text(
            text = stringResource(R.string.user_info_placeholder),
            modifier = Modifier.padding(top = 4.dp),
            style = MaterialTheme.typography.displayMedium
        )
    }
}


@Composable
fun DailyAverageCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = stringResource(R.string.daily_average_completion),
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}

@Composable
fun TaskClassificationCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = stringResource(R.string.task_classification),
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}

@Composable
fun Achievements() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = stringResource(R.string.achievements),
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            AchievementIcon(R.drawable.success_1, R.string.trophy_achievement_description)
            AchievementIcon(R.drawable.trophy_1, R.string.star_achievement_description)
            AchievementIcon(R.drawable.diamond, R.string.diamond_achievement_description)
            AchievementIcon(R.drawable.reward, R.string.gold_achievement_description)
        }
    }
}

@Composable
fun AchievementIcon(drawableRes: Int, contentDescriptionRes: Int) {
    Image(
        painter = painterResource(id = drawableRes),
        contentDescription = stringResource(contentDescriptionRes),
        modifier = Modifier.size(48.dp)
    )
}

