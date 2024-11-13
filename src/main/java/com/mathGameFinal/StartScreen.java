/*
 * Name: Maria Murad
 * Class Name: StartScreen
 * Date: November 26th, 2024
 * Description: This class represents the start screen of the math game, displaying the title, decorative shapes, a start button, and an optional image.
 */
package com.mathGameFinal; 

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;


public class StartScreen extends GameController {

    // coordinates for the Start button
    int buttonX, buttonY, buttonWidth, buttonHeight;
    PImage startImage;

    public StartScreen(PApplet main_) {
        // sets the position and size of the Start button
        super(main_);       
        buttonX = 300; 
        buttonY = 400;
        buttonWidth = 200;
        buttonHeight = 50;
    }

    public void setup(){
        startImage = main.loadImage("src/main/resources/cartoonPic.png");
        
    }

      // display start screen
      public void display() {
        main.textAlign(PConstants.CENTER, PConstants.CENTER);
        
        // set initial properties for title color and text
        main.fill(0, 102, 204);
        main.textSize(40);
        String title = "Maria Masters Math";
        float startX = main.width / 2 - main.textWidth(title) / 2;
        float offsetY = main.height / 2 - 100;
    
        // this will help add a sort of 3D effect with shadow color
        main.fill(0, 0, 50, 100); 
        for (int i = 0; i < title.length(); i++) {
            char letter = title.charAt(i);
            float offsetX = startX + i * 22 + PApplet.sin(i * 0.5f + main.millis() * 0.002f) * 5;
            float yVariation = PApplet.sin(i * 0.3f + main.millis() * 0.004f) * 3;
            main.text(letter, offsetX + 3, offsetY + yVariation + 3);
        }
    
        // draws main title with color variations
        for (int i = 0; i < title.length(); i++) {
            char letter = title.charAt(i);
            float offsetX = startX + i * 22 + PApplet.sin(i * 0.5f + main.millis() * 0.002f) * 5;
            float yVariation = PApplet.sin(i * 0.3f + main.millis() * 0.004f) * 3;
    
            
            main.fill(0, 102 + (int)(main.random(-10, 10)), 204 + (int)(main.random(-10, 10))); 
            main.text(letter, offsetX, offsetY + yVariation);
            main.text(letter, offsetX + 1, offsetY + yVariation + 1);
        }
    
        // draws decorative shapes around the title
        main.fill(255, 150, 200);
        main.ellipse(main.width / 2 - 150, main.height / 2 - 130, 15, 15);
        main.ellipse(main.width / 2 + 150, main.height / 2 - 130, 15, 15);
        main.ellipse(main.width / 2 - 90, main.height / 2 - 180, 10, 10);
        main.ellipse(main.width / 2 + 90, main.height / 2 - 180, 10, 10);
        
        main.triangle(main.width / 2 - 100, main.height / 2 - 60, main.width / 2 - 90, main.height / 2 - 50, main.width / 2 - 110, main.height / 2 - 50);
        main.triangle(main.width / 2 + 100, main.height / 2 - 60, main.width / 2 + 110, main.height / 2 - 50, main.width / 2 + 90, main.height / 2 - 50);
    
        // draws start button rectangle
        main.fill(75, 0, 130); // dark purple
        main.rect(buttonX, buttonY, buttonWidth, buttonHeight);
    
        main.fill(255);
        main.textSize(20);
        main.text("Start", buttonX + buttonWidth / 2, buttonY + buttonHeight / 2);
        if (startImage != null) {
        main.imageMode(PConstants.CENTER);
        main.image(startImage, 150 , 600);
        }
    }


    // checks is button is clicked so return true when it is inside the button's bounds
    public boolean isButtonClicked(int x, int y) {
        try {
             System.out.println("klicked");
            return x > buttonX && x < buttonX + buttonWidth && y > buttonY && y < buttonY + buttonHeight;
        } catch (Exception e) {
            // TODO: handle exception
        }
        return false;
    }
}
