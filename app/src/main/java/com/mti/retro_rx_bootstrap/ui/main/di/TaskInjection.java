/*
 * Created by Tareq Islam on 10/25/19 4:42 PM
 *
 *  Last modified 10/25/19 4:42 PM
 */

package com.mti.retro_rx_bootstrap.ui.main.di;

import android.content.Context;

import androidx.annotation.NonNull;

import com.mti.retro_rx_bootstrap.RootApplication;
import com.mti.retro_rx_bootstrap.api.TaskApiService;
import com.mti.retro_rx_bootstrap.repository.TaskRepository;
import com.mti.retro_rx_bootstrap.ui.main.TaskViewModelFactory;

/***
 * Created by mtita on 25,October,2019.
 */
public class TaskInjection {

    @NonNull
    private static TaskRepository provideTaskRepository(Context context){
        return new TaskRepository(RootApplication.getRetrofitInstance().create(TaskApiService.class));
    }

    @NonNull
    public static TaskViewModelFactory provideViewModelFactory(Context context){
        return new TaskViewModelFactory(provideTaskRepository(context));
    }
}
