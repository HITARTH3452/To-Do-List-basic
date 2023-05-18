package com.geekster.ToDo.Service;

import com.geekster.ToDo.models.ToDo;
import com.geekster.ToDo.repository.ToDoDaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ToDoService {
    List<ToDo> todolist;
    @Autowired
    ToDoDaoRepository toDoDaoRepository;

    public List<ToDo> getAllTodos() {
        return toDoDaoRepository.getTodosfromdatasources();
    }

    public String addMytodo(ToDo todo) {
        boolean insertionStatus = toDoDaoRepository.save(todo);
        if (insertionStatus) {
            return "Todo added successfully!!!!";
        } else {
            return "Failed!!!.....Todo Not Possible";
        }
    }

    public List<ToDo> getTodoByUserStatus(String status)
    {
        List<ToDo> todoListRightNow =  toDoDaoRepository.getTodosfromdatasources();

        List<ToDo> todoListStatusBased = new ArrayList<>();

        for(ToDo todo : todoListRightNow)
        {
            if(todo.isTodoStatus() == Boolean.parseBoolean(status))
            {
                todoListStatusBased.add(todo);
            }
        }
        return todoListStatusBased;

    }

    public ToDo getTodobasedOnId(String id) {
        List<ToDo> todoListRightNow = toDoDaoRepository.getTodosfromdatasources();

        for (ToDo todo : todoListRightNow) {
            if (todo.getId().equals(id)) {
                return todo;
            }
        }
        return null;
    }

    public String removeTodoById(String id) {
        String status;
        boolean deleteRespone = false;
        if (id != null) {
            List<ToDo> todoListRightNow = toDoDaoRepository.getTodosfromdatasources();

            for (ToDo todo : todoListRightNow) {
                if (todo.getId().equals(id)) {
                    deleteRespone = toDoDaoRepository.remove(todo);
                    if(deleteRespone) {
                        status = "Todo with id " + id + " was deleted!!";
                    } else {
                        status = "Todo with id " + id + " was not deleted!!!...Database error";
                    }
                    return status;
                }
            }
            return "Todo with id " + id + " Does not exists";
        }else{
            return "Invalid Id .....Cannot accept NUll ID!!";
    }
    }

    public String updateTodoStatuById(String id, String status) {
        boolean updateStatus = toDoDaoRepository.update(id, Boolean.parseBoolean(status));

        if(updateStatus){
            return "Todo with id: " + id + " was updated";
        }else{
            return "Todo with id: " + id + "was not updated!!!";
        }
    }


}




