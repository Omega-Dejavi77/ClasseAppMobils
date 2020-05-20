package com.example.recyclerviewproject;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class TodoViewModel extends AndroidViewModel {
    private DataRepository repository;
    private LiveData<List<Todo>> allTodos; // És una referència a un mètode, no a dades

    public TodoViewModel(@NonNull Application application) {
        super(application);
        repository = new DataRepository(application);
        // Assignació del mètode a utilitzar cada cop que es vulguin consultar les dades d'allTodos
        allTodos = repository.fetchAll();
    }

    LiveData<List<Todo>> getAllTodos(){
        return allTodos;
    }

    void insert(String task) {
        repository.setTodo(task);
    }
}
