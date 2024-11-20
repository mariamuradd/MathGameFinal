/*
 * Name: Maria Murad
 * Class Name: GameScreen
 * Date: November 26th, 2024
 * Description: This class displays the main gameplay screen, manages user input for answers, checks answers, and updates the score and game state.
 */

package com.mathGameFinal;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PFont;
import processing.core.PImage;

public class GameScreen extends GameController {

    private int bgColorR = 255; // red
    private int bgColorG = 255; // green
    private int bgColorB = 255; // blue
    private PImage startImage;

    private int score;
    private boolean gameOver;
    private String userAnswer;
    private boolean waitingForAnswer;
    private QuestionLinkedList questionList;
    private QuestionNode currentQuestion; // current question node being displayed
    ArrayList<Confetti> confettiList;
   boolean isshowConfetti = false;
   int confettiTimer = 0;
   int confettiDuration = 2000;
    public GameScreen(PApplet main_) {
        super(main_);
        score = 0;
        gameOver = false;
        userAnswer = "";
        waitingForAnswer = true;
        questionList = new QuestionLinkedList();

        // background will initialize with a random color everytime
        bgColorR = (int) main.random(50, 255);
        bgColorG = (int) main.random(50, 255);
        bgColorB = (int) main.random(50, 255);

        // starts with an initial question node
        QuestionNode initialQuestion = new QuestionNode(); // generates a question
        questionList.insertQuestion(initialQuestion);
        currentQuestion = questionList.getTail(); // sets current question to the head
    }

    @Override
    public void setup() {
        startImage = main.loadImage("src/main/resources/ThinkingImage.png");
        confettiList = new ArrayList<Confetti>();
    }

    // resets the game
    @Override
    public void startNewGame() {
        score = 0;
        gameOver = false;
        userAnswer = "";
        waitingForAnswer = true;

        // clears the linked list and adds a new initial question
        questionList = new QuestionLinkedList();
        QuestionNode initialQuestion = new QuestionNode();
        questionList.insertQuestion(initialQuestion);
        currentQuestion = questionList.getTail();
    }

    // displays the game screen with the current question and score
    public void display() {
        // sets the background to the current RGB color
        main.background(bgColorR, bgColorG, bgColorB);

        main.fill(0);
        main.textSize(32);
        main.textAlign(PConstants.CENTER, PConstants.CENTER);

        // define the texts
        String questionText = "Solve: " + currentQuestion.getOperator1() + " " + currentQuestion.getOperator() + " "
                + currentQuestion.getOperator2() + " = ?";
        String scoreText = "Score: " + score;
        String answerText = "Your answer: " + userAnswer;

        // define text positions
        float questionY = main.height / 2 - 100;
        float scoreY = main.height / 2 - 50;
        float answerY = main.height / 2 - 5;

        // calculate the rectangle dimensions
        float rectX = main.width / 2;
        float rectY = (questionY + answerY) / 2;
        float lineHeight = 32;
        float smallerLineHeight = 20;
        float verticalSpacing = 10;
        float additionalPadding = 20;

        float rectHeight = lineHeight + smallerLineHeight * 2 + verticalSpacing * 2 + additionalPadding * 2 + 20;
        float rectWidth = Math.max(
                main.textWidth(questionText),
                Math.max(main.textWidth(scoreText), main.textWidth(answerText))) + 60;

        // isolate rectangle settings
        main.pushStyle();
        main.rectMode(PConstants.CENTER);
        main.fill(255); // background color for the rectangle
        main.noStroke();
        main.rect(rectX, rectY, rectWidth, rectHeight);
        main.popStyle();

        // draws the texts'
        // loads thicker font
        main.pushStyle();
        PFont thickFont = main.createFont("Arial Black", 26);
        main.textFont(thickFont);
        main.fill(0);
        main.text(questionText, main.width / 2, questionY);
        main.textSize(20);
        main.text(scoreText, main.width / 2, scoreY);
        main.text(answerText, main.width / 2, answerY);
        main.popStyle();

        // this will display the image
        if (startImage != null) {
            main.imageMode(PConstants.CENTER);
            main.image(startImage, 150, 680);
        }

        if(isshowConfetti){
            showConfetti();
        }
        if(main.millis()-confettiTimer>=confettiDuration){
            isshowConfetti=false;
        }

    }

    // will display confetti
    public void showConfetti() {
        main.pushStyle();
        if (main.frameCount % 10 == 0) {
            for (int i = 0; i < 20; i++) {
                confettiList.add(new Confetti(main, main.random(main.width), main.height));
            }
        }

        for (int i = confettiList.size() - 1; i >= 0; i--) {
            Confetti c = confettiList.get(i);
            c.update();
            c.display();
            if (c.isOffScreen()) {
                confettiList.remove(i);
            }
        }
        main.popStyle();
    }

    // handles key presses when entering the answer
    @Override
    public void keyPressed() {
        if (gameOver)
            return;

        if (main.key == PConstants.BACKSPACE && userAnswer.length() > 0) {
            userAnswer = userAnswer.substring(0, userAnswer.length() - 1);
        } else if (main.key == PConstants.ENTER) {
            checkAnswer();
        } else {
            userAnswer += main.key;
        }
    }

    // checks if user answer is correct then will change background to a new random color & move to the next question
    private void checkAnswer() {
        if (userAnswer.isEmpty())
            return;

        try {
            if (Integer.parseInt(userAnswer) == currentQuestion.getExpectedAnswer()) {
                score++;
                waitingForAnswer = false;

                // changes background color to a random new color
                bgColorR = (int) main.random(50, 255);
                bgColorG = (int) main.random(50, 255);
                bgColorB = (int) main.random(50, 255);

                // adds a new question node to the linkedlist
                QuestionNode newQuestion = new QuestionNode();
                questionList.insertQuestion(newQuestion);

                // moves ot the next question
                currentQuestion = currentQuestion.getNext();

                // resets user input for the next question
                userAnswer = "";
                waitingForAnswer = true;

                // confetti will be displayed when answer is correct
                isshowConfetti=true;
                confettiTimer=main.millis();
            } else {
                gameOver = true;
            }
        } catch (Exception e) {
            gameOver = true;
            // this exception will only be handled if the answer is not a valid integer
        }
    }

    // checks if game is over
    @Override
    public boolean isGameOver() {
        return gameOver;
    }

    // gets the current score of the user
    @Override
    public int getScore() {
        return score;
    }
}
