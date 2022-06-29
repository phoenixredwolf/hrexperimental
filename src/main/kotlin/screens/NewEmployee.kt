package screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.input.key.*
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import navcontroller.NavController
import screens.NumberDefaults.DOBMASK
import screens.NumberDefaults.DOB_INPUT_LENGTH
import screens.NumberDefaults.PHONEMASK
import screens.NumberDefaults.PHONE_INPUT_LENGTH
import screens.NumberDefaults.RATEMASK
import screens.NumberDefaults.RATE_INPUT_LENGTH
import screens.NumberDefaults.SSNMASK
import screens.NumberDefaults.SSN_INPUT_LENGTH
import util.MaskVisualTransformation
import viewmodel.EmployeeViewModel

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun newEmployee(
    viewModel: EmployeeViewModel,
    navController: NavController
) {

    // Focus variables
    val focusManager = LocalFocusManager.current
    var focusSetter = true
    val requester = remember { FocusRequester() }
    val (item1, item2, item3, item4, item5, item6, item7, item8, item9, item10, item11, item12, item13, item14, item15, item16/*, item17, item18, item19*/) = remember { FocusRequester.createRefs() }
    val stateList = listOf("AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "ID", "IL", "IN", "IA",
        "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND",
        "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY"
    )
    val deptList = listOf("HR", "TRAINING", "EXECUTIVE", "IT", "SUPPORT", "MARKETING", "RECRUTIMENT", "CONSULTANTS")


    // Form Personal Info variables
    var fname by remember { mutableStateOf("") }
    var mname by remember { mutableStateOf("") }
    var lname by remember { mutableStateOf("") }
    var suffix by remember { mutableStateOf("") }
    var addy by remember { mutableStateOf("") }
    var city by remember { mutableStateOf("") }
    var state by remember { mutableStateOf("") }
    var zip by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var dob by remember { mutableStateOf("") }
    var ssn by remember { mutableStateOf("") }
    var stateExpanded: Boolean by remember { mutableStateOf(false) }
    val iconState = if (stateExpanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown

    // Form Employment Info variables
    var startDate by remember { mutableStateOf("") }
    var rate by remember {mutableStateOf("") }
    var empDept by remember { mutableStateOf("")}
    var position by remember { mutableStateOf("") }
    var deptExpanded by remember { mutableStateOf(false) }
    val iconDept = if (deptExpanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown

    // Emergency contact
    var emergName by remember { mutableStateOf("") }
    var emergPhone by remember { mutableStateOf("") }
    var emergRel by remember { mutableStateOf("") }

    // Viewmodel variable
    var employee = viewModel.employee

    Column(
        modifier = Modifier.fillMaxSize()
            .padding(15.dp)
            .onKeyEvent{
                       if (it.key == Key.Tab && it.type == KeyEventType.KeyDown) {
                           focusManager.moveFocus(FocusDirection.Next)
                           true
                       } else {
                           false
                       }
            }
            .focusRequester(requester)
            .focusable(),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ){
            Image(
                painter = painterResource("images/logo.png"),
                contentDescription = null,
                modifier = Modifier.width(60.dp).padding(end=10.dp)
            )
            Text(
                "New Employee Form",
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.h2,
                modifier = Modifier.padding(start=10.dp)
            )
        }
        Row {

            Text(
                "Personal Information",
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.h5
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth().padding(top = 5.dp, bottom = 5.dp)
        ) {
            TextField(
                modifier = Modifier
                    .weight(.25f)
                    .padding(end = 2.dp)
                    .focusRequester(item1),
                value = fname,
                onValueChange = { fname = it },
                label = { Text("First name: ") },
                singleLine = true
            )
            TextField(
                modifier = Modifier.weight(.25f)
                    .padding(start = 2.dp, end = 2.dp)
                    .focusRequester(item2),
                value = mname,
                onValueChange = { mname = it },
                label = { Text("Middle Name: ") },
                singleLine = true
            )
            TextField(
                modifier = Modifier.weight(.25f)
                    .padding(start = 2.dp, end = 2.dp)
                    .focusRequester(item3),
                value = lname,
                onValueChange = { lname = it },
                label = { Text("Last Name: ") },
                singleLine = true
            )
            TextField(
                modifier = Modifier.weight(.25f)
                    .padding(start = 2.dp)
                    .focusRequester(item4),
                value = suffix,
                onValueChange = { suffix = it },
                label = { Text("Suffix: ") },
                singleLine = true
            )
        }
        Row(
            modifier = Modifier.padding(top = 5.dp, bottom = 5.dp)
        ) {
            TextField(
                modifier = Modifier.weight(1f)
                    .focusRequester(item5),
                value = addy,
                onValueChange = { addy = it },
                label = { Text("Street Address: ") },
                singleLine = true
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth().padding(top = 5.dp)
        ) {
            TextField(
                modifier = Modifier.weight(.5f).padding(end = 2.dp)
                    .focusRequester(item6),
                value = city,
                onValueChange = { city = it },
                label = { Text("City: ") },
                singleLine = true
            )
            Box(
                modifier = Modifier.weight(.1f).padding(start = 2.dp, end = 2.dp)
                    .onKeyEvent{
                        if (it.key == Key.Tab) {
                            focusManager.moveFocus(FocusDirection.Next)
                            true
                        } else {
                            false
                        }
                    }
                    .focusRequester(requester)
                    .focusable(),
            ) {
                TextField(
                    value = if (state.isNullOrEmpty()) "Please Select" else state,
                    onValueChange = { state },
                    label = { Text("State: ") },
                    trailingIcon = {
                        Icon(iconState, "State",
                            Modifier.clickable { stateExpanded = !stateExpanded }
                        )
                    }
                )
                DropdownMenu(
                    modifier = Modifier
                        .focusRequester(item7),
                    expanded = stateExpanded,
                    onDismissRequest = { stateExpanded = false }
                ) {
                    for (states in stateList) {
                        DropdownMenuItem(
                            onClick = {
                                state = states
                                stateExpanded = false
                            }
                        ) {
                            Text(states)
                        }
                    }
                }

            }
            TextField(
                modifier = Modifier.weight(.3f).padding(start = 2.dp)
                    .focusRequester(item8),
                value = zip,
                onValueChange = { zip = it },
                label = { Text("Zip Code: ") },
                singleLine = true
            )

        }
        Row(
            modifier = Modifier.padding(top = 5.dp, bottom = 10.dp)
        ) {
            TextField(
                modifier = Modifier.weight(.5f).padding(end = 2.dp)
                    .focusRequester(item9),
                value = phone,
                onValueChange = { it ->
                    if (it.length <= PHONE_INPUT_LENGTH) {
                        phone = it.filter { it.isDigit() }
                    }
                },
                visualTransformation = MaskVisualTransformation(PHONEMASK),
                label = { Text("Phone Number") },
                singleLine = true
            )
            TextField(
                modifier = Modifier.weight(.5f).padding(end = 2.dp)
                    .focusRequester(item10),
                value = ssn,
                onValueChange = { it ->
                    if (it.length <= SSN_INPUT_LENGTH) {
                        ssn = it.filter { it.isDigit() }
                    }
                },
                visualTransformation = MaskVisualTransformation(SSNMASK),
                label = { Text("Social Security Number") },
                singleLine = true
            )
            TextField(
                value = dob,
                modifier = Modifier.weight(.5f)
                    .padding(end = 2.dp)
                    .focusRequester(item11),
                onValueChange = { it ->
                    if (it.length <= DOB_INPUT_LENGTH) {
                        dob = it.filter { it.isDigit() }
                    }
                },
                visualTransformation = MaskVisualTransformation(DOBMASK),
                label = { Text("Date Of Birth") },
                placeholder = { Text("MM/DD/YY") },
                singleLine = true
            )
        }
        Row(
            modifier = Modifier.padding(top = 10.dp,bottom = 5.dp)
        ){
            Text(
                text = "Employment Information",
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.h5
            )
        }
        Row(
            modifier = Modifier.padding(top = 5.dp, bottom = 5.dp)
        ) {
            TextField(
                value = startDate,
                onValueChange = { it ->
                    if (it.length <= DOB_INPUT_LENGTH) {
                        startDate = it.filter { it.isDigit() }
                    }
                },
                visualTransformation = MaskVisualTransformation(DOBMASK),
                label = { Text("Start Date") },
                placeholder = { Text("MM/DD/YY") },
                modifier = Modifier.padding(end = 2.dp).weight(.1f).focusRequester(item12),
                singleLine = true
            )
            TextField(
                value = rate,
                onValueChange = { it ->
                    if (it.length <= RATE_INPUT_LENGTH) {
                        rate = it.filter { it.isDigit() }
                    }
                },
                visualTransformation = MaskVisualTransformation(RATEMASK),
                label = { Text("Starting Rate") },
                modifier = Modifier.padding(start = 2.dp, end = 2.dp).weight(.1f).focusRequester(item13),
                singleLine = true
            )
            Box(
                modifier = Modifier.weight(.15f).padding(start = 2.dp, end = 2.dp)
                    .onKeyEvent{
                        if (it.key == Key.Tab) {
                            focusManager.moveFocus(FocusDirection.Next)
                            true
                        } else {
                            false
                        }
                    }
                    .focusRequester(requester)
                    .focusable()
            ) {
                TextField(
                    value = if (empDept.isNullOrEmpty()) "Please Select" else empDept,
                    onValueChange = { empDept },
                    label = { Text("Department: ") },
                    trailingIcon = {
                        Icon(iconDept, "Department",
                            Modifier.clickable { deptExpanded = !deptExpanded }
                        )
                    }
                )
                DropdownMenu(
                    modifier = Modifier
                        .focusRequester(item14),
                    expanded = deptExpanded,
                    onDismissRequest = { deptExpanded = false }
                ) {
                    for (department in deptList) {
                        DropdownMenuItem(
                            onClick = {
                                empDept = department
                                deptExpanded = false
                            }
                        ) {
                            Text(department)
                        }
                    }
                }
            }
            TextField(
                value = position,
                onValueChange = { position = it },
                label = { Text("Position:") },
                modifier = Modifier.padding(start = 2.dp).weight(.65f).focusRequester(item15),
                singleLine = true
            )
        }
        Row(
            modifier = Modifier.padding(top = 10.dp,bottom = 5.dp)
        ){
            Text(
                text = "Emergency Contact Information",
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.h5
            )
        }
        Row(
            modifier = Modifier.padding(top = 5.dp, bottom = 5.dp)
        ) {
            TextField(
                value = emergName,
                onValueChange = { emergName = it },
                label = { Text("Emergency Contact Name") },
                modifier = Modifier.padding(end = 2.dp).weight(.4f).focusRequester(item16),
                singleLine = true
            )
            TextField(
                value = emergRel,
                onValueChange = { emergRel = it },
                label = { Text("Relationship") },
                modifier = Modifier.padding(start = 2.dp, end = 2.dp).weight(.4f)/*.focusRequester(item17)*/,
                singleLine = true
            )
            TextField(
                value = emergPhone,
                onValueChange = { it ->
                    if (it.length <= PHONE_INPUT_LENGTH) {
                        emergPhone = it.filter { it.isDigit() }
                    }
                },
                visualTransformation = MaskVisualTransformation(PHONEMASK),
                label = { Text("Emergency Phone") },
                modifier = Modifier.padding(start = 2.dp, end = 2.dp).weight(.2f)/*.focusRequester(item18)*/,
                singleLine = true
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = {
                    fname = ""
                    mname = ""
                    lname = ""
                    suffix = ""
                    addy = ""
                    city = ""
                    state = ""
                    zip = ""
                    phone = ""
                    dob = ""
                    ssn = ""
                    startDate = ""
                    rate = ""
                    empDept = ""
                    position = ""
                    focusSetter = true
                },
                modifier = Modifier/*.focusRequester(item19)*/
            ) {
                Text( "Clear Form" )
            }
            Button(
                onClick = {
                    employee.component1().firstname = fname
                    employee.component1().middlename = mname
                    employee.component1().lastname = lname
                    employee.component1().suffix = suffix
                    employee.component1().address = addy
                    employee.component1().city = city
                    employee.component1().state = state
                    employee.component1().zip = zip
                    employee.component1().phonenumber = phone
                    employee.component1().dob = dob
                    employee.component1().ssn = ssn
                    employee.component1().startdate = startDate
                    employee.component1().rate = rate.toDouble()
                    employee.component1().department = empDept
                    employee.component1().position = position
                    employee.component1().emergencyName = emergName
                    employee.component1().emergencyPhone = emergPhone
                    employee.component1().emergencyRel = emergRel
                },
                modifier = Modifier.focusRequester(item16)
            ) {
                Text( "Clear Form" )
            }
            DisposableEffect(focusSetter) {
                if (focusSetter) {
                    focusManager.clearFocus()
                }
                onDispose {  }
            }
        }
    }
    LaunchedEffect(Unit) {
        requester.requestFocus()
    }
}

object NumberDefaults {
    const val PHONEMASK = "(###) ###-####"
    const val SSNMASK = "###-##-####"
    const val DOBMASK = "##/##/##"
    const val RATEMASK = "$##.##"
    const val PHONE_INPUT_LENGTH = 10 // Equals to "(###) ###-####".count { it == '#' }
    const val SSN_INPUT_LENGTH = 9 // Equals to "###-##-####".count { it == '#' }
    const val DOB_INPUT_LENGTH = 6 // Equals to "##/##/##".count { it == '#' }
    const val RATE_INPUT_LENGTH = 4 // Equals to "$##.##".count { it == '#' }

}


