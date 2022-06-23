package data.model

import kotlinx.serialization.Serializable

@Serializable
enum class Status {
    NOT_STARTED,
    IN_PROGRESS,
    IN_PR,
    IN_MR,
    IN_QA,
    IN_TESTING,
    COMPLETE,
    WITHDRAWN,
    BLOCKED,
    ON_HOLD
}