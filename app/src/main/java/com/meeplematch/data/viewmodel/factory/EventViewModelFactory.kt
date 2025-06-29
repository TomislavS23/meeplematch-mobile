package com.meeplematch.data.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.meeplematch.data.viewmodel.EventViewModel

class EventViewModelFactory(private val userId: Int) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return EventViewModel(userId) as T
    }
}