package one.fable.fetchexercise.navigation.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun HomeScreen() { //navigateToDetails: () -> Unit //if you wanted navigation
    val viewModel = koinViewModel<HomeViewModel>()

    Box(
        modifier = Modifier.fillMaxSize()
    )
}