package com.meeplematch.domain.model.composable

data class SettingsSection(
    val sectionTitle: String,
    val sectionOptions: List<SettingsOption>
)