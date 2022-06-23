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
    var state: States?,
    var zip: String,
    var phonenumber: String,
    var startdate: String,
    var position: List<String>,
    var department: List<Department>,
    var enddate: String? = null,
    var rate: List<Double>,
    var project: List<Projects>? = null,
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
