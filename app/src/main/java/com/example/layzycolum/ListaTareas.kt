package com.example.layzycolum

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.ui.unit.dp


@Composable
fun ListaTareas() {
    var tareas by remember {
        mutableStateOf(
            listOf(
                Tarea("Comprar", false),
                Tarea("Estudiar", false),
                Tarea("Llamar a mamá", true),
                Tarea("Hacer ejercicio", false),
                Tarea("Hacer acceso a datos", false),
                Tarea("Entreno de padel", false),
                Tarea("Cita en el tayer", true),
                Tarea("Aprobar todo", false),
                Tarea("Comprar", false),
                Tarea("Estudiar", false),
                Tarea("Llamar a mamá", true),
                Tarea("Hacer ejercicio", false),
                Tarea("Hacer acceso a datos", false),
                Tarea("Entreno de padel", false),
                Tarea("Cita en el tayer", true),
                Tarea("Aprobar todo", false)
            )
        )
    }

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(tareas) { tarea ->
            TaskItem(tarea = tarea) {
                tareas = tareas.map { t ->
                    if (t.titulo == tarea.titulo) {
                        t.copy(completada = !t.completada)
                    } else {
                        t
                    }
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun TaskItem(tarea: Tarea, onTaskCompletedChange: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = if (tarea.completada) Icons.Default.Check else Icons.Default.Close,
            contentDescription = if (tarea.completada) "Completada" else "Pendiente",
            tint = if (tarea.completada) Color.Green else Color.Red,
            modifier = Modifier.size(24.dp)
        )

        Spacer(modifier = Modifier.width(16.dp))

        Text(
            text = tarea.titulo,
            style = MaterialTheme.typography.bodyMedium
        )

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = onTaskCompletedChange,
        ) {
            Text(if (tarea.completada) "Desmarcar" else "Completar")
        }
    }
}