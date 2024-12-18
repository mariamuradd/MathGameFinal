/*
 * Name: Maria Murad
 * Class Name: EndScreen
 * Date: November 26th, 2024
 * Description: This class displays the game over screen with the final score and a restart button.
 */
package com.mathGameFinal;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PFont;
import processing.core.PImage;

public class EndScreen extends GameController {

    private int finalScore;
    private PImage startImage;

     EndScreen(PApplet main_){
        super(main_);

     }

     @Override
    public void setup() {
        startImage = main.loadImage("src/main/resources/ClapClap.png");
    }


    // sets the final score to be displayed
    @Override
    public void setFinalScore(int score) {
        this.finalScore = score;
    }

    // display the end screen with the final score and a restart button

    public void display() {
        main.pushStyle();
        main.background(255, 200, 255); 

        main.fill(0); // black color for text
        main.textSize(32);
        PFont thickFont = main.createFont("Arial Black", 26); 
        main.textFont(thickFont);
        main.textAlign(PConstants.CENTER, PConstants.CENTER);
        main.text("Game Over!", main.width / 2, main.height / 2 - 50);
        main.text("Final Score: " + finalScore, main.width / 2, main.height / 2);


        // draw Restart Button & properties
        main.fill(0, 255, 0);
        main.rect(main.width / 2 - 100, main.height / 2 + 50, 220, 70); 
        main.fill(0);
        main.textSize(30);
        main.text("Restart", (main.width/2-100)+220/2, (main.height/2+50)+70/2);
        main.popStyle();


        // this will display the image
        if (startImage != null) {
            main.imageMode(PConstants.CENTER);
            main.image(startImage, 170, 640);
        }

    }


    // checks if restart button is clicked + its coordinates
    @Override
    public boolean isButtonClicked(int x, int y) {
        int buttonX1 = main.width / 2 - 75;
        int buttonY1 = main.height / 2 + 50;
        int buttonX2 = main.width / 2 + 75;
        int buttonY2 = main.height / 2 + 100;

        
        // check if the mouse click is within the button bounds
        return (x > buttonX1 && x < buttonX2 && y > buttonY1 && y < buttonY2);
    }

}
