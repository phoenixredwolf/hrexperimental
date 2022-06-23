package data.model

import com.squareup.moshi.Json
import kotlinx.serialization.Serializable

@Serializable
data class Tickets(
    @field:Json(name = "ticket_number") val ticketNum: String,
    @field:Json(name = "ticket_name") val ticketName: String,
    @field:Json(name = "ticket_desc") val ticketDesc: String,
    val assigned: String,
    val started: String?,
    val due: String?,
    var status: Status,
    val consultant: Employee,
    var comments: List<Comments>
)
