package one.fable.fetchexercise.repository

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import one.fable.fetchexercise.repository.database.FetchHiringDatabase
import one.fable.fetchexercise.repository.network.FetchHiringApi
import one.fable.fetchexercise.repository.network.HiringItem

class HiringRepository(
    private val api: FetchHiringApi,
    private val database: FetchHiringDatabase,
) {
    // Expose a continuous flow of data from the database
    fun getItems() : Flow<List<HiringItem>> = database.getDao().getAllAsFlow()

    // Sync with the API. We're going to delete old items from the DB (ones no longer on the API),
    // then insert new items to the DB.
    suspend fun syncItems(dispatcher: CoroutineDispatcher = Dispatchers.IO) {
        try {
            coroutineScope {
                // Get fresh data from API
                val networkItems = api.getAllHiringItems()

                //Get all local items
                val localItems = database.getDao().getAll()

                //Find the items that are no longer on the API
                val itemsToDelete = localItems - networkItems.toSet()

                //Get the IDs of the items to delete
                val idsToDelete = itemsToDelete.map { it.id }

                // Update the items in the DB 1. Delete the old ones 2. Insert the new ones
                withContext(dispatcher) { //Ensure its IO so the app doesn't crash accessing DB

                    // Delete stale items
                    if (idsToDelete.isNotEmpty()) {
                        database.getDao().deleteByIds(idsToDelete.toList())
                    }

                    // We can use insertAll since it won't add existing ones to the DB see @Insert(onConflict = OnConflictStrategy.REPLACE)
                    database.getDao().insertAll(networkItems)
                }
            }
        } catch (e: Exception) {
            throw e
        }
    }
}