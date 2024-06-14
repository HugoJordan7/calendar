package com.example.calendar.feature.main.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DateRangePicker
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.calendar.util.extension.toBrazilianDateFormat

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomDatePicker(daysMarked: List<Long>){
    val datePickerState = rememberDatePickerState(
        initialSelectedDateMillis = daysMarked[0]
    )
    val dateToString = datePickerState.selectedDateMillis?.toBrazilianDateFormat() ?: ""


    MaterialTheme(
        colorScheme = lightColorScheme(
            primary = Color(0xFF7D18D5),
            secondary = Color(0xFF7D18D5)
        )
    ) {
        Column {
            DatePicker(
                state = datePickerState,
                dateValidator = { daysMarked.contains(it) }
            )
            Row(modifier = Modifier.padding(top = 40.dp)) {
                Spacer(modifier = Modifier
                    .padding(start = 10.dp, end = 5.dp)
                    .size(15.dp)
                    .background(color = Color(0xFF7D18D5), shape = RoundedCornerShape(100))
                    .align(Alignment.CenterVertically)
                )
                Text(text = "Next client", color = Color.Black, modifier = Modifier.align(Alignment.CenterVertically))
            }
        }
    }
}