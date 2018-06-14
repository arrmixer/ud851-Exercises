package com.example.android.todolist;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.android.todolist.database.AppDatabase;
import com.example.android.todolist.database.TaskEntry;

import java.util.List;

public class MainViewModel extends AndroidViewModel {

    // Constant for logging
    private static final String TAG = MainViewModel.class.getSimpleName();

    private LiveData<List<TaskEntry>> tasks;
    private TasksRepository mTasksRepository;

    public MainViewModel(@NonNull Application application) {
        super(application);
        mTasksRepository = new TasksRepository(application);
        Log.d(TAG, "Actively retrieving the tasks from the DataBase");
        tasks = mTasksRepository.getTasks();
    }

    public LiveData<List<TaskEntry>> getTasks() {
        return tasks;
    }


    public void deleteTask(TaskEntry taskEntry) {
        mTasksRepository.deleteTask(taskEntry);
    }
}
