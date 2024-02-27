package dev.hawari.centang.data

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class TodoViewModel : ViewModel() {

    // Create private _todos
    // make sure only the ViewModel able to edit the todos list
    private var _todos = mutableStateListOf<Todo>(
        Todo(id = 1, title = "Tidur"),
        Todo(id = 2, title = "Makan", completed = true),
        Todo(id = 3, title = "Mandi"),
    )

    // Create todos getter
    val todos: List<Todo>
        get() = _todos.toList()

    // Add new item to the list
    fun addTodo(title: String) {
        _todos.add(
            0,
            Todo(
                id = todos.size + 1,
                title = title
            )
        )
    }

    // Mark item as completed
    fun completeTodo(index: Int) {
        _todos[index] = todos[index].copy(completed = !todos[index].completed)
    }
}