package com.mti.retro_rx_bootstrap.ui.main;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.Gson;
import com.mti.retro_rx_bootstrap.R;
import com.mti.retro_rx_bootstrap.ui.main.di.TaskInjection;
import com.mti.retro_rx_bootstrap.ui.main.model.TaskItem;

import java.util.List;

public class MainFragment extends Fragment {

    private TaskViewModel mViewModel;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this, TaskInjection.provideViewModelFactory(this.getContext())).get(TaskViewModel.class);
        // TODO: Use the ViewModel

       TextView textView= getView().findViewById(R.id.message);
        TextView textViewError= getView().findViewById(R.id.textViewError);

       mViewModel.getAllTasks();

       mViewModel.getResultListLiveData().observe(this, new Observer<List<TaskItem>>() {
           @Override
           public void onChanged(List<TaskItem> taskItems) {
               textView.setText(new Gson().toJson(taskItems));
           }
       });

       mViewModel.getErrorLiveData().observe(this, textViewError::setText);






    }

}
