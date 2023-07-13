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

    public Todo getTodoById(int id) {
        return todoRepository.selectTodoById(id);
    }

    public Todo setTodo(Todo todo) {
        todoRepository.insertTodo(todo);
        return todo;
    }

    public void modifyTodo(int id) {
        todoRepository.modifyTodo(id);
    }

    public void removeTodo(int id) {

        todoRepository.deleteTodo(id);
    }

}
