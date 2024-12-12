package com.projeto01.projeto01

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val composeView = ComposeView(this).apply {
            setContent {
                YourAppTheme {
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        CombinedScreen()
                    }
                }
            }
        }

        setContentView(composeView)

        ViewCompat.setOnApplyWindowInsetsListener(composeView) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}

@Composable
fun CombinedScreen() {
    Scaffold(
        bottomBar = { BottomNavigation() }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            ProfileScreen()
        }
    }
}


@Composable
fun BottomNavigation() {
    val iconSize = 48.dp // Set a fixed icon size or adjust as per your design

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        BottomNavIcon(R.drawable.vector, "Home", iconSize)
        BottomNavIcon(R.drawable.vector__1_, "Calendar", iconSize)
        BottomNavIcon(R.drawable.vector__2_, "New Habit", iconSize)
        BottomNavIcon(R.drawable.vector__3_, "Search Habit", iconSize)
        BottomNavIcon(R.drawable.vector__4_, "Notifications", iconSize)
    }
}


@Composable
fun BottomNavIcon(iconResId: Int, contentDescription: String, size: Dp) {
    IconButton(
        onClick = { /* Action when icon is clicked */ },
        modifier = Modifier.size(size)
    ) {
        Icon(
            painter = painterResource(id = iconResId),
            contentDescription = contentDescription
        )
    }
}

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF6200EE),
    secondary = Color(0xFF03DAC6),
)

private val PoppinsFontFamily = FontFamily(
    Font(R.font.poppins_medium) // Ensure the font file is in res/font/
)

@Composable
fun YourAppTheme(content: @Composable () -> Unit) {
    val typography = Typography(
        displayLarge = TextStyle(
            fontFamily = PoppinsFontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            color = Color.Black
        ),
        displayMedium = TextStyle(
            fontFamily = PoppinsFontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            color = Color.Black
        ),
        displaySmall = TextStyle(
            fontFamily = PoppinsFontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = Color.Black
        ),
        bodyLarge = TextStyle(
            fontFamily = PoppinsFontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            color = Color.Black
        )
    )

    MaterialTheme(
        colorScheme = LightColorScheme,
        typography = typography,
        content = content,
    )
}
