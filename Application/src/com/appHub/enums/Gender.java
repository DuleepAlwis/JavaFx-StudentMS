package com.appHub.enums;

public enum Gender {

	MALE("Male"),
	FEMALE("Female");

	private String gender;

	Gender(String gender) {
		// TODO Auto-generated constructor stub
		this.setGender(gender);
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
}
