@file:OptIn(ExperimentalMaterial3Api::class)

package com.tantawii.showcase



import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api

import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tantawii.showcase.data.ShowCaseModel
import com.tantawii.showcase.ui.theme.ShowCaseTheme
import com.tantawii.showcase.ui.theme.ThemeColor
import com.tantawii.showcase.R
import com.tantawii.showcase.ui.theme.Purple700
import com.tantawii.showcase.widget.ShowCaseView


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShowCaseTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    MainContent()
                }
            }
        }
    }
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainContent() {
    val context = LocalContext.current
    val target = remember {
        mutableStateMapOf<String, ShowCaseModel>()
    }


    Box {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                TopAppBar(
                    title = {},
                    colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Transparent),
                    modifier = Modifier
                        .padding(10.dp)
                        .shadow(
                            elevation = 5.dp,
                            spotColor = Color.DarkGray,
                            shape = RoundedCornerShape(10.dp)
                        ),
                    navigationIcon = {
                        IconButton(
                            onClick = { /*TODO*/ },
                            modifier = Modifier
                                .onGloballyPositioned { coordinates ->
                                    target["back"] = ShowCaseModel(
                                        4,
                                        coordinates,
                                        "Go Back",
                                        "You Can Go Back by clicking on the back button!"
                                    )
                                }
                        ) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Back"
                            )
                        }
                    },
                    actions = {
                        IconButton(
                            onClick = { /*TODO*/ },
                            modifier = Modifier
                                .onGloballyPositioned { coordinates ->
                                    target["Search"] = ShowCaseModel(
                                        4,
                                        coordinates,
                                        "Search about anything",
                                        "You Can Search about anything by clicking on the search button!"
                                    )
                                }
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Search,
                                contentDescription = "Search"
                            )
                        }
                    }

                )
            },
            floatingActionButton = {
                FloatingActionButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .onGloballyPositioned { coordinates ->
                            target["email"] = ShowCaseModel(
                                4,
                                coordinates,
                                "Check your Email",
                                "You Can Check your Email by clicking on the email button!"
                            )
                        },
                    containerColor = ThemeColor,
                    contentColor = Color.White,
                    elevation = FloatingActionButtonDefaults.elevation(6.dp)

                ) {
                    Icon(
                        imageVector = Icons.Filled.Email,
                        contentDescription = "Email"
                    )
                }
            }
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxHeight(0.4f).padding(top = 90.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .align(Alignment.BottomStart)
                            .fillMaxWidth()
                            .padding( 16.dp)
                            .height(50.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "@Tantawiii",
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            color = Purple700,
                            onTextLayout = {}
                        )
                    }

                    Image(
                        painter = painterResource(id = R.drawable.user_profile),
                        contentDescription = "Profile",
                        modifier = Modifier
                            .align(Alignment.TopCenter)
                            .clip(CircleShape)
                            .onGloballyPositioned { coordinates ->
                                target["profile"] = ShowCaseModel(
                                    0,
                                    coordinates,
                                    "Add Profile + ",
                                    "You can click here to update profile image"
                                )
                            }
                    )

                }
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(start = 16.dp, bottom = 16.dp)
                        .onGloballyPositioned { coordinates ->
                            target["follow"] = ShowCaseModel(
                                2,
                                coordinates,
                                "Follow Me",
                                "You can click here to follow me @Tantawiii"
                            )
                        }
                ) {
                    Text(
                        text = "Follow Me!",
                        onTextLayout = {}
                    )
                }
            }
        }

        ShowCaseView(targets = target) {
            Toast.makeText(context, "App Intro finished!", Toast.LENGTH_SHORT).show()
        }

    }


}
















