package com.example.android.todolist;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;

import com.example.android.todolist.database.AppDatabase;
import com.example.android.todolist.database.TaskEntry;

// TODO (5) Make this class extend ViewModel
public class AddTaskViewModel extends AndroidViewModel {

    // TODO (6) Add a task member variable for the TaskEntry object wrapped in a LiveData
    private LiveData<TaskEntry> task;

    private TasksRepository mTasksRepository;


    // TODO (8) Create a constructor where you call loadTaskById of the taskDao to initialize the tasks variable
    // Note: The constructor should receive the database and the taskId

    public AddTaskViewModel(@NonNull Application application) {
        super(application);
        mTasksRepository = new TasksRepository(application);
    }

    // TODO (7) Create a getter for the task variable


    public LiveData<TaskEntry> getTask(int taskId) {
        return mTasksRepository.loadTaskById(taskId);
    }

    public void insertTask(TaskEntry task) {
        mTasksRepository.insertTask(task);
    }

    public void updateTask(TaskEntry task) {
        mTasksRepository.updateTask(task);
    }
}
