package com.mathGameFinal;

import processing.core.PApplet;
import processing.core.PConstants;

public class GameScreen  {

    private int score;
    private boolean gameOver;
    private int num1, num2, correctAnswer;
    private String userAnswer;
    private boolean waitingForAnswer;
    PApplet main;

    public GameScreen(PApplet main_) {
        score = 0;
        gameOver = false;
        userAnswer = "";
        waitingForAnswer = true;
        main = main_;
    }

    // resets the game
    public void startNewGame() {
        score = 0;
        gameOver = false;
        generateNewProblem();
    }

    // generate a new math problems/equations
    private void generateNewProblem() {
        num1 = (int) main.random(1, 11); 
        num2 = (int) main.random(1, 11);
        correctAnswer = num1 + num2;
        userAnswer = ""; // clear previous answer 
        waitingForAnswer = true;
    }

    // displays game screen with current math problem & score
    public void display() {
        main.background(255); // clears screen

        if (gameOver) {
            main.fill(255, 0, 0); // red color for game over 
            main.textSize(32);
            main.textAlign(PConstants.CENTER, PConstants.CENTER);
            main.text("Game Over!", main.width / 2, main.height / 2 - 50);
            main.text("Your score: " + score, main.width / 2, main.height / 2);
        } else {
            main.fill(0); 
            main.textSize(32);
            main.textAlign(PConstants.CENTER, PConstants.CENTER);
            main.text("Solve: " + num1 + " + " + num2 + " = ?",main.width / 2, main.height / 2 - 50);

            main.textSize(20);
            main.text("Score: " + score, main.width / 2, main.height / 2 + 50);
            main.text("Your answer: " + userAnswer, main.width / 2, main.height / 2);
        }
    }

    // this method will handle all key presses when entering the answer
    public void keyPressed() {
        if (gameOver) return;

        if (main.key == PConstants.BACKSPACE && userAnswer.length() > 0) {
            userAnswer = userAnswer.substring(0, userAnswer.length() - 1); 
        } else if (main.key == PConstants.ENTER) {
            checkAnswer(); 
        } else if (Character.isDigit(main.key)) {
            userAnswer += main.key;
        }
    }

    // checks if user's answer is correct when they input the answer
    private void checkAnswer() {
        if (userAnswer.isEmpty()) return;


        if (Integer.parseInt(userAnswer) == correctAnswer) {
            score++;
            waitingForAnswer = false;
            generateNewProblem(); // generate new math problem/equation when they answer
        } else {
            gameOver = true;
        }
    }

    // checks is game is over
    public boolean isGameOver() {
        return gameOver;
    }

    // get current score of user after game ends
    public int getScore() {
        return score;
    }
}
