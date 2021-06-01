package com.kyle.android_steamship

import androidx.lifecycle.*
import androidx.savedstate.SavedStateRegistryOwner

class MainViewModel constructor(
    private val savedStateHandle: SavedStateHandle,
    steamRepository: SteamRepository,
) : ViewModel() {

    val players: LiveData<List<Player>> = savedStateHandle.getLiveData<String>("steamId").switchMap { steamId ->
        liveData {
            val data = steamRepository.getFriendsOfId(steamId)
            emit(data)
        }
    }

    fun initSteamId(steamId: String) {
        if (savedStateHandle.get<String>("steamId") == null) {
            savedStateHandle["steamId"] = steamId
        }
    }

    class MainViewModelFactory(
        owner: SavedStateRegistryOwner,
        private val steamRepository: SteamRepository) : AbstractSavedStateViewModelFactory(owner, null) {
        override fun <T : ViewModel?> create(key: String, modelClass: Class<T>, state: SavedStateHandle) =
            MainViewModel(state, steamRepository) as T
    }
}
