package com.example.recyclerviewproject;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Todo.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase instance;

    public abstract TodoDao todoDao();

    public static AppDatabase getDatabase(Context context) {
        if (instance == null)
            instance = Room.databaseBuilder( context.getApplicationContext(), AppDatabase.class, "database-test")  .build();

        return instance;
    }

    public static void destroyDatabase(){
        instance = null;
    }
}
