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
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun DogList(dogs: List<Dog>, onItemClick: (Int) -> Unit) {
    LazyColumn(
        Modifier.background(MaterialTheme.colors.secondary),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        itemsIndexed(dogs) { index, dog ->
            DogItem(
                dog,
                Modifier
                    .clickable {
                        onItemClick(index)
                    }
                    .fillMaxWidth()
            )
        }
    }
}

@Composable
fun DogItem(dog: Dog, modifier: Modifier = Modifier) {
    Card(modifier) {
        Row(
            modifier = Modifier
                .height(120.dp)
                .padding(8.dp)
        ) {
            Image(
                painterResource(dog.picture),
                "Picture of dog: ${dog.name}",
                Modifier
                    .size(120.dp)
                    .clip(shape = RoundedCornerShape(4.dp)),
                contentScale = ContentScale.Crop
            )
            Column(
                Modifier
                    .padding(8.dp)
                    .padding(8.dp, 0.dp, 0.dp, 0.dp)
                    .weight(1f)
            ) {
                Text(dog.name, style = MaterialTheme.typography.h5)
                Text(dog.breed, style = MaterialTheme.typography.body2)
                Text(dog.location, style = MaterialTheme.typography.body2)
            }
            Image(
                painterResource(if (dog.gender == "Male") R.drawable.male else R.drawable.female),
                "gender",
                modifier = Modifier
                    .size(60.dp)
                    .padding(0.dp, 16.dp, 16.dp, 0.dp),
            )
        }
    }
}

@Preview
@Composable
fun PreviewDogItem() {
    val dog = DogsData().dogs[3]
    DogItem(dog = dog)
}
