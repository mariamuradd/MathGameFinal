/*
 * Name: Maria Murad
 * Class Name: GameScreen
 * Date: November 26th, 2024
 * Description: This class displays the main gameplay screen, manages user input for answers, checks answers, and updates the score and game state.
 */
package com.mathGameFinal;

import processing.core.PApplet;
import processing.core.PConstants;

public class GameScreen extends GameController {
    private int score;
    private boolean gameOver;
    private String userAnswer;
    private boolean waitingForAnswer;
    private QuestionLinkedList questionList;
    private QuestionNode currentQuestion; // current question node being displayed

    public GameScreen(PApplet main_) {
        super(main_);
        score = 0;
        gameOver = false;
        userAnswer = "";
        waitingForAnswer = true;
        questionList = new QuestionLinkedList();
        
        // this starts with an initial question node
        QuestionNode initialQuestion = new QuestionNode(); // generates a question
        questionList.insertQuestion(initialQuestion);
        currentQuestion = questionList.getTail(); // sets current question to the head
    }

    // this method is to reset the game
    public void startNewGame() {
        score = 0;
        gameOver = false;
        userAnswer = "";
        waitingForAnswer = true;

        // clears the linkedlist and adds a new initial question
        questionList = new QuestionLinkedList();
        QuestionNode initialQuestion = new QuestionNode();
        questionList.insertQuestion(initialQuestion);
        currentQuestion = questionList.getTail();
    }

    // displays game screen with the current question and score
    public void display() {
        // COLOR STUFF HERE
        main.background(255);// white screen

            main.fill(0);
            main.textSize(32);
            main.textAlign(PConstants.CENTER, PConstants.CENTER);

            // display current question
            main.text("Solve: " + currentQuestion.getOperator1() + " " + currentQuestion.getOperator() + " " + currentQuestion.getOperator2() + " = ?",
                      main.width / 2, main.height / 2 - 50);

            main.textSize(20);
            main.text("Score: " + score, main.width / 2, main.height / 2 + 50);
            main.text("Your answer: " + userAnswer, main.width / 2, main.height / 2);
        // }
    }

    // handle key presses when entering the answer
    public void keyPressed() {
        if (gameOver) return;

        if (main.key == PConstants.BACKSPACE && userAnswer.length() > 0) {
            userAnswer = userAnswer.substring(0, userAnswer.length() - 1);
        } else if (main.key == PConstants.ENTER) {
            checkAnswer();
        } 
        else {
            userAnswer += main.key;
        }
    }

    // check if the user's answer is correct
    // CHANGE BACKGROUND COLOR EVERYTIME U ANSWER A QUESTION
    private void checkAnswer() {
        if (userAnswer.isEmpty()) return;

        try {
            if (Integer.parseInt(userAnswer) == currentQuestion.getExpectedAnswer()) {
                score++;
                waitingForAnswer = false;
    
                // adds a new question node to the linked list tail
                QuestionNode newQuestion = new QuestionNode();
                questionList.insertQuestion(newQuestion);
    
                // moves to the next question
                currentQuestion = currentQuestion.getNext();
    
                // resets user input for the next question
                userAnswer = "";
                waitingForAnswer = true;
            } else {
                gameOver = true;
            }
        } catch (Exception e) {
            gameOver = true;
            // TODO: handle exception
        }

        
    }

    // Check if the game is over
    public boolean isGameOver() {
        return gameOver;
    }

    // Get the current score of the user
    public int getScore() {
        return score;
    }
}
