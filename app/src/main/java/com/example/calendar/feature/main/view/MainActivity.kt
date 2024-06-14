package com.example.calendar.feature.main.view

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerColors
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.calendar.ui.theme.CalendarTheme
import com.example.calendar.util.extension.toBrazilianDateFormat
import com.example.calendar.util.extension.toDateInMillis
import java.time.Instant
import java.time.LocalDate

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
//        val daysMarked = listOf(
//            "15/06/2024".toDateInMillis(),
//            "19/06/2024".toDateInMillis(),
//            "24/06/2024".toDateInMillis(),
//            "25/06/2024".toDateInMillis(),
//            //System.currentTimeMillis()
//        )
//        CustomDatePicker(daysMarked = daysMarked)
        Calendar()
    }
}

@Composable
fun Calendar() {
    val context = LocalContext.current
    val currentDate = remember { mutableStateOf(LocalDate.now()) }
    val clientDates = listOf(
        LocalDate.of(2024, 6, 14),
        LocalDate.of(2024, 6, 15),
        LocalDate.of(2024, 6, 18),
        LocalDate.of(2024, 6, 19)
    )

    CustomCalendar(
        currentDate = LocalDate.of(2024, 6, 14),
        clientDates = clientDates,
        onDateSelected = {
            Toast.makeText(context, "Marcar atendimento em ${it.dayOfMonth}?", Toast.LENGTH_SHORT).show()
        }
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CalendarTheme {
        MyApp()
    }
}