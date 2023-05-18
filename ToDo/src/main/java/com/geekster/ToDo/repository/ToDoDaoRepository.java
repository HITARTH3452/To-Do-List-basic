package com.geekster.ToDo.repository;

import com.geekster.ToDo.models.ToDo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ToDoDaoRepository {
    private List<ToDo> todolist;

    public ToDoDaoRepository(){
        todolist = new ArrayList<>();
        //done for testing
        todolist.add(new ToDo("0","dummy to do for testing",false));
    }
    public List<ToDo> getTodosfromdatasources(){
       return todolist;
    }
    public boolean save(ToDo todo){
        todolist.add(todo);
        return true;
    }

    public boolean remove(ToDo todo){
        todolist.remove(todo);//mock a database
        return true;
    }

    public boolean update(String id, boolean status){
        boolean updateStatus = false;
        for(ToDo todo : todolist)
        {
            if(todo.getId().equals(id))
            {
                remove(todo);

                todo.setTodoStatus(status);

                save(todo);

                return true;
            }
        }
        return false;
    }
}
