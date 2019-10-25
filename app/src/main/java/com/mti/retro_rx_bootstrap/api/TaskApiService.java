/*
 * Created by Tareq Islam on 10/25/19 3:43 PM
 *
 *  Last modified 10/25/19 3:43 PM
 */

package com.mti.retro_rx_bootstrap.api;

import com.mti.retro_rx_bootstrap.ui.main.model.TaskResponse;

import io.reactivex.Flowable;
import retrofit2.http.GET;

/***
 * Created by mtita on 25,October,2019.
 */
public interface TaskApiService {

    @GET("api/v1/tasks")
    Flowable<TaskResponse> getAllTasks();
}
