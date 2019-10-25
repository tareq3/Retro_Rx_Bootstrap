package com.mti.retro_rx_bootstrap.ui.main.model;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class TaskResponse{

	@SerializedName("result")
	private List<TaskItem> result;

	@SerializedName("error")
	private String error;

	public void setResult(List<TaskItem> result){
		this.result = result;
	}

	public List<TaskItem> getResult(){
		return result;
	}

	public void setError(String error){
		this.error = error;
	}

	public String getError(){
		return error;
	}

	@Override
 	public String toString(){
		return 
			"TaskResponse{" + 
			"result = '" + result + '\'' + 
			",error = '" + error + '\'' + 
			"}";
		}
}