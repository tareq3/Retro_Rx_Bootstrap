package com.mti.retro_rx_bootstrap.ui.main;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.mti.retro_rx_bootstrap.repository.TaskRepository;
import com.mti.retro_rx_bootstrap.ui.main.model.TaskItem;

import java.util.List;

public class TaskViewModel extends ViewModel {
    // TODO: Implement the ViewModel

    private TaskRepository mTaskRepository;



    public TaskViewModel(TaskRepository taskRepository) {
        mTaskRepository = taskRepository;
    }

    public  LiveData<List<TaskItem>> getListLiveData() {

        return mTaskRepository.getResultListMediatorLiveData();
    }

    public LiveData<String> getErrorLiveData(){
        return mTaskRepository.getErrorMediatorLiveData();
    }

    public void getAllTasks(){
        mTaskRepository.getAllTasks();
    }
}
