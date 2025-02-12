package one.fable.fetchexercise.navigation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import one.fable.fetchexercise.repository.HiringRepository
import one.fable.fetchexercise.repository.network.HiringItem

class HomeViewModel(private val hiringRepository: HiringRepository) : ViewModel() {
    init {
        refresh()
    }

    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()

    //
    private fun getItemNameNumber(name : String) : Int {
        //The format is "Item ###" so we can get the last section as an int. The ID seems to be the same, so that might be used instead?
        return name.split(" ").last().toIntOrNull() ?: 0
    }

    val hiringItems = hiringRepository.getItems()
        .map { items ->
            items.filter { !it.name.isNullOrBlank() }
                .sortedWith(
                    compareBy<HiringItem> { it.listId } //Sort the results first by "listId" then by "name" when displaying.
                        //This is a little dangerous though, because the format might change for the name.
                        //The ID *seems* to match the name which would be a better sort, but it seems like a trick question.
                        .thenBy { getItemNameNumber(it.name ?: "") }
                )
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    fun refresh() {
        viewModelScope.launch(Dispatchers.IO) {
            _isLoading.value = true
            hiringRepository.syncItems()
            _isLoading.value = false
        }
    }

}