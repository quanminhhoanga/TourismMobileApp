package me.ppvan.metour.ui.view

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import me.ppvan.metour.MeTourApplication
import me.ppvan.metour.data.Schedule
import me.ppvan.metour.data.Tourism
import me.ppvan.metour.ui.component.BottomRoundedShape
import me.ppvan.metour.ui.component.CircleButton
import me.ppvan.metour.ui.component.ScheduleCard
import me.ppvan.metour.viewmodel.TourDetailsViewModel
import me.ppvan.metour.viewmodel.viewModelFactory

@Composable
fun TourDetailsView(id: Int, onBackPress: () -> Unit) {

    val viewModel = viewModel<TourDetailsViewModel>(factory = viewModelFactory {
        TourDetailsViewModel(MeTourApplication.appModule.tourRepo)
    })
    var tourism by remember {
        mutableStateOf(Tourism.default())
    }
    val isFavorite by viewModel.favorite

    LaunchedEffect(key1 = id) {
        tourism = viewModel.getDetailById(id)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        DetailHeader(
            modifier = Modifier,
            navigateBack = onBackPress,
            tourism = tourism,
            isFavorite = isFavorite,
            favoriteClick = {
                viewModel.updateFavoriteTourism(id)
            }
        )
        DetailContent(modifier = Modifier, tourism = tourism)
        DetailBookingNow(
            modifier = Modifier,
            listSchedule = tourism.schedule,
            listSelectedSchedule = viewModel.listSelectedSchedule,
            onClickCard = {
                viewModel.updateScheduleTourism(it)
            }
        )
        DetailPriceAndContinue(modifier = Modifier, onClickButton = {
//            viewModel.dialogState = true
        })
    }
}


@Composable
fun DetailContent(modifier: Modifier, tourism: Tourism) {
    Column(
        modifier = modifier
            .padding(horizontal = 24.dp, vertical = 20.dp),
    ) {
        Text(
            text = tourism.name,
//            color = BlackColor500,
            fontWeight = FontWeight.SemiBold,
            fontSize = 26.sp,
//            fontFamily = poppinsFamily,
            modifier = modifier
                .padding(bottom = 4.dp)
                .align(Alignment.CenterHorizontally)
        )
        Text(
            text = tourism.location,
//            color = BlackColor500,
//            fontFamily = poppinsFamily,
            fontWeight = FontWeight.Light,
            fontSize = 16.sp,
            modifier = modifier
                .padding(bottom = 26.dp)
                .align(Alignment.CenterHorizontally)
        )
        Text(
            text = "About",
//            color = BlackColor500,
//            fontFamily = poppinsFamily,
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
            modifier = modifier.padding(bottom = 6.dp)
        )
        Text(
            text = tourism.description,
//            color = BlackColorBody,
//            fontFamily = poppinsFamily,
            fontWeight = FontWeight.Light,
            maxLines = 4,
            lineHeight = 26.sp,
            overflow = TextOverflow.Ellipsis,
            fontSize = 16.sp,
            modifier = modifier.padding(bottom = 6.dp)
        )
    }
}

@Composable
fun DetailBookingNow(
    modifier: Modifier,
    listSchedule: List<Schedule>,
    listSelectedSchedule: List<Int>,
    onClickCard: (Schedule) -> Unit = {}
) {
    Text(
        text = "Booking Now",
//        color = BlackColor500, fontFamily = poppinsFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        modifier = modifier.padding(bottom = 12.dp, start = 24.dp)
    )
    LazyRow(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 15.dp),
        contentPadding = PaddingValues(horizontal = 20.dp),
        horizontalArrangement = Arrangement.spacedBy(24.dp),
    ) {

        items(listSchedule) { schedule ->
            Column(
                modifier = modifier
                    .clip(RoundedCornerShape(22.dp))
//                    .background(WhiteColor)
                    .width(80.dp)
                    .height(100.dp)
            ) {
                ScheduleCard(
                    modifier = modifier,
                    schedule = schedule,
                    isSelected = listSelectedSchedule.contains(schedule.id),
                    onCardClick = onClickCard
                )
            }
        }
    }
}

@Composable
fun DetailPriceAndContinue(modifier: Modifier, onClickButton: () -> Unit) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 30.dp),
    ) {
        Column(
            modifier = modifier
                .align(Alignment.CenterVertically)
                .padding(end = 30.dp)
        ) {
            Text(
                text = "$22,800",
                fontWeight = FontWeight.Medium,
                fontSize = 22.sp,
            )
            Text(
                text = "/người",
                fontWeight = FontWeight.Light,
                fontSize = 12.sp,
            )
        }
        Button(
            onClick = onClickButton,
            shape = RoundedCornerShape(22.dp),
            modifier = modifier
                .fillMaxWidth()
                .height(60.dp)
                .align(Alignment.CenterVertically)
        ) {
            Text(
                text = "Đăng ký",
//                color = WhiteColor, fontFamily = poppinsFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp,
            )
        }
    }
}

@Composable
fun DetailHeader(
    modifier: Modifier,
    tourism: Tourism,
    isFavorite: Boolean,
    navigateBack: () -> Unit,
    favoriteClick: () -> Unit,
) {
    Box {
        Image(
            painter = painterResource(id = tourism.picture),
            contentDescription = tourism.name,
            contentScale = ContentScale.Crop,
            modifier = modifier
                .fillMaxWidth()
                .height(305.dp)
                .clip(shape = BottomRoundedShape())
        )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween, modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 32.dp)
        ) {
            CircleButton(
                modifier = modifier,
                onClick = navigateBack,
                icon = Icons.AutoMirrored.Filled.ArrowBack
            )
            CircleButton(
                onClick = favoriteClick,
                icon = if (isFavorite) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
            )
        }
    }
}

@Preview
@Composable
fun TourDetailPreview() {
    TourDetailsView(id = 0) {
        Log.d("INFO", "Back")
    }
}