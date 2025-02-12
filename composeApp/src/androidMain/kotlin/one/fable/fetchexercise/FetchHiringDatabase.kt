package one.fable.fetchexercise

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import one.fable.fetchexercise.repository.database.FetchHiringDatabase

fun getFetchHiringDatabaseBuilder(context: Context): RoomDatabase.Builder<FetchHiringDatabase> {
    val appContext = context.applicationContext
    val dbFile = appContext.getDatabasePath("fetch_hiring.db")
    return Room.databaseBuilder<FetchHiringDatabase>(
        context = appContext,
        name = dbFile.absolutePath
    )
}