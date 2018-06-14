package com.example.android.todolist;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.example.android.todolist.database.AppDatabase;

// TODO (1) Make this class extend ViewModel ViewModelProvider.NewInstanceFactory
public class AddTaskViewModelFactory extends ViewModelProvider.NewInstanceFactory{

    // TODO (2) Add two member variables. One for the database and one for the mTaskId
    private TasksRepository mTasksRepository;
    private final int mTaskId;
    private Application mApplication;
    // TODO (3) Initialize the member variables in the constructor with the parameters received

    public AddTaskViewModelFactory(Application application, int taskId) {
        mTasksRepository = new TasksRepository(application);
        this.mTaskId = taskId;
        this.mApplication = application;
    }

    // TODO (4) Uncomment the following method
    // Note: This can be reused with minor modifications
    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        //noinspection unchecked
        return (T) new AddTaskViewModel(mApplication, mTaskId);
    }
}
