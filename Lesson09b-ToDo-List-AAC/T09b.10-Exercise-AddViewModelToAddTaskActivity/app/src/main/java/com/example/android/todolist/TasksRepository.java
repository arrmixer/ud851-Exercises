package com.example.android.todolist;

import android.app.Application;
import android.arch.lifecycle.LiveData;

import com.example.android.todolist.database.AppDatabase;
import com.example.android.todolist.database.TaskDao;
import com.example.android.todolist.database.TaskEntry;

import java.util.List;

public class TasksRepository {

    private LiveData<List<TaskEntry>> tasks;
    private AppDatabase db;

    public TasksRepository(Application application) {
        db = AppDatabase.getInstance(application);
        tasks = db.taskDao().loadAllTasks();
    }

    public void insertTask(TaskEntry taskEntry) {
        db.taskDao().insertTask(taskEntry);
    }

    public void updateTask(TaskEntry taskEntry) {
        db.taskDao().updateTask(taskEntry);
    }

    public void deleteTask(TaskEntry taskEntry) {
        db.taskDao().deleteTask(taskEntry);
    }

    public LiveData<List<TaskEntry>> getTasks() {
        return tasks;
    }

    public LiveData<TaskEntry> loadTaskById(int taskId) {
        return db.taskDao().loadTaskById(taskId);
    }

    public AppDatabase getDb() {
        return db;
    }
}
