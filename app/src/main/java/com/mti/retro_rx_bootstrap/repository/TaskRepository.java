/*
 * Created by Tareq Islam on 10/25/19 3:53 PM
 *
 *  Last modified 10/25/19 3:53 PM
 */

package com.mti.retro_rx_bootstrap.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import androidx.lifecycle.MediatorLiveData;

import com.mti.retro_rx_bootstrap.api.TaskApiService;
import com.mti.retro_rx_bootstrap.ui.main.model.TaskItem;
import com.mti.retro_rx_bootstrap.ui.main.model.TaskResponse;

import java.util.List;

import io.reactivex.schedulers.Schedulers;

/***
 * Created by mtita on 25,October,2019.
 */
public class TaskRepository {
   private   TaskApiService mTaskApiService;


   private MediatorLiveData<TaskResponse> mTaskResponseMediatorLiveData= new MediatorLiveData<>();

    public TaskRepository(TaskApiService taskApiService) {
        mTaskApiService = taskApiService;

    }

//making api call and passing the result and error in two different stream
    public void getAllTasks(){
       final LiveData<TaskResponse> source= LiveDataReactiveStreams.fromPublisher( mTaskApiService.getAllTasks().subscribeOn(Schedulers.io()));

       mTaskResponseMediatorLiveData.addSource(source, taskResponse -> {
           mTaskResponseMediatorLiveData.setValue(taskResponse);
           mTaskResponseMediatorLiveData.removeSource(source);
       });
    }

    public LiveData<TaskResponse> getTaskResponseMediatorLiveData() {
        return mTaskResponseMediatorLiveData;
    }
}
