package viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import data.model.Department
import data.model.Employee
import util.ViewModel

class EmployeeViewModel : ViewModel() {

    var employee: MutableState<Employee> = mutableStateOf(Employee(
        "",
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