package kr.re.kitri.springpost.service;

import kr.re.kitri.springpost.model.Todo;
import kr.re.kitri.springpost.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> getAllTodos() {
        return todoRepository.selectAllTodos();
    }

    public Todo getTodoById(long todoId) {
        return todoRepository.selectTodoById(todoId);
    }

    public Todo setTodo(Todo todo) {
        return todoRepository.insertTodo(todo);
    }

    public Todo modifyTodo(long todoId) {
        return todoRepository.modifyTodo(todoId);
    }

    public Todo removeTodo(long todoId) {
        return todoRepository.deleteTodo(todoId);
    }

}
