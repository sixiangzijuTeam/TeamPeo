package com.yzc.print;

public class User {
	private String   name ;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User(String name) {
		super();
		this.name = name;
	}
	public User() {}

	@Override
	public String toString() {
		return "User [name=" + name + "]";
	}
	
	
	
}
