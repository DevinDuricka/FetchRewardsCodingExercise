package one.fable.fetchexercise

import one.fable.fetchexercise.navigation.home.HomeViewModel
import one.fable.fetchexercise.repository.HiringRepository
import one.fable.fetchexercise.repository.network.FetchHiringApi
import org.koin.core.context.startKoin
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

//fun initKoin(config: KoinAppDeclaration? = null) =
//    startKoin {
//        config?.invoke(this)
//        modules(
//            appModule
//        )
//    }

val appModule = module {
    single<FetchHiringApi> { FetchHiringApi() }
    single<HiringRepository> {HiringRepository(get(), get())}
    viewModel { HomeViewModel(get()) }
}
