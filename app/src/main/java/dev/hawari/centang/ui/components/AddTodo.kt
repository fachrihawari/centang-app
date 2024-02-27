package dev.hawari.centang.ui.components

import android.util.Log
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AddTodo(modifier: Modifier = Modifier, onSubmit: (todo: String) -> Unit) {
    var newTodo by remember {
        mutableStateOf("")
    }

    val submitHandler = {
        Log.i("AddTodo", "New todo created $newTodo")
        onSubmit(newTodo)
        newTodo = ""
    }

    TextField(
        value = newTodo,
        onValueChange = {
            newTodo = it
        },
        singleLine = true,
        label = {
            Text(text = "Ada yang mau dicentang?")
        },
        modifier = modifier,
        trailingIcon = {
            IconButton(onClick = {
                submitHandler()
            }) {
                Icon(
                    modifier = Modifier.size(24.dp),
                    imageVector = Icons.Filled.Send,
                    contentDescription = "Tombol Kirim"
                )
            }
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Send
        ),
        keyboardActions = KeyboardActions(
            onSend = {
                submitHandler()
            }
        )
    )
}

@Preview()
@Composable
fun PreviewAddTodo() {
    AddTodo(
        onSubmit = {}
    )
}