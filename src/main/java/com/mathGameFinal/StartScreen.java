package com.mathGameFinal;

import processing.core.PApplet;
import processing.core.PConstants;

public class StartScreen extends PApplet {

    // Coordinates for the Start button
    int buttonX, buttonY, buttonWidth, buttonHeight;
    PApplet main;

    public StartScreen(PApplet main_) {
        // Set the position and size of the Start button
        buttonX = 300; 
        buttonY = 400;
        buttonWidth = 200;
        buttonHeight = 50;
        main = main_;
    }

    // Display the start screen, including the title and start button
    public void display() {
     
            
            main.textAlign(3, 3);
            main.fill(0, 102, 204); // Blue color for the title
            main.textSize(32);
            main.text("Maria Masters Math", main.width / 2, main.height / 2 - 100); // Title
    
            main.fill(100); // light grey color for button rectangle
            main.rect(buttonX, buttonY, buttonWidth, buttonHeight);
    
            main.fill(255); // white color for start text
            main.textSize(20);
            // code : add bold
            text("Start", main.width / 2, main.height / 2);
    
       
    }


      // display start screen
      public void showStartScreen() {
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
        main.ellipse(main.width / 2 - 120, main.height / 2 - 100, 15, 15);
        main.ellipse(main.width / 2 + 120, main.height / 2 - 100, 15, 15);
        main.ellipse(main.width / 2 - 60, main.height / 2 - 150, 10, 10);
        main.ellipse(main.width / 2 + 60, main.height / 2 - 150, 10, 10);
        
        main.triangle(main.width / 2 - 100, main.height / 2 - 80, main.width / 2 - 90, main.height / 2 - 70, main.width / 2 - 110, main.height / 2 - 70);
        main.triangle(main.width / 2 + 100, main.height / 2 - 80, main.width / 2 + 110, main.height / 2 - 70, main.width / 2 + 90, main.height / 2 - 70);
    
        // draws start button rectangle
        main.fill(100);
        main.rect(buttonX, buttonY, buttonWidth, buttonHeight);
    
        main.fill(255);
        main.textSize(20);
        main.text("Start", buttonX + buttonWidth / 2, buttonY + buttonHeight / 2);
    }


    // checks is button is clicked so return true when it is inside the button's bounds
    public boolean isStartButtonClicked(int x, int y) {
        try {
             System.out.println("klicked");
            return x > buttonX && x < buttonX + buttonWidth && y > buttonY && y < buttonY + buttonHeight;
        } catch (Exception e) {
            // TODO: handle exception
        }
        return false;
    }
}
