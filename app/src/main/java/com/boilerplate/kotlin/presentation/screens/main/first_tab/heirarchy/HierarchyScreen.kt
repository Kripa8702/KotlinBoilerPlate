package com.boilerplate.kotlin.presentation.screens.main.first_tab.heirarchy

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.boilerplate.kotlin.R
import com.boilerplate.kotlin.navigation.NavigationItem
import com.boilerplate.kotlin.presentation.composables.BaseScreen
import com.boilerplate.kotlin.presentation.composables.CommonButton
import com.boilerplate.kotlin.presentation.composables.CommonImage
import com.boilerplate.kotlin.presentation.composables.CommonText
import com.boilerplate.kotlin.utils.NavigationHelper
import com.boilerplate.kotlin.utils.responsive

@Composable
fun HierarchyScreen(
    navController: NavController,
) {
    BaseScreen {
        Column(
            modifier = Modifier.fillMaxSize(),
        ) {
            CommonText(
                text = "Project Hierarchy",
                style = MaterialTheme.typography.titleMedium,
                contentAlignment = Alignment.CenterStart,
            )
            Spacer(modifier = Modifier.height(30.dp.responsive()))

            CommonText(
                text = "You can find the project hierarchy below. It shows the structure of the project and how the different NavGraphs are organized.",
                style = MaterialTheme.typography.labelSmall,
                textAlign = TextAlign.Start
            )
            Spacer(modifier = Modifier.height(25.dp.responsive()))
            CommonImage(
                modifier = Modifier.height(380.dp.responsive()),
                imageResourceId = R.drawable.project_hierarchy,
                isNetworkImage = false,
                contentDescription = "Project Hierarchy Image",
            )

            Spacer(modifier = Modifier.height(40.dp.responsive()))

            CommonButton(
                text = "Go to Composable Usages",
                onClick = {
                   NavigationHelper(navController).navigateTo(NavigationItem.ComposableUsages)
                }
            )
            Spacer(modifier = Modifier.height(25.dp.responsive()))
            CommonText(
                text = "Tap on the second tab to see the ViewModel Usages",
                style = MaterialTheme.typography.labelSmall.copy(
                    fontWeight = FontWeight.Normal
                ),
            )
        }
    }
}