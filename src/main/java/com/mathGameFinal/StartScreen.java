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

    // coordinates for the start button & encapsulation
    private int buttonX, buttonY, buttonWidth, buttonHeight;
    private PImage startImage;

    public StartScreen(PApplet main_) {
        //sets the position and size of the Start button
        super(main_);
        buttonX = 300;
        buttonY = 400;
        buttonWidth = 220;
        buttonHeight = 70;
    }

    @Override
    public void setup() {
        startImage = main.loadImage("src/main/resources/cartoonPic.png");
    }

    // display start screen
    public void display() {
        main.textAlign(PConstants.CENTER, PConstants.CENTER);

        // all of my title properties and color
        main.fill(0, 102, 204);
        main.textSize(40);
        String title = "Maria Masters Math";
        float startX = main.width / 2 - main.textWidth(title) / 2;
        float offsetY = main.height / 2 - 100;

        // shadow effect
        main.fill(0, 0, 50, 100);
        for (int i = 0; i < title.length(); i++) {
            char letter = title.charAt(i);
            float offsetX = startX + i * 22 + PApplet.sin(i * 0.5f + main.millis() * 0.002f) * 5;
            float yVariation = PApplet.sin(i * 0.3f + main.millis() * 0.004f) * 3;
            main.text(letter, offsetX + 3, offsetY + yVariation + 3);
        }

        // variation when it comes to the title
        for (int i = 0; i < title.length(); i++) {
            char letter = title.charAt(i);
            float offsetX = startX + i * 22 + PApplet.sin(i * 0.5f + main.millis() * 0.002f) * 5;
            float yVariation = PApplet.sin(i * 0.3f + main.millis() * 0.004f) * 3;

            main.fill(0, 102 + (int)(main.random(-10, 10)), 204 + (int)(main.random(-10, 10)));
            main.text(letter, offsetX, offsetY + yVariation);
        }

        // all additional shapes drawn around title w effects
        main.fill(255, 150, 200);
        drawAnimatedShape(main.width / 2 - 150, main.height / 2 - 130, 15);
        drawAnimatedShape(main.width / 2 + 150, main.height / 2 - 130, 15);
        drawAnimatedShape(main.width / 2 - 100, main.height / 2 - 180, 10);
        drawAnimatedShape(main.width / 2 + 100, main.height / 2 - 180, 10);

        drawAnimatedTriangle(main.width / 2 - 100, main.height / 2 - 45, 20);
        drawAnimatedTriangle(main.width / 2 + 100, main.height / 2 - 45, 20);

        // start button
        main.fill(75, 0, 130);
        main.rect(buttonX, buttonY, buttonWidth, buttonHeight);

        
        main.fill(255, 150, 200);

    // adjust text size to fit 
    float maxTextSize = 30;
    main.textSize(maxTextSize);

    // calculate the width of the text 
    while (main.textWidth("Start") > buttonWidth - 10) {
        maxTextSize -= 1;
        main.textSize(maxTextSize);
    }

    // draws the start text centered within the button
    main.text("Start", buttonX + buttonWidth / 2, buttonY + buttonHeight / 2);
        
        // this will display the image
        if (startImage != null) {
            main.imageMode(PConstants.CENTER);
            main.image(startImage, 150, 600);
        }
    }

    // will animate shapes with same effect as title
    private void drawAnimatedShape(float x, float y, float size) {
        float xVariation = PApplet.sin(main.millis() * 0.002f + x * 0.1f) * 3;
        float yVariation = PApplet.cos(main.millis() * 0.002f + y * 0.1f) * 3;
        main.ellipse(x + xVariation, y + yVariation, size, size);
    }

    // triangle animations
    private void drawAnimatedTriangle(float x, float y, float size) {
        float xOffset = PApplet.sin(main.millis() * 0.002f + x * 0.1f) * 3;
        float yOffset = PApplet.cos(main.millis() * 0.002f + y * 0.1f) * 3;
        
        main.fill(255, 150 + (int)(main.random(-20, 20)), 200 + (int)(main.random(-20, 20)));
        main.triangle(x + xOffset, y + yOffset, x + size / 2 + xOffset, y - size + yOffset, x - size / 2 + xOffset, y - size + yOffset);
    }

    //checks is button is clicked so return true when it is inside the button's bounds
    @Override
    public boolean isButtonClicked(int x, int y) {
        try {
            return x > buttonX && x < buttonX + buttonWidth && y > buttonY && y < buttonY + buttonHeight;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}