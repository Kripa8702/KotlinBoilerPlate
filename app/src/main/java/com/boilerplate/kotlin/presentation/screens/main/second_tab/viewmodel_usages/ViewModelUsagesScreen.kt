package com.boilerplate.kotlin.presentation.screens.main.second_tab.viewmodel_usages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.boilerplate.kotlin.models.response.UsersData
import com.boilerplate.kotlin.presentation.composables.BaseScreen
import com.boilerplate.kotlin.presentation.composables.CommonButton
import com.boilerplate.kotlin.presentation.composables.CommonContainer
import com.boilerplate.kotlin.presentation.composables.CommonImage
import com.boilerplate.kotlin.presentation.composables.CommonText
import com.boilerplate.kotlin.presentation.composables.ErrorMessage
import com.boilerplate.kotlin.utils.h
import com.boilerplate.kotlin.utils.w

@Composable
fun ViewModelUsagesScreen(
    navController: NavController,
    viewModel: ViewModelUsagesViewModel
) {
    val uiState = viewModel.uiState.collectAsState()
    val users = viewModel.users.collectAsState()

    BaseScreen(
        title = "ViewModel Usages",
    ) {
        when (uiState.value) {

            is ViewModelUsagesUiState.Success -> {
                UsersBody(users = users.value)
            }

            is ViewModelUsagesUiState.Error -> {
                val message = (uiState.value as ViewModelUsagesUiState.Error).message

                ErrorMessage(
                    message = message,
                    onTryAgain = {
                        viewModel.fetchAllUsers(limit = 10)
                    }
                )
            }

            else -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CommonButton(
                        text = "Fetch Users",
                        enabled = uiState.value !is ViewModelUsagesUiState.Loading,
                        onClick = {
                            viewModel.fetchAllUsers(limit = 10)
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun UsersBody(
    users: List<UsersData>
) {
    val scrollState = rememberLazyGridState()

    LazyVerticalGrid(
        state = scrollState,
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(bottom = 80.h()),
        verticalArrangement = Arrangement.spacedBy(12.h()),
        horizontalArrangement = Arrangement.spacedBy(12.w()),
    ) {

        items(users) {
            UserItem(user = it)
        }
    }
}

@Composable
fun UserItem(
    user: UsersData,
) {
    CommonContainer(
        paddingValues = PaddingValues(0.dp),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(280.h())
        ) {
            CommonImage(
                imageUrl = user.image ?: "",
                contentDescription = "User Avatar",
                roundedCornerShape = RoundedCornerShape(
                    topStart = 12.h(),
                    topEnd = 12.h(),
                ),
                modifier = Modifier
                    .height(150.h())
                    .fillMaxWidth(),
            )
            Spacer(modifier = Modifier.height(16.h()))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.w())
            ) {
                CommonText(
                    text = "${user.firstName ?: ""} ${user.lastName ?: ""}",
                    style = MaterialTheme.typography.titleSmall,
                )
                Spacer(modifier = Modifier.height(5.h()))
                CommonText(
                    text = user.email ?: "",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onSurface.copy(0.6f),
                )
            }
        }
    }
}
