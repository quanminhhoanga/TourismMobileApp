package me.ppvan.metour.ui.page

import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import me.ppvan.metour.R
import me.ppvan.metour.ui.component.rememberImeState

@Composable
fun ProfilePage() {


    val formGroup = Modifier
        .fillMaxWidth()
//        .height(64.dp)
        .padding(8.dp)
    val imeState = rememberImeState()
    val scrollState = rememberScrollState()

    LaunchedEffect(key1 = imeState.value) {
        if (imeState.value) {
            scrollState.animateScrollTo(scrollState.maxValue, tween(300))
        }
    }



    Column(
        modifier = Modifier
            .fillMaxSize()
            .imePadding(),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Spacer(modifier = Modifier.height(20.dp))
        Row {
            Spacer(modifier = Modifier.weight(1f))
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
//                    modifier = Modifier.size(64.dp),
                    imageVector = Icons.Default.Edit,
                    contentDescription = null
                )
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth(0.6f)
                .aspectRatio(1f)
                .clip(CircleShape)
        ) {
            Image(
                modifier = Modifier.matchParentSize(),
                painter = painterResource(id = R.drawable.bocchi),
                contentDescription = null
            )
        }

        Column(
            modifier = Modifier
                .verticalScroll(scrollState)
                .weight(1f, fill = false)
                .padding(8.dp),
//                .verticalScroll(scrollState)
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            OutlinedTextField(
                modifier = formGroup,
                value = "",
                onValueChange = {},
                label = { Text(text = "Họ và tên") },
                colors = OutlinedTextFieldDefaults.colors()
            )
            OutlinedTextField(
                modifier = formGroup,
                value = "",
                onValueChange = {},
                label = { Text(text = "Email") },
            )
            OutlinedTextField(
                modifier = formGroup,
                value = "",
                onValueChange = {},
                label = { Text(text = "Số điện thoại") },
            )
            OutlinedTextField(
                modifier = formGroup,
                value = "",
                onValueChange = {},
                label = { Text(text = "Số điện thoại") },
            )
        }
    }
}