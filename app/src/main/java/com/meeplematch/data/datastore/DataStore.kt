package com.meeplematch.data.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

fun readFromDataStore(store: DataStore<Preferences>, key: Preferences.Key<String>): Flow<String?> {
    return store.data.map { prefs ->
        prefs[key]
    }
}

suspend fun writeIntoDataStore(store: DataStore<Preferences>, key: Preferences.Key<String>, value: String) {
    store.edit { prefs ->
        prefs[key] = value
    }
}