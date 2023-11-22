package me.ppvan.metour.ui.page

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.ppvan.metour.R
import me.ppvan.metour.data.FakeTourismDataSource
import me.ppvan.metour.data.Tourism
import me.ppvan.metour.ui.component.PopularPlaceCard
import me.ppvan.metour.ui.component.RecommendationCard
import me.ppvan.metour.ui.theme.MeTourTheme
import me.ppvan.metour.ui.utils.noRippleClickable

@Composable
fun HomePage() {
    val list = FakeTourismDataSource.dummyTourism

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface)
            .verticalScroll(rememberScrollState())
    ) {
        HomeHeader(navigateToAboutMe = {})
        HomeContent(
            tourismList = list,
            modifier = Modifier,
            navigateToDetail = {},
        )
    }
}

@Composable
fun HomeContent(tourismList: List<Tourism>, modifier: Modifier, navigateToDetail: (Int) -> Unit) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(24.dp),
        contentPadding = PaddingValues(horizontal = 24.dp),
        content = {
            items(tourismList.size) { index ->
                PopularPlaceCard(
                    tourism = tourismList[index],
                    modifier = modifier,
                    onClickCard = { navigateToDetail(tourismList[index].id) }
                )
            }
        })

    Text(
        text = "Recommendation",
        fontSize = 18.sp,
//        color = BlackColor500, fontFamily = poppinsFamily,
        fontWeight = FontWeight.SemiBold,
        modifier = modifier.padding(start = 24.dp, top = 30.dp, end = 24.dp, bottom = 16.dp)
    )
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(start = 24.dp, end = 24.dp, bottom = 30.dp),
        modifier = modifier
            .height(500.dp)
            .nestedScroll(
                object : NestedScrollConnection {
                    // Implement callbacks here
                }),
        content = {
            items(tourismList.size) { index ->
                RecommendationCard(
                    modifier = modifier,
                    tourism = tourismList[index],
                    onClickCard = { navigateToDetail(tourismList[index].id) }
                )
            }
        })
}

@Composable
fun HomeHeader(modifier: Modifier = Modifier, navigateToAboutMe: () -> Unit) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 30.dp, horizontal = 24.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Column {
            Text(
                text = "Xin chào\nppvan", // TODO load real username
                lineHeight = 36.sp,
                color = MaterialTheme.colorScheme.onBackground,
                fontSize = 24.sp,
                fontWeight = FontWeight.SemiBold,
            )
            Spacer(modifier = modifier.height(6.dp))
            Text(
                text = "Find your next adventure",
                fontSize = 16.sp,
                color = MaterialTheme.colorScheme.onSurface,
                fontWeight = FontWeight.Light,
            )
        }
        Image(
            painter = painterResource(R.drawable.bocchi),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .noRippleClickable {
                    navigateToAboutMe()
                }
                .padding(top = 6.dp)
                .size(60.dp)
                .clip(shape = CircleShape),
            contentDescription = stringResource(id = R.string.app_name),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    MeTourTheme {
    }
}