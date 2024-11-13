/*
 * Name: Maria Murad
 * Class Name: EndScreen
 * Date: November 26th, 2024
 * Description: This class displays the game over screen with the final score and a restart button.
 */
package com.mathGameFinal;

import processing.core.PApplet;
import processing.core.PConstants;

public class EndScreen extends GameController {
    private int finalScore;

     EndScreen(PApplet main_){
        super(main_);
     }
    // sets the final score to be displayed
    public void setFinalScore(int score) {
        this.finalScore = score;
    }

    // display the end screen with the final score and a restart button
    public void display() {
        main.background(255); 

        main.fill(0); // Black color for text
        main.textSize(32);
        main.textAlign(PConstants.CENTER, PConstants.CENTER);
        main.text("Game Over!", main.width / 2, main.height / 2 - 50);
        main.text("Final Score: " + finalScore, main.width / 2, main.height / 2);

        // draw Restart Button & properties
        main.fill(0, 255, 0);
        main.rect(main.width / 2 - 75, main.height / 2 + 50, 150, 50); 
        main.fill(0);
        main.textSize(20);
        main.text("Restart", main.width / 2, main.height / 2 + 75);
    }

    // checks if restart button is clicked + its coordinates
    public boolean isButtonClicked(int x, int y) {
        int buttonX1 = main.width / 2 - 75;
        int buttonY1 = main.height / 2 + 50;
        int buttonX2 = main.width / 2 + 75;
        int buttonY2 = main.height / 2 + 100;

        // check if the mouse click is within the button bounds
        return (x > buttonX1 && x < buttonX2 && y > buttonY1 && y < buttonY2);
    }
}
