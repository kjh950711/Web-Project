package com.saltlux.intern.vo;

public class fileVO {
	
	private int id;
	private int level;
	private int type;
	private int subType;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getSubType() {
		return subType;
	}
	public void setSubType(int subType) {
		this.subType = subType;
	}
	
	@Override
	public String toString() {
		return "fileVO [id=" + id + ", level=" + level + ", type=" + type + ", subType=" + subType + "]";
	}
	
	
}
