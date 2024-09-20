package com.easy.firedata.model

import kotlinx.serialization.Serializable

@Serializable
data class SupaRequestModel(
    val userId: String,
    val adKey: String,
    val adUnit: String,
    val historyType: String,
    val ip: String,
    val time: Long,
    val adType: String,
    val dataMap: List<ExtraAdData> = emptyList(),
    val error: Int = -1010,
    val message: String = "",
    val projectName: String
)

@Serializable
data class ExtraAdData(
    val key: String,
    val value: String
)