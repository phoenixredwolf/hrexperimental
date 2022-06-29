package data.model

import com.squareup.moshi.Json
import kotlinx.serialization.Serializable

@Serializable
data class Employee(
    var firstname: String,
    var middlename: String? = null,
    var lastname: String,
    var suffix: String? = null,
    var dob: String,
    var ssn: String,
    var address: String,
    var city: String,
    var state: String,
    var zip: String,
    var phonenumber: String,
    @field:Json(name = "emergency_name") var emergencyName: String,
    @field:Json(name = "emergency_relation") var emergencyRel: String,
    @field:Json(name = "emergency_phone") var emergencyPhone: String,
    var startdate: String,
    var position: String,
    @field:Json(name = "former_positions") var formerPostions: List<String>? = null,
    var department: String,
    var enddate: String? = null,
    var rate: Double,
    @field:Json(name = "previous_rates") var prevRate: List<String>? = null,
    @field:Json(name = "rate_change_dates") var rateChangeDate: List<String>? = null,
    var currproject: List<Projects>? = null,
    var prevproject: List<Projects>? = null,
    var projectstartdate: List<String>? = null,
    var projectenddate: List<String>? = null,
    var ptodates: List<String>?= null,
    var reviews: List<String>? = null,
    @field:Json(name = "discip_action") var discipAction: List<String>? = null,
    var sme: Employee? = null,
    var tickets: List<Tickets>? = null,
    var comments: List<Comments>? = null,
    var id: Int? = null
)
