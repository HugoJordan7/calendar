package com.example.calendar.feature.main.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.calendar.ui.theme.CalendarTheme
import com.example.calendar.util.extension.toBrazilianDateFormat

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalendarTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyApp()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyApp() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        val datePickerState = rememberDatePickerState()
        var selectedDate by remember { mutableStateOf("") }
        DatePicker(state = datePickerState)
        TextField(
            value = selectedDate,
            onValueChange = { },
            Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            label = { Text("Date") },
            readOnly = true
        )
        /*
        val focusManager = LocalFocusManager.current
        var showDatePickerDialog by remember { mutableStateOf(false) }
        val datePickerState = rememberDatePickerState()
        var selectedDate by remember { mutableStateOf("") }

        if (showDatePickerDialog) {
            DatePickerDialog(
                onDismissRequest = { showDatePickerDialog = false },
                confirmButton = {
                    Button(
                        onClick = {
                            datePickerState
                                .selectedDateMillis?.let { millis ->
                                    selectedDate = millis.toBrazilianDateFormat()
                                }
                            showDatePickerDialog = false
                        }) {
                        Text(text = "Escolher data")
                    }
                }) {
                DatePicker(state = datePickerState)
            }
        }
        TextField(
            value = selectedDate,
            onValueChange = { },
            Modifier
                .padding(8.dp)
                .fillMaxWidth()
                .onFocusEvent {
                    if (it.isFocused) {
                        showDatePickerDialog = true
                        focusManager.clearFocus(force = true)
                    }
                },
            label = {
                Text("Date")
            },
            readOnly = true
        )*/
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CalendarTheme {
        MyApp()
    }
}