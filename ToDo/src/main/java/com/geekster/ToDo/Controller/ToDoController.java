package com.geekster.ToDo.Controller;

import com.geekster.ToDo.models.ToDo;
import com.geekster.ToDo.Service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
public class ToDoController {

    @Autowired
    ToDoService toDoService;

    //get me all the todos in my present todo-List:
    @GetMapping(value = "/getTodos")
    public List<ToDo> getAllTodos(){
         return toDoService.getAllTodos();
    }

    @GetMapping(value = "/gettodoBystatus")
    public List<ToDo> getTodoByStatus(@RequestParam String status){
        return toDoService.getTodoByUserStatus(status);
    }

    @PostMapping(value = "/addTodo")
    public String addTodo(@RequestBody ToDo todo){
        return toDoService.addMytodo(todo);
    }

    @RequestMapping(value = "/getTodoById{id}", method = RequestMethod.GET)
    public ToDo getTodoById(@PathVariable String id){
        return toDoService.getTodobasedOnId(id);
    }

    //create a delete endpoint
    @DeleteMapping(value = "/deleteTodoById/{id}")
    public String deletetodobyId(@PathVariable String id){
        return toDoService.removeTodoById(id);
    }

    //updation of todo

    @PutMapping(value = "/updateTodoById/{id}/{status}")
    public String updateTodoByid(@PathVariable String id, @PathVariable String status){
        return toDoService.updateTodoStatuById(id,status);
    }
}
