package com.example.calendar.feature.main.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.format.TextStyle
import java.util.Locale

@Composable
fun CustomCalendar(
    currentDate: LocalDate,
    clientDates: List<LocalDate>,
    onDateSelected: (LocalDate) -> Unit
) {
    val today = currentDate
    val month = today.month
    val year = today.year
    val firstDayOfMonth = LocalDate.of(year, month, 1)
    val daysInMonth = month.length(firstDayOfMonth.isLeapYear)
    val firstDayOfWeek = firstDayOfMonth.dayOfWeek.value % 7

    Column {
        Text(
            text = month.getDisplayName(TextStyle.FULL, Locale.getDefault()) + " " + year,
            style = MaterialTheme.typography.titleSmall,
            modifier = Modifier.padding(16.dp)
        )

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)
        ) {
            DayOfWeek.values().forEach { dayOfWeek ->
                Text(
                    text = dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.getDefault()),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }

        val days = (1..daysInMonth).map {
            LocalDate.of(year, month, it)
        }

        Column {
            for (week in 0..5) {
                Row(modifier = Modifier.fillMaxWidth()) {
                    for (day in 0..6) {
                        val index = week * 7 + day - firstDayOfWeek + 1
                        if (index in 1..daysInMonth) {
                            val date = days[index - 1]
                            val isClientDate = date in clientDates

                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier
                                    .weight(1f)
                                    .aspectRatio(1f)
                                    .padding(4.dp)
                                    .background(
                                        if (isClientDate) Color(0xFF7D18D5) else Color.Transparent,
                                        shape = CircleShape
                                    )
                                    .clickable {
                                        onDateSelected(date)
                                    }
                            ) {
                                Text(
                                    text = date.dayOfMonth.toString(),
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = if (isClientDate) Color.White else Color.Black,
                                    modifier = Modifier.padding(4.dp)
                                )
                            }
                        } else {
                            Spacer(modifier = Modifier.weight(1f))
                        }
                    }
                }
            }
        }
    }
}
