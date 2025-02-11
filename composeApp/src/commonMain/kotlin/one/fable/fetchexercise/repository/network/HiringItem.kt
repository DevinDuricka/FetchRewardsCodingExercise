package one.fable.fetchexercise.repository.network

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Entity
@Serializable
data class HiringItem(
    @PrimaryKey(autoGenerate = false) val id: Int,
    val listId: Int, //TODO Would need to verify with the schema to see if this is nullable
    val name: String?
)
