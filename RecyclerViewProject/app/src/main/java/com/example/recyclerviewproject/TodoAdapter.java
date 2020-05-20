package com.example.recyclerviewproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.ViewHolder> {
    private List<Todo> data = Collections.emptyList();

    public TodoAdapter(){
    }

    public void setTodos(List<Todo> data){
        this.data = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    // Creates the views of each item
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Uses the 'collection_item' layout to create them
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.collection_item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    // Allows setting the data of each item
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Todo currentTodo = data.get(position);
        holder.id.setText(currentTodo.id);
        holder.task.setText(currentTodo.task);
    }

    @Override
    // The number of items
    public int getItemCount() {
        return data.size();
    }

    // Allows the access to the view of an item
    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView id;
        public TextView task;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.todo_id);
            task = itemView.findViewById(R.id.todo_task);
        }
    }
}
