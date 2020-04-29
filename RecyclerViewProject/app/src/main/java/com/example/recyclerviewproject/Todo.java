package com.example.recyclerviewproject;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Random;

public class Todo implements Parcelable {
    private int id;
    private String task;

    public Todo(String task){
        this.task = task;
        this.id = new Random().nextInt(9999);
    }

    protected Todo(Parcel in) {
        super();
        readFromParcel(in);
    }

    public static final Creator<Todo> CREATOR = new Creator<Todo>() {
        @Override
        public Todo createFromParcel(Parcel in) {
            return new Todo(in);
        }

        @Override
        public Todo[] newArray(int size) {
            return new Todo[size];
        }
    };

    public int getId() {
        return id;
    }

    public String getIdAsString() {
        return id+"";
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    private void readFromParcel(Parcel in) {
        // The 'readXXX' methods of a Parcel reads the elements by order, so the insertion order must be taken into account.
        id = in.readInt(); // Reads the first int
        task = in.readString(); // Reads the first string
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id); // Writes the first int
        dest.writeString(task); // Writes the first string
    }
}
