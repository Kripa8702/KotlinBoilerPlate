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
import androidx.navigation.NavController
import com.boilerplate.kotlin.R
import com.boilerplate.kotlin.navigation.NavigationItem
import com.boilerplate.kotlin.presentation.composables.BaseScreen
import com.boilerplate.kotlin.presentation.composables.CommonButton
import com.boilerplate.kotlin.presentation.composables.CommonImage
import com.boilerplate.kotlin.presentation.composables.CommonText
import com.boilerplate.kotlin.utils.NavigationHelper
import com.boilerplate.kotlin.utils.h

@Composable
fun HierarchyScreen(
    navController: NavController,
) {
    BaseScreen(
        title = "Project Hierarchy"
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
        ) {
            CommonText(
                text = "You can find the project hierarchy below. It shows the structure of the project and how the different NavGraphs are organized.",
                style = MaterialTheme.typography.labelMedium,
                textAlign = TextAlign.Start
            )
            Spacer(modifier = Modifier.height(25.h()))
            CommonImage(
                modifier = Modifier.height(400.h()),
                imageResourceId = R.drawable.project_hierarchy,
                isNetworkImage = false,
                contentDescription = "Project Hierarchy Image",
            )

            Spacer(modifier = Modifier.height(40.h()))

            CommonButton(
                text = "Go to Composable Usages",
                onClick = {
                   NavigationHelper(navController).navigateTo(NavigationItem.ComposableUsages)
                }
            )
            Spacer(modifier = Modifier.height(25.h()))
            CommonText(
                text = "Tap on the second tab to see the ViewModel Usages",
                style = MaterialTheme.typography.labelSmall.copy(
                    fontWeight = FontWeight.Normal
                ),
                textAlign = TextAlign.Center,
                contentAlignment = Alignment.Center
            )
        }
    }
}