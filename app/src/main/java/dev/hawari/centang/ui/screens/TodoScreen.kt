@file:OptIn(ExperimentalMaterial3Api::class)

package dev.hawari.centang.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.hawari.centang.data.Todo
import dev.hawari.centang.ui.components.AddTodo
import dev.hawari.centang.ui.components.TodoItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TodoScreen() {
    val todos = remember {
        mutableStateListOf<Todo>(
            Todo(id = 1, title = "Tidur"),
            Todo(id = 2, title = "Makan", completed = true),
            Todo(id = 3, title = "Mandi"),
        )
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Centang")
                }
            )

        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            AddTodo(
                modifier = Modifier.fillMaxWidth(),
                onSubmit = {
                    todos.add(
                        0,
                        Todo(
                            id = todos.size + 1,
                            title = it
                        )
                    )
                }
            )

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(todos) {
                    TodoItem(
                        todo = it,
                        onCheck = {
                            val index = todos.indexOf(it)
                            todos[index] = todos[index].copy(completed = !todos[index].completed)
                        }
                    )
                }
            }
        }
    }

}
