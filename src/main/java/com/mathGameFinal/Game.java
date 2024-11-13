/*
 * Name: Maria Murad
 * Class Name: Game
 * Date: November 26th, 2024
 * Description: This class manages the game’s flow, handling screen transitions, user input, and game state updates (start, game, end).
 */
package com.mathGameFinal;

import processing.core.PApplet;

public class Game {
    StartScreen startScreen;
    GameScreen gameScreen;
    EndScreen endScreen;
    int gameState; // 0 = start, 1 = game, 2 = end
    PApplet main;

    public Game(PApplet main_) {
        main = main_;
        startScreen = new StartScreen(main_);
        gameScreen = new GameScreen(main_);
        endScreen = new EndScreen(main_);
        gameState = 0;
    }

    public void setup(){
         startScreen.setup();
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
