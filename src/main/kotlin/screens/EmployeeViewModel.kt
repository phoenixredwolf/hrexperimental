package screens

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import data.model.Department
import data.model.Employee
import data.model.States
import util.ViewModel

class EmployeeViewModel : ViewModel() {

    val firstName = mutableStateOf("")
    val dateofbirth = mutableStateOf("")

    var employee: MutableState<Employee> = mutableStateOf(Employee(
        firstname = firstName.toString(),
        null,
        "",
        null,
        "",
        "",
        "",
        "",
        States.AL,
        "",
        "",
        "",
        listOf(""),
        listOf(Department.CONSULTANTS),
        null,
        listOf(0.00)
    ))

    fun submitEmployee(emp: Employee){

    }
}