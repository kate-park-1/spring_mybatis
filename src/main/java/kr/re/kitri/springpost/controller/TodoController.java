package kr.re.kitri.springpost.controller;

import kr.re.kitri.springpost.model.Todo;
import kr.re.kitri.springpost.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping("/todos")
    public List<Todo> viewAllTodos(){
        return todoService.getAllTodos();
    }

    @GetMapping("/todos/{id}")
    public Todo viewTodoById(@PathVariable int id){
        return todoService.getTodoById(id);
    }

    @PostMapping("/todos") // api에서는 요청바디에 json 형태로 요청자료를 넘겨준다.
    // json을 Todo 라는 모델로 json의 필드 이름이 같으면 자동으로 데이터를 채워서 넘겨준다.
    public Todo registTodo(@RequestBody Todo todo){
        return todoService.setTodo(todo);
    }

    @PutMapping("/todos/{id}")
    public void modifyTodo(@PathVariable int id){
        todoService.modifyTodo(id);
    }

    @DeleteMapping("/todos/{id}") // 문자형태인 숫자를 long으로 타입 변환, 그러므로 aaa 와 같이 문자열을 입력하면 변환 오류 발생한다.
    public void removeTodo(@PathVariable int id){
        todoService.removeTodo(id);
    }

}
