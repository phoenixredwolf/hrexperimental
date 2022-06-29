import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import data.remote.MySQLDatabase.executeMySQLQuery
import data.remote.MySQLDatabase.getConnection
import viewmodel.EmployeeViewModel
import screens.newEmployee


fun main() = application {
    var icon = painterResource("images/favicon.png")
    val viewModel = EmployeeViewModel()
    Window(
        onCloseRequest = ::exitApplication,
        title = "Rave Business HR",
        state = rememberWindowState(width = 1600.dp, height = 1200.dp),
        icon = icon,
    ){
        Image(
            painter = painterResource("images/desk.jpg"),
            contentDescription = "",
            modifier = Modifier.fillMaxSize()
        )
            getConnection()
            executeMySQLQuery()

            //newEmployee(viewModel = EmployeeViewModel())









    }

}