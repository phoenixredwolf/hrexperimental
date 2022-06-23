package data.model

import kotlinx.serialization.Serializable

@Serializable
data class Comments(
    val date: String,
    val comment: String
    )
