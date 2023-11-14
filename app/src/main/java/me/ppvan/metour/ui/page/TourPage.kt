package me.ppvan.metour.ui.page

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.KeyboardArrowRight
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Place
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import me.ppvan.metour.R
import me.ppvan.metour.data.Tour
import java.time.format.DateTimeFormatter

@Composable
fun TourPage() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        TourList(tours = List(10) { Tour.DEFAULT })
    }
}

@Composable
fun TourList(tours: List<Tour>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)

    ) {
        items(tours) { tour ->
            TourCard(tour)
        }
    }
}

@Composable
fun TourCard(tour: Tour) {

    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF312F2F),
        ),
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(2.5f)
    ) {
        Row(modifier = Modifier.padding(12.dp)) {
            AsyncImage(
                modifier = Modifier
                    .fillMaxHeight()
                    .aspectRatio(3 / 4f)
                    .clip(RoundedCornerShape(12.dp)),
                model = tour.imageURL,
                placeholder = painterResource(id = R.drawable.hoalo),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(12.dp))

            Surface(
                contentColor = MaterialTheme.colorScheme.onBackground,
                color = Color.Transparent
            ) {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text(text = tour.title, style = MaterialTheme.typography.titleLarge)


                    Column {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                modifier = Modifier.size(16.dp),
                                imageVector = Icons.Outlined.Place,
                                contentDescription = "place",
                                tint = Color(0xff898282)
                            )
                            Text(
                                text = tour.place,
                                style = MaterialTheme.typography.bodyMedium,
                                color = Color(0xff898282)
                            )
                        }

                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                modifier = Modifier.size(16.dp),
                                imageVector = Icons.Outlined.DateRange,
                                contentDescription = "DateRange",
                                tint = Color(0xff898282)
                            )
                            Text(
                                text = tour.beginTime.format(DateTimeFormatter.ISO_DATE_TIME),
                                style = MaterialTheme.typography.bodyMedium,
                                color = Color(0xff898282)
                            )
                        }
                    }
                }
            }

            IconButton(
                modifier = Modifier.fillMaxHeight(),
                onClick = { /*TODO*/ }
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Outlined.KeyboardArrowRight,
                    contentDescription = "KeyboardArrowRight"
                )
            }
        }
    }
}
