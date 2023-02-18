package com.appHub.enums;

public enum Degree {

	COMPUTER_SCIENCE(0,"Computer Science"),
	INFORMATION_SYSTEMS(1,"Information Systems");

	private String degree;
	private int index;
	
	Degree(int i, String degree) {
		this.setDegree(degree);
		this.setIndex(i);
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
	
	
}
