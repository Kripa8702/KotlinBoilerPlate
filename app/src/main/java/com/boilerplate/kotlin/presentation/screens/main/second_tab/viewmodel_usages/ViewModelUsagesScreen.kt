package com.boilerplate.kotlin.presentation.screens.main.second_tab.viewmodel_usages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.boilerplate.kotlin.models.response.UsersData
import com.boilerplate.kotlin.presentation.composables.BaseScreen
import com.boilerplate.kotlin.presentation.composables.CommonImage
import com.boilerplate.kotlin.presentation.composables.CommonText
import com.boilerplate.kotlin.utils.responsive

@Composable
fun ViewModelUsagesScreen(
    navController: NavController,
    viewModel: ViewModelUsagesViewModel
) {
    BaseScreen {
        Column(
            modifier = Modifier.fillMaxSize(),
        ) {
            CommonText(
                text = "ViewModel Usages",
                style = MaterialTheme.typography.titleMedium,
                contentAlignment = Alignment.CenterStart,
            )

        }
    }
}

@Composable
fun UsersBody(
    users: List<UsersData>
){
    val scrollState = rememberLazyGridState()

    LazyVerticalGrid(
        modifier = Modifier
            .padding(top = 20.dp.responsive()),
        state = scrollState,
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(bottom = 22.dp.responsive()),
        verticalArrangement = Arrangement.spacedBy(12.dp.responsive()),
        horizontalArrangement = Arrangement.spacedBy(22.dp.responsive()),
        userScrollEnabled = false
    ) {

        items(users){
            UserItem(user = it)
        }
    }
}

@Composable
fun UserItem(
    user: UsersData,
) {
    Column(
        modifier = Modifier
            .fillMaxHeight()
    ) {
        CommonImage(
            imageUrl = user.image,
            modifier = Modifier.height(100.dp),
            contentDescription = "User Avatar",
        )
        CommonText(
            text = user.firstName + " " + user.lastName,
            style = MaterialTheme.typography.titleMedium,
            contentAlignment = Alignment.CenterStart,
        )
        CommonText(
            text = user.email,
            style = MaterialTheme.typography.labelMedium,
            contentAlignment = Alignment.CenterStart,
        )
    }
}
