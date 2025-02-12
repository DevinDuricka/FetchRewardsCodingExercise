package one.fable.fetchexercise.repository.database

import androidx.room.ConstructedBy
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Insert
import androidx.room.Query
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import one.fable.fetchexercise.repository.network.HiringItem
import kotlinx.coroutines.flow.Flow

@Database(entities = [HiringItem::class], version = 1)
@ConstructedBy(FetchHiringDatabaseConstructor::class)
abstract class FetchHiringDatabase : RoomDatabase() {
    abstract fun getDao(): HiringItemDao
}

// The Room compiler generates the `actual` implementations.
@Suppress("NO_ACTUAL_FOR_EXPECT")
expect object FetchHiringDatabaseConstructor : RoomDatabaseConstructor<FetchHiringDatabase> {
    override fun initialize(): FetchHiringDatabase
}

@Dao
interface HiringItemDao {
    @Insert
    suspend fun insert(item: HiringItem)

    @Query("SELECT count(*) FROM HiringItem")
    suspend fun count(): Int

    @Query("SELECT * FROM HiringItem")
    fun getAllAsFlow(): Flow<List<HiringItem>>
}