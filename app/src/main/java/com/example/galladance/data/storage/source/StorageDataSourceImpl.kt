package com.example.galladance.data.storage.source

import android.content.Context
import com.example.galladance.App.Companion.instance
import com.example.galladance.data.models.SettingsStateData
import com.example.galladance.data.storage.models.SettingsStateStorage
import com.example.galladance.domain.Mapper
import com.example.galladance.domain.helpers.DispatchersProvider
import com.google.gson.Gson
import kotlinx.coroutines.withContext

class StorageDataSourceImpl(
    private val dispatchersProvider: DispatchersProvider,
    private val mapToStorage: Mapper<SettingsStateData, SettingsStateStorage>,
    private val mapFromStorage: Mapper<SettingsStateStorage, SettingsStateData>,
) : StorageDataSource {
    private val sharedPref = instance.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
    override suspend fun getSettingsState() =
        withContext(dispatchersProvider.io()) {
            val savedSettingsState = sharedPref.getString(SAVED_SETTINGS_STATE_NAME, null)
            mapFromStorage.map(
                Gson().fromJson(
                    savedSettingsState,
                    SettingsStateStorage::class.java
                ) ?: SettingsStateStorage()
            )
        }

    override suspend fun saveSettingsState(state: SettingsStateData) =
        withContext(dispatchersProvider.io()) {
            val savedSettingsState: String = Gson().toJson(mapToStorage.map(state))
            sharedPref.edit().putString(SAVED_SETTINGS_STATE_NAME, savedSettingsState).apply()
        }


    companion object {
        private const val SHARED_PREF_NAME = "USER_SHARED_PREF"
        private const val SAVED_SETTINGS_STATE_NAME = "saved_settings_state_name"
    }

}