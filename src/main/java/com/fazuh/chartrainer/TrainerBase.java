package com.fazuh.chartrainer;

import java.util.Random;

public class TrainerBase {
    private int attempts;
    private int correctAnswers;
    private int currentCombo;
    private int highestCombo;
    private int incorrectAnswers;
    private final int totalAttempts;
    public boolean isSession = true;
    public Random rand = new Random();


    TrainerBase(int attempts) {
        this.attempts = this.totalAttempts = attempts;
    }

    public void correctAnswer() {
        this.correctAnswers++;
        this.currentCombo++;

        if (this.currentCombo > this.highestCombo) {
            this.highestCombo = this.currentCombo;
        }
        if (this.currentCombo % 5 == 0) {
            Colour.printSuccess(this.currentCombo + " COMBO!");
        }
        this.update();
    }

    public void incorrectAnswer(String correctAnswer) {
        this.currentCombo = 0;
        this.incorrectAnswers++;
        Colour.printFail("The correct answer was " + correctAnswer);
        this.update();
    }

    private void update() {
        this.attempts--;
        if (attempts == 0) {
            this.endSession();
        }
    }

    private void endSession() {
        System.out.println();
        Colour.printInfo("Total attempts: " + this.totalAttempts);
        Colour.printInfo("Correct answers: " + this.correctAnswers);
        Colour.printInfo("Incorrect answers: " + this.incorrectAnswers);

        double accuracy = (double) this.correctAnswers / this.totalAttempts * 100;
        String formattedAccuracy = String.format("%.2f", accuracy);
        Colour.printInfo("Accuracy: " + formattedAccuracy + "%");
        System.out.println();

        this.isSession = false;
    }

    public char intToChar(int int_) {
        return (char) (int_ + 64);
    }

    public int generateQuestion() {
        return this.rand.nextInt(26) + 1;
    }
}
