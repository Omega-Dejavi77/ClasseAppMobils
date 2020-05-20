package com.example.recyclerviewproject;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

// Proxy between persistence and view.
public class DataBaseController {
    private TodoDao todoDao;
    private LiveData<List<Todo>> allTodos;

    public DataBaseController(Application application){
        AppDatabase db = AppDatabase.getDatabase(application);
        todoDao = db.todoDao();

        // Es carreguen els todos només iniciar l'app perquè sabem que els necessitarem
        allTodos = todoDao.getAll();
    }

    public LiveData<List<Todo>> fetchAll(){
        return allTodos;
    }

    public void setTodo(String task){
        Todo newTodo = new Todo();
        newTodo.task = task;
        new insertAsyncTask(todoDao).execute(newTodo);
    }

    private class insertAsyncTask extends AsyncTask<Todo, Void, Void> {
        TodoDao todoDao;

        public insertAsyncTask(TodoDao todoDao) {
            this.todoDao = todoDao;
        }

        @Override
        protected Void doInBackground(Todo... todos) {
            todoDao.insertTodo(todos[0]);
            return null;
        }
    }
}
