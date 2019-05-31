package com.luyang.pigbean;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class PigBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1440116337838641882L;
	
	@ApiModelProperty(value="id",example="1|2|3",required=true)
	private int id;
	@ApiModelProperty(value="名字",example="猪|你|它",required=false)
	private String name;
	@ApiModelProperty(value="名字",example="猪|你|它",required=false)
	private String name1;
	public String getName1() {
		return name1;
	}
	public void setName1(String name1) {
		this.name1 = name1;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "PigBean [id=" + id + ", name=" + name + "]";
	}
	
}
