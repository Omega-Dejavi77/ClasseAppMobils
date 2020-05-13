package com.example.recyclerviewproject;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Todo {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "task")
    public String task;

}
