package com.quizapp;

public class Question {
	private String question;
	private String[] options;
	private int correctOption;
	private String category;

	public Question(String question, String[] options, int correctOption, String category) {
		this.question = question;
		this.options = options;
		this.correctOption = correctOption;
		this.category = category;
	}

	// Getters
	public String getQuestion() {
		return question;
	}

	public String[] getOptions() {
		return options;
	}

	public int getCorrectOption() {
		return correctOption;
	}

	public String getCategory() {
		return category;
	}

	public boolean isCorrect(int answer) {
		return answer == correctOption;
	}
}
