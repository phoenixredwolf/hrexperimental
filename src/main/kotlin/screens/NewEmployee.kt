package screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusOrder
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onPreviewKeyEvent
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import data.model.States
import org.jetbrains.skia.Color
import screens.NumberDefaults.DOBMASK
import screens.NumberDefaults.DOB_INPUT_LENGTH
import screens.NumberDefaults.PHONEMASK
import screens.NumberDefaults.PHONE_INPUT_LENGTH
import screens.NumberDefaults.SSNMASK
import screens.NumberDefaults.SSN_INPUT_LENGTH
import util.MaskVisualTransformation

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun newEmployee() {

    val focusManager = LocalFocusManager.current
    val (item1, item2, item3, item4, item5, item6, item7, item8, item9, item10, item11) =
        remember { FocusRequester.createRefs() }
    var fname by remember { mutableStateOf("") }
    var mname by remember { mutableStateOf("") }
    var lname by remember { mutableStateOf("") }
    var suffix by remember { mutableStateOf("") }
    var addy by remember { mutableStateOf("") }
    var city by remember { mutableStateOf("") }
    var empState by remember { mutableStateOf(States.AL) }
    var zip by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var dob by remember { mutableStateOf("") }
    var ssn by remember { mutableStateOf("") }
    var expanded: Boolean by remember { mutableStateOf(false) }
    var homeState by remember { mutableStateOf(States.AL) }
    val icon = if (expanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown

    Column(
        modifier = Modifier.fillMaxSize().padding(15.dp),
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
                    .focusRequester(item1)
                    .focusOrder {
                        next = item2
                        right = item2
                        down = item2
                        previous = item1
                    }.focusable()
                    .onPreviewKeyEvent {
                        if (it.key == Key.Tab /*&& it.nativeKeyEvent == FocusDirection.Next*/) {
                            focusManager.moveFocus(FocusDirection.Next)
                            true
                        } else {
                            false
                        }
                    },
                value = fname,
                onValueChange = { fname = it },
                label = { Text("First name: ") },
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                keyboardActions = KeyboardActions(
                    onNext = { focusManager.moveFocus(FocusDirection.Next) }
                ),
                singleLine = true
            )
            TextField(
                modifier = Modifier.weight(.25f)
                    .padding(start = 2.dp, end = 2.dp)
                    .focusRequester(item2)
                    .focusOrder {
                        next = item3
                        right = item3
                        down = item3
                        previous = item1
                    }.focusable()
                    .onPreviewKeyEvent {
                        if (it.key == Key.Tab && it.nativeKeyEvent == FocusDirection.Next) {
                            focusManager.moveFocus(FocusDirection.Next)
                            true
                        } else {
                            false
                        }
                    },
                value = mname,
                onValueChange = { mname = it },
                label = { Text("Middle Name: ") }
            )
            TextField(
                modifier = Modifier.weight(.25f)
                    .padding(start = 2.dp, end = 2.dp)
                    .focusRequester(item3)
                    .focusOrder {
                        next = item4
                        right = item4
                        down = item4
                        previous = item3
                    }.focusable()
                    .onPreviewKeyEvent {
                        if (it.key == Key.Tab && it.nativeKeyEvent == FocusDirection.Next) {
                            focusManager.moveFocus(FocusDirection.Next)
                            true
                        } else {
                            false
                        }
                    },
                value = lname,
                onValueChange = { lname = it },
                label = { Text("Last Name: ") }
            )
            TextField(
                modifier = Modifier.weight(.25f)
                    .padding(start = 2.dp)
                    .focusRequester(item4)
                    .focusOrder {
                        next = item5
                        right = item5
                        down = item5
                        previous = item4
                    }.focusable()
                    .onPreviewKeyEvent {
                        if (it.key == Key.Tab && it.nativeKeyEvent == FocusDirection.Next) {
                            focusManager.moveFocus(FocusDirection.Next)
                            true
                        } else {
                            false
                        }
                    },
                value = suffix,
                onValueChange = { suffix = it },
                label = { Text("Suffix: ") }
            )
        }
        Row(
            modifier = Modifier.padding(top = 5.dp, bottom = 5.dp)
        ) {
            TextField(
                modifier = Modifier.weight(1f)
                    .focusRequester(item5)
                    .focusOrder {
                        next = item1
                        right = item1
                        down = item1
                        previous = item1
                    }.focusable(),
                value = addy,
                onValueChange = { addy = it },
                label = { Text("Street Address: ") }
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth().padding(top = 5.dp)
        ) {
            TextField(
                modifier = Modifier.weight(.5f).padding(end = 2.dp)
                    .focusRequester(item6)
                    .focusOrder {
                        next = item1
                        right = item1
                        down = item1
                        previous = item1
                    }.focusable(),
                value = city,
                onValueChange = { city = it },
                label = { Text("City: ") }
            )
            Box(
                modifier = Modifier.weight(.1f).padding(start = 2.dp, end = 2.dp)
            ) {
                TextField(
                    modifier = Modifier
                        .focusRequester(item7)
                        .focusOrder {
                            next = item1
                            right = item1
                            down = item1
                            previous = item1
                        }.focusable(),
                    value = homeState.toString(),
                    onValueChange = { empState = homeState },
                    label = { Text("State: ") },
                    trailingIcon = {
                        Icon(icon, "State",
                            Modifier.clickable { expanded = !expanded }
                        )
                    }
                )
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    for (state in States.values()) {
                        DropdownMenuItem(
                            onClick = {
                                homeState = state
                                expanded = false
                            }
                        ) {
                            Text(state.toString())
                        }
                    }
                }

            }
            TextField(
                modifier = Modifier.weight(.3f).padding(start = 2.dp)
                    .focusRequester(item8)
                    .focusOrder {
                        next = item1
                        right = item1
                        down = item1
                        previous = item1
                    }.focusable(),
                value = zip,
                onValueChange = { zip = it },
                label = { Text("Zip Code: ") }
            )

        }
        Row(
            modifier = Modifier.padding(top = 5.dp, bottom = 5.dp)
        ) {
            TextField(
                modifier = Modifier.weight(.5f).padding(end = 2.dp)
                    .focusRequester(item9)
                    .focusOrder {
                        next = item1
                        right = item1
                        down = item1
                        previous = item1
                    }.focusable(),
                value = phone,
                onValueChange = { it ->
                    if (it.length <= PHONE_INPUT_LENGTH) {
                        phone = it.filter { it.isDigit() }
                    }
                },
                visualTransformation = MaskVisualTransformation(PHONEMASK),
                label = { Text("Phone Number") }
            )
            TextField(
                modifier = Modifier.weight(.5f).padding(end = 2.dp)
                    .focusRequester(item10)
                    .focusOrder {
                        next = item1
                        right = item1
                        down = item1
                        previous = item1
                    }.focusable(),
                value = ssn,
                onValueChange = { it ->
                    if (it.length <= SSN_INPUT_LENGTH) {
                        ssn = it.filter { it.isDigit() }
                    }
                },
                visualTransformation = MaskVisualTransformation(SSNMASK),
                label = { Text("Social Security Number") }
            )
            TextField(
                value = dob,
                modifier = Modifier.weight(.5f)
                    .padding(end = 2.dp)
                    .focusRequester(item11)
                    .focusOrder {
                        next = item1
                        right = item1
                        down = item1
                        previous = item1
                    }.focusable(),
                onValueChange = { it ->
                    if (it.length <= DOB_INPUT_LENGTH) {
                        dob = it.filter { it.isDigit() }
                    }
                },
                visualTransformation = MaskVisualTransformation(DOBMASK),
                label = { Text("Date Of Birth") },
                placeholder = { Text("MM/DD/YY") }
            )
        }
    }
}

object NumberDefaults {
    const val PHONEMASK = "(###) ###-####"
    const val SSNMASK = "###-##-####"
    const val DOBMASK = "##/##/##"
    const val PHONE_INPUT_LENGTH = 10 // Equals to "(###) ###-####".count { it == '#' }
    const val SSN_INPUT_LENGTH = 9 // Equals to "###-##-####".count { it == '#' }
    const val DOB_INPUT_LENGTH = 6 // Equals to "##/##/##".count { it == '#' }

}


