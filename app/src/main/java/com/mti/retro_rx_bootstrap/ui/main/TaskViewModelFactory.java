/*
 * Created by Tareq Islam on 10/25/19 5:39 PM
 *
 *  Last modified 10/25/19 5:39 PM
 */

package com.mti.retro_rx_bootstrap.ui.main;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.mti.retro_rx_bootstrap.repository.TaskRepository;

import java.lang.reflect.InvocationTargetException;

/***
 * Created by mtita on 25,October,2019.
 */
public class TaskViewModelFactory  implements ViewModelProvider.Factory {

    private TaskRepository mTaskRepository;

    public TaskViewModelFactory(TaskRepository taskRepository) {
        mTaskRepository = taskRepository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if(TaskViewModel.class.isAssignableFrom(modelClass)){
            try {
                return modelClass.getConstructor(TaskRepository.class).newInstance(mTaskRepository);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
        throw new IllegalArgumentException("Unknown ViewModel "+ modelClass);
    }

}
