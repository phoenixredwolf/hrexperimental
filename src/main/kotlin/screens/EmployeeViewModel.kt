package screens

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import data.model.Department
import data.model.Employee
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
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        null,
        "",
        null,
        0.00
    ))

    fun submitEmployee(emp: Employee){

    }
}