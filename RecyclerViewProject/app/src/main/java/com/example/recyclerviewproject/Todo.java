package com.example.recyclerviewproject;

import java.util.Random;

public class Todo {
    private int id;
    private String task;

    public Todo(String task){
        this.task = task;
        this.id = new Random().nextInt(9999);
    }

    public int getId() {
        return id;
    }

    public String getIdAsString() {
        return id+"";
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }
}
