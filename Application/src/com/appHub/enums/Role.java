package com.appHub.enums;

public enum Role {

	ADMIN(0,"ADMIN"),
	STUDENT(1,"STUDENT"),
	TUTOR(2,"TUTOR");

	private String role;
	private int i;
	
	Role(int i, String role) {
		this.setRole(role);
		this.setI(i);
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}
	
	
}
