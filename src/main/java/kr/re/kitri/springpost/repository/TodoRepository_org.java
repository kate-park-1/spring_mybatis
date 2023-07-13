package kr.re.kitri.springpost.repository;

import kr.re.kitri.springpost.model.Todo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

//@Repository
public class TodoRepository_org {

    public List<Todo> selectAllTodos() {
        List<Todo> todos = new ArrayList<>();
        todos.add(new Todo(1,"todo1", false));
        todos.add(new Todo(2,"todo2", false));
        todos.add(new Todo(3,"todo3", false));
        return todos;
    }

    public Todo selectTodoById(long todoId) {
        return new Todo(todoId,"testTodo", false);
    }

    public Todo insertTodo(Todo todo) {
        return todo;
    }

    public Todo modifyTodo(long todoId) {
        return new Todo(todoId,"modifiedTodo", true);
    }

    public Todo deleteTodo(long todoId) {
        return new Todo(todoId,"deleteTodo", false);
    }

}
