package dev.hawari.centang.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.hawari.centang.data.Todo


@Composable
fun TodoItem(todo: Todo, onCheck: () -> Unit = {}) {

    val containerColor =
        if (todo.completed) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.background
    val tintColor =
        if (todo.completed) MaterialTheme.colorScheme.background
        else MaterialTheme.colorScheme.primary

    ListItem(
        colors = ListItemDefaults.colors(
            containerColor,
            overlineColor = containerColor
        ),
        modifier = Modifier
            .clickable {
                onCheck()
            }
            .clip(shape = RoundedCornerShape(8.dp))
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.primary,
                shape = RoundedCornerShape(8.dp)
            ),
        headlineContent = {
            val textDecoration =
                if (todo.completed) TextDecoration.LineThrough
                else TextDecoration.None
            Text(
                text = todo.title,
                color = tintColor,
                style = TextStyle(textDecoration = textDecoration),
            )
        },
        leadingContent = {
            Icon(
                imageVector = Icons.Outlined.CheckCircle,
                contentDescription = "Check Icon",
                tint = tintColor
            )
        },
    )
}


@Preview("Completed TodoItem")
@Composable
fun PreviewTodoItemCompleted() {
    TodoItem(
        Todo(id = 1, title = "Sarapan Pagi", completed = true)
    )
}

@Preview("Pending TodoItem")
@Composable
fun PreviewTodoItemPending() {
    TodoItem(
        Todo(id = 1, title = "Makan Siang", completed = false)
    )
}