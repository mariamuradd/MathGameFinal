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
 
     int bgColorR = 255; // red
     int bgColorG = 255; // green
     int bgColorB = 255; // blue
     
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

         // background will initialize with a random color everytime
         bgColorR = (int) main.random(50, 255);
         bgColorG = (int) main.random(50, 255);
         bgColorB = (int) main.random(50, 255);
         
         // starts with an initial question node
         QuestionNode initialQuestion = new QuestionNode(); // generates a question
         questionList.insertQuestion(initialQuestion);
         currentQuestion = questionList.getTail(); // sets current question to the head
     }
 
     // resets the game
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
 
         // display current question
         main.text("Solve: " + currentQuestion.getOperator1() + " " + currentQuestion.getOperator() + " " + currentQuestion.getOperator2() + " = ?",
                   main.width / 2, main.height / 2 - 50);
 
         main.textSize(20);
         main.text("Score: " + score, main.width / 2, main.height / 2 + 50);
         main.text("Your answer: " + userAnswer, main.width / 2, main.height / 2);
     }
 
     // handles key presses when entering the answer
     public void keyPressed() {
         if (gameOver) return;
 
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
         if (userAnswer.isEmpty()) return;
 
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
             } else {
                 gameOver = true;
             }
         } catch (Exception e) {
             gameOver = true;
             // this exception will only be handled if the answer is not a valid integer
         }
     }
 
     // checks if game is over
     public boolean isGameOver() {
         return gameOver;
     }
 
     // gets the current score of the user
     public int getScore() {
         return score;
     }
 }
