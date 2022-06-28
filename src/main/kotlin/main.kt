import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import screens.EmployeeViewModel
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
        val firstName by viewModel.firstName
        val dob by viewModel.dateofbirth
        Image(
            painter = painterResource("images/desk.jpg"),
            contentDescription = "",
            modifier = Modifier.fillMaxSize()
        )


            newEmployee(viewModel = EmployeeViewModel())









    }

}