package com.example.recyclerviewproject;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class TodoViewModel extends AndroidViewModel {
    private DataBaseController repository;
    private LiveData<List<Todo>> allTodos;

    public TodoViewModel(@NonNull Application application) {
        super(application);
        repository = new DataBaseController(application);
        allTodos = repository.fetchAll();
    }

    LiveData<List<Todo>> getAllTodos(){
        return allTodos;
    }

    void insert(String task) {
        repository.setTodo(task);
    }
}
