package one.fable.fetchexercise.repository

import one.fable.fetchexercise.repository.database.FetchHiringDatabase
import one.fable.fetchexercise.repository.network.FetchHiringApi
import org.koin.core.component.KoinComponent

//interface HiringRepository {
//
//}

class HiringRepository(
    private val api: FetchHiringApi,
    private val database: FetchHiringDatabase,
) {

}