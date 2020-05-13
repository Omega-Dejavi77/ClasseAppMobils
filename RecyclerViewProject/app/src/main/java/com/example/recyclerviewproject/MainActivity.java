package com.example.recyclerviewproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText todoText;
    private Button addButton;
    private RecyclerView collecionView;

    private ArrayList<Todo> dataSet;
    private TodoAdapter todoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putParcelableArrayList("dataSet", dataSet);
        outState.putString("todoText", todoText.getText().toString());

        super.onSaveInstanceState(outState); // Do last
    }

    // ALTERNATIVE VERSION TO RESTORE DATA
    /*@Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState); // Do first

        // Be careful it must be created after storing the data in the set
        todoAdapter = new TodoAdapter(dataSet);
        collecionView.setAdapter(todoAdapter);

        CreateAndSetTodoAdapter();
    }*/

}
