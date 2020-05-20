package com.example.recyclerviewproject;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText todoText;
    private Button addButton;
    private RecyclerView collecionView;

    private TodoAdapter todoAdapter;
    private TodoViewModel todoViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        todoText = findViewById(R.id.todo_name);
        addButton = findViewById(R.id.add_button);
        collecionView = findViewById(R.id.collection_view);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        collecionView.setLayoutManager(layoutManager);

        todoAdapter = new TodoAdapter();
        collecionView.setAdapter(todoAdapter);

        todoViewModel = new ViewModelProvider(this).get(TodoViewModel.class);
        // Si les dades del repositori canvien (todoViewModel.getAllTodos()), actualitza la UI (todoAdapter)
        todoViewModel.getAllTodos().observe(this, new Observer<List<Todo>>() {
            @Override
            public void onChanged(List<Todo> todos) {
                todoAdapter.setTodos(todos);
            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String todoName = todoText.getText().toString();
                todoViewModel.insert(todoName);
                todoText.setText("");
            }
        });
    }

    @Override
    protected void onDestroy() {
        AppDatabase.destroyDatabase();
        super.onDestroy();
    }
}
