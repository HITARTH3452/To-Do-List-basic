package com.geekster.ToDo.models;

public class ToDo {
    private static String id;;
    private String todoName;
    private Boolean todoStatus;

    public void setId(String id) {
        this.id = id;
    }

    public static String getId() {
        return id;
    }

    public ToDo(String id,String todoName, Boolean todoStatus) {
        this.id = id;
        this.todoName = todoName;
        this.todoStatus = todoStatus;
    }

    public void setTodoName(String todoName) {
        this.todoName = todoName;
    }

    public void setTodoStatus(Boolean todoStatus) {
        this.todoStatus = todoStatus;
    }

    public String getTodoName() {
        return todoName;
    }

    public Boolean getTodoStatus() {
        return todoStatus;
    }

    public boolean isTodoStatus() {
        return todoStatus;
    }
}
