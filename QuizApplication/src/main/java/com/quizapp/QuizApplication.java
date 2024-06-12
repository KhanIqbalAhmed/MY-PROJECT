 package com.quizapp;
 
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class QuizApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String userName = scanner.nextLine();

        System.out.print("Enter your age: ");
        int userAge = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        List<Question> selectedQuestions = new ArrayList<>();

        if (userAge < 18) {
            // Questions for users under 18
            selectedQuestions.addAll(getEnvironmentalQuestions());
        } else {
            // Questions for users 18 and above
            selectedQuestions.addAll(getSpaceQuestions());
        }

        // Shuffle selected questions for random order
        Collections.shuffle(selectedQuestions);

        User user = new User(userName, userAge, ""); // Updated constructor

        // Quiz
        Quiz quiz = new Quiz(selectedQuestions, user, scanner);

        // Start the quiz
        try {
            quiz.start();
        } catch (Exception e) {
            System.out.println("An error occurred during the quiz: " + e.getMessage());
        } finally {
            // Close the scanner
            scanner.close();
        }
    }

    // Method to get environmental questions
    private static List<Question> getEnvironmentalQuestions() {
        List<Question> environmentalQuestions = new ArrayList<>();
        // Add environmental questions
        environmentalQuestions.add(new Question("What gas do plants absorb that is essential for photosynthesis?", new String[]{"Oxygen", "Carbon Dioxide", "Nitrogen", "Hydrogen"}, 1, "Environmental"));
        environmentalQuestions.add(new Question("Which of the following is a renewable energy source?", new String[]{"Coal", "Natural Gas", "Solar Power", "Nuclear Energy"}, 2, "Environmental"));
        // Add more environmental questions
        return environmentalQuestions;
    }

    // Method to get space-related questions
    private static List<Question> getSpaceQuestions() {
        List<Question> spaceQuestions = new ArrayList<>();
        // Add space-related questions
        spaceQuestions.add(new Question("Which planet is known as the 'Red Planet'?", new String[]{"Mercury", "Mars", "Venus", "Jupiter"}, 1, "Space"));
        spaceQuestions.add(new Question("What is the name of the largest moon of Jupiter?", new String[]{"Europa", "Ganymede", "Titan", "Callisto"}, 1, "Space"));
        // Add more space-related questions
        return spaceQuestions;
    }

    // Inner class to represent a question
    private static class Question {
        private String question;
        private String[] options;
        private int answerIndex;
        private String category;

        public Question(String question, String[] options, int answerIndex, String category) {
            this.question = question;
            this.options = options;
            this.answerIndex = answerIndex;
            this.category = category;
        }

        public String getQuestion() {
            return question;
        }

        public String[] getOptions() {
            return options;
        }

        public int getAnswerIndex() {
            return answerIndex;
        }

        public String getCategory() {
            return category;
        }
    }

    // Inner class to represent a user
    private static class User {
        private String name;
        private int age;
        private String category;

        public User(String name, int age, String category) {
            this.name = name;
            this.age = age;
            this.category = category;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public String getCategory() {
            return category;
        }
    }

    // Inner class to represent a quiz
    private static class Quiz {
        private List<Question> questions;
        private User user;
        private Scanner scanner;

        public Quiz(List<Question> questions, User user, Scanner scanner) {
            this.questions = questions;
            this.user = user;
            this.scanner = scanner;
        }

        public void start() {
            int score = 0;
            System.out.println("Welcome, " + user.getName() + "! Let's begin the quiz.");
            for (Question question : questions) {
                System.out.println("\nCategory: " + question.getCategory());
                System.out.println(question.getQuestion());
                String[] options = question.getOptions();
                for (int i = 0; i < options.length; i++) {
                    System.out.println((i + 1) + ". " + options[i]);
                }
                System.out.print("Your answer: ");
                String userAnswer = scanner.nextLine().trim().toLowerCase();
                int userChoice;
                try {
                    userChoice = Integer.parseInt(userAnswer);
                    if (userChoice < 1 || userChoice > options.length) {
                        throw new NumberFormatException();
                    }
                } catch (NumberFormatException e) {
                    userChoice = -1; // Invalid choice
                }
                if (userChoice == -1) {
                    // If user enters a textual option
                    for (int i = 0; i < options.length; i++) {
                        if (options[i].toLowerCase().equals(userAnswer)) {
                            userChoice = i + 1;
                            break;
                        }
                    }
                }
                if (userChoice == question.getAnswerIndex() + 1) {
                    System.out.println("Correct!");
                    score++;
                } else {
                    System.out.println("Incorrect.");
                }
            }
            System.out.println("\nQuiz completed!");
            System.out.println("Your score: " + score + " out of " + questions.size());
            System.out.println("have a  wonderful day");
        }
    }
}
