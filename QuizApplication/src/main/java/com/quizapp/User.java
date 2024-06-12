package com.quizapp;

public class User {
	private String name;
	private int age;
	private String profession;

	public User(String name, int age, String profession) {
		this.name = name;
		this.age = age;
		this.profession = profession;
	}

	// Getters and setters
	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getProfession() {
		return profession;
	}

	public void incrementScore() {
		// TODO Auto-generated method stub
		
	}

	public String getScore() {
		// TODO Auto-generated method stub
		return null;
	}
}
