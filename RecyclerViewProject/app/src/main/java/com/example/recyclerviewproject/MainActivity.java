package com.example.recyclerviewproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText todoText;
    private Button addButton;
    private RecyclerView collecionView;

    private ArrayList<Todo> dataSet;
    private TodoAdapter todoAdapter;
    private DbAdapter dbAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        todoText = findViewById(R.id.todo_name);
        addButton = findViewById(R.id.add_button);
        collecionView = findViewById(R.id.collection_view);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        collecionView.setLayoutManager(layoutManager);

        todoAdapter = new TodoAdapter(dataSet);
        collecionView.setAdapter(todoAdapter);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String todoName = todoText.getText().toString();
                if (todoName.isEmpty()){

                    /* // POPUP SCREEN - Alert Dialog
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setMessage("Task field is empty");
                    builder.create().show();*/

                    // TOAST
                    Toast toast = Toast.makeText(MainActivity.this, "Task field is empty", Toast.LENGTH_SHORT);
                    toast.show();

                } else {
                    Todo todo = new Todo(todoName);
                    dbAdapter.createTodo(todo);
                    dataSet.add(todo);
                    todoAdapter.notifyDataSetChanged();
                    todoText.setText("");
                }
            }
        });

        initDB();
    }

    private void initDB() {
        dbAdapter = DbAdapter.getInstance(this);
        dbAdapter.open();
        if (dbAdapter.isEmpty()){
            dbAdapter.createTodo(new Todo("Sarandonga"));
            dbAdapter.createTodo(new Todo("Cuchibiry"));
            dbAdapter.createTodo(new Todo("Xuxibiri"));
            dbAdapter.createTodo(new Todo("Vamoh a come"));
        }
        fetchData();
    }

    private void fetchData(){
        Cursor todosCursor = dbAdapter.fetchAllTodos();

        this.dataSet = new ArrayList<>();
        for (todosCursor.moveToFirst(); !todosCursor.isAfterLast(); todosCursor.moveToNext()){
            this.dataSet.add(new Todo (todosCursor.getInt(0), todosCursor.getString(1)) );
        }

        todoAdapter = new TodoAdapter(dataSet);
        collecionView.setAdapter(todoAdapter);
    }

    @Override
    protected void onDestroy() {
        dbAdapter.close();
        super.onDestroy();
    }
}
