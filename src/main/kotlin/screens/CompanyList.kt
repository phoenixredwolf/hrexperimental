package screens

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import data.model.Employee
import navcontroller.NavController

@Composable
fun CompanyList(
    employees: List<Employee>,
    navController: NavController
) {
    val sortedEmployees = employees.sortedBy { it.lastname }
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            "Name",
            style = MaterialTheme.typography.h5
        )
        Text(
            "Position",
            style = MaterialTheme.typography.h5
        )
        Text(
            "Start Date",
            style = MaterialTheme.typography.h5
        )
        Text(
            "Rate",
            style = MaterialTheme.typography.h5
        )
    }
    LazyColumn {

        items(sortedEmployees) { employee ->


        }
    }
}