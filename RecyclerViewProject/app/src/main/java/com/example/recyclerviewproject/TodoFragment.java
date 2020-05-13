package com.example.recyclerviewproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TodoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TodoFragment extends Fragment {

    private EditText todoText;
    private Button addButton;
    private RecyclerView collecionView;

    private ArrayList<Todo> dataSet;
    private TodoAdapter todoAdapter;

    public TodoFragment() {
        // Required empty public constructor
    }


    public static TodoFragment newInstance() {
        return new TodoFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View fragmentView = inflater.inflate(R.layout.fragment_todo, container, false);

        todoText = fragmentView.findViewById(R.id.todo_name);
        addButton = fragmentView.findViewById(R.id.add_button);
        collecionView = fragmentView.findViewById(R.id.collection_view);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        collecionView.setLayoutManager(layoutManager);

        if (savedInstanceState == null) { //It is NOT a 'reboot' or 'reload'
            CreateDummyContent();
        } else { //It is a 'reboot' or 'reload', so restore data
            dataSet = savedInstanceState.getParcelableArrayList("dataSet");
            todoText.setText(savedInstanceState.getString("todoText"));
        }

        todoAdapter = new TodoAdapter(dataSet);
        collecionView.setAdapter(todoAdapter);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String todoName = todoText.getText().toString();
                dataSet.add(new Todo(todoName));
                todoAdapter.notifyDataSetChanged();

                todoText.setText("");
            }
        });

        return fragmentView;
    }

    private void CreateDummyContent() {
        dataSet = new ArrayList<>();
        dataSet.add(new Todo("Task 1"));
        dataSet.add(new Todo("Task 2"));
        dataSet.add(new Todo("Task 3"));
        dataSet.add(new Todo("Task 4"));
    }
}
