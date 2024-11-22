/*
 * Name: Maria Murad
 * Class Name: GameController
 * Date: November 26th, 2024
 * Description: This abstract class serves as a base for all game screens, providing a common structure and methods for rendering content, handling key inputs, and processing mouse click events.
 */
package com.mathGameFinal;

import processing.core.PApplet;
import processing.core.PConstants;

// abstract class to define a common structure for all screens
public abstract class GameController {
    
    protected PApplet main;

    // constructor
    public GameController(PApplet main_) {
        this.main = main_;
    }

    // abstract methods that subclasses need to implement
    public abstract void display(); 

    // optional method for handling key inputs
    public void keyPressed() {

    }

    // optional method for handling mouse click events
    public boolean isButtonClicked(int x, int y) {
        return false;
    }

    // optional method to check if game is over
    public boolean isGameOver(){

        return false;
    }

    // optional method to set final score
    public void setFinalScore(int score){

    }

    // optional setup method
    public void setup(){

    }

    // otpional method to get current score
    public int getScore(){
        return 0;
    }

    // optional method to start a new game
    public void startNewGame(){
        
    }

}
