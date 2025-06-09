package com.meeplematch.data.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore

val Context.settingsStore: DataStore<Preferences> by preferencesDataStore(name = "settings")
val Context.userStore: DataStore<Preferences> by preferencesDataStore(name = "user")