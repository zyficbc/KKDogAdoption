/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ProvideTextStyle
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun DetailPage(navController: NavController?, dog: Dog) {
    Column(
        Modifier
            .background(MaterialTheme.colors.surface)
    ) {
        Image(
            painterResource(dog.picture),
            "Dog picture: ${dog.name}",
            Modifier.aspectRatio(1f),
            contentScale = ContentScale.Crop
        )
        Column(Modifier.padding(16.dp, 8.dp)) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(dog.name, style = MaterialTheme.typography.h4)
                Image(
                    painterResource(if (dog.gender == "Male") R.drawable.male else R.drawable.female),
                    "gender",
                    modifier = Modifier
                        .size(30.dp)
//                        .padding(0.dp, 16.dp, 16.dp, 0.dp),
                )
            }
            Divider(color = Color.Gray)
            Spacer(modifier = Modifier.height(3.dp))
            ProvideTextStyle(MaterialTheme.typography.body1) {
                Text("品种: ${dog.breed}")
                Text("所在地: ${dog.location}")
                Text("年龄: ${dog.age}")
                Text("性别: ${dog.gender}")
                Text("体型: ${dog.size}")
                Text("描述: ${dog.description}")
            }
        }
    }
}

@Preview
@Composable
fun DogDetailsPreview() {
    DetailPage(
        null, DogsData().dogs[1]
    )
}
