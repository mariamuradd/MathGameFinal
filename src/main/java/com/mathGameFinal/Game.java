/*
 * Name: Maria Murad
 * Class Name: Game
 * Date: November 26th, 2024
 * Description: This class manages the game’s flow, handling screen transitions, user input, and game state updates (start, game, end).
 */
package com.mathGameFinal;

import processing.core.PApplet;

public class Game {

    private GameController startScreen;
    private GameController gameScreen;
    private GameController endScreen;
    private int gameState; // 0 = start, 1 = game, 2 = end
    PApplet main; 

    //constructor
    public Game(PApplet main_) {

        main = main_;
        startScreen = new StartScreen(main_);
        gameScreen = new GameScreen(main_);
        endScreen = new EndScreen(main_);
        gameState = 0;
    }

    // setting up
    public void setup(){
         startScreen.setup();
         gameScreen.setup();
         endScreen.setup();
    }


    // method to display the appropriate screen based on the current game state
    public void display() {
        switch (gameState) {
            case 0: // start screen showing
                startScreen.display();
                break;
            case 1: // game screen showing 
                gameScreen.display();
                if (gameScreen.isGameOver()) {
                    gameState = 2;
                    endScreen.setFinalScore(gameScreen.getScore());
                }
                break;
            case 2: // end screen showing 
                endScreen.display();
                break;
        }

    }

    // method handles mouse clicks so when in start screen, click start button & when in end screen, check for restart button
    public void handleMouseClick(int mouseX, int mouseY) {
        if (gameState == 0 && startScreen.isButtonClicked(mouseX, mouseY)) {
            gameState = 1; 
            gameScreen.startNewGame(); // initializes game screen 
        } 
        else if (gameState == 2 && endScreen.isButtonClicked(mouseX, mouseY)) {
            gameState = 0; // resets to start
        }

    }

    // this handles all key inputs
    public void keyPressed(char key) { 
       if (gameState == 1){
        gameScreen.keyPressed();
       }

       
    }

}
