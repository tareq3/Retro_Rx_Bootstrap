package com.mti.retro_rx_bootstrap.ui.main.model;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class TaskItem {

	@SerializedName("id")
	private int id;

	@SerializedName("value")
	private String value;

	@SerializedName("key")
	private String key;

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setValue(String value){
		this.value = value;
	}

	public String getValue(){
		return value;
	}

	public void setKey(String key){
		this.key = key;
	}

	public String getKey(){
		return key;
	}

	@Override
 	public String toString(){
		return 
			"TaskItem{" +
			"id = '" + id + '\'' + 
			",value = '" + value + '\'' + 
			",key = '" + key + '\'' + 
			"}";
		}
}