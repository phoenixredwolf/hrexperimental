package data.model

import kotlinx.serialization.Serializable

@Serializable
enum class Department {
    HR,
    TRAINING,
    EXECUTIVE,
    IT,
    SUPPORT,
    MARKETING,
    RECRUTIMENT,
    CONSULTANTS
}