package one.fable.fetchexercise

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import fetchrewardscodingexercise.composeapp.generated.resources.Res
import fetchrewardscodingexercise.composeapp.generated.resources.compose_multiplatform
import kotlinx.coroutines.launch
import one.fable.fetchexercise.navigation.SetupNavGraph
import one.fable.fetchexercise.repository.HiringRepository
import one.fable.fetchexercise.repository.network.FetchHiringApi
import org.koin.compose.KoinContext
import org.koin.core.component.get

@Composable
@Preview
fun App() {
//    val scope = rememberCoroutineScope()
//
//    //val repository = HiringRepository by get()
//    scope.launch {
//        FetchHiringApi().getAllHiringItems().forEach {
//            println(it)
//        }
//    }

    MaterialTheme {
        KoinContext {
            val navController = rememberNavController()
            SetupNavGraph(navHostController = navController)
        }
    }
}