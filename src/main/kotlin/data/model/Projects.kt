package data.model

import com.squareup.moshi.Json
import kotlinx.serialization.Serializable

@Serializable
data class Projects(
    @field:Json(name="project_name") val name: String,
    @field:Json(name="project_desc") val description: String?,
    @field:Json(name="tech_stack") val techStack: String?,
    val consultants: List<Employee>?
)
