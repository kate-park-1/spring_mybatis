package kr.re.kitri.springpost.repository;

import kr.re.kitri.springpost.model.Todo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

//@Repository  // mapper 등록하면 @Repository둥록 안해도 component로 등록된다.
@Mapper
public interface TodoRepository {

    List<Todo> selectAllTodos() ;

    Todo selectTodoById(int id) ;

    void insertTodo(Todo todo) ;

    void modifyTodo(int id);

    void deleteTodo(int iId) ;

}
