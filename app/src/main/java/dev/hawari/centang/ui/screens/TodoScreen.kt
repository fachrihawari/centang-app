@file:OptIn(ExperimentalMaterial3Api::class)

package dev.hawari.centang.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import dev.hawari.centang.data.TodoViewModel
import dev.hawari.centang.ui.components.AddTodo
import dev.hawari.centang.ui.components.TodoItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TodoScreen(todoViewModel: TodoViewModel = viewModel()) {
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
                    todoViewModel.addTodo(it)
                }
            )

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                itemsIndexed(todoViewModel.todos) { index, todo ->
                    TodoItem(
                        todo = todo,
                        onCheck = {
                            todoViewModel.completeTodo(index)
                        }
                    )
                }
            }
        }
    }

}
