package com.example.recyclerviewproject;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface TodoDao {

    @Query("SELECT * FROM todo")
    LiveData<List<Todo>> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertTodo(Todo newElement);

}
