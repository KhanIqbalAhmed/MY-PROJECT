 package com.quizapp;

import java.util.List;
import java.util.Scanner;

public class Quiz {
    private List<Question> questions;
    private User user;
    private Scanner scanner;

    public Quiz(List<Question> questions, User user, Scanner scanner) {
        this.questions = questions;
        this.user = user;
        this.scanner = scanner;
    }

    public void start() {
        System.out.println("Welcome " + user.getName() + "!");

        // Ask questions based on age
        if (user.getAge() < 18) {
            System.out.println("You are under 18. Let's ask some environmental problems questions.");
            askEnvironmentalQuestions();
        } else {
            System.out.println("You are 18 or older. Let's ask some space-related questions.");
            askSpaceQuestions();
        }

        // Display user's score
        System.out.println("Quiz finished! Your score is: " + user.getScore());
        System.out.println("Thank you for playing, " + user.getName() + "! Have a wonderful day!");
    }

    private void askEnvironmentalQuestions() {
        for (Question question : questions) {
            if ("Environmental".equalsIgnoreCase(question.getCategory())) {
                askQuestion(question);
            }
        }
    }

    private void askSpaceQuestions() {
        for (Question question : questions) {
            if ("Space".equalsIgnoreCase(question.getCategory())) {
                askQuestion(question);
            }
        }
    }

    private void askQuestion(Question question) {
        System.out.println(question.getQuestion());
        String[] options = question.getOptions();
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }

        System.out.print("Your answer: ");
        int answer = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (question.isCorrect(answer - 1)) {
            System.out.println("Correct!");
            user.incrementScore(); // Increment score if answer is correct
        } else {
            System.out.println("Incorrect. The correct answer is: " + (question.getCorrectOption() + 1));
        }
    }
}
