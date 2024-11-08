package com.mathGameFinal;

import processing.core.PApplet;

public class App extends PApplet {

    Game game;
    int gameState; // 0 = start, 1 = game, 2 = end
    int buttonX, buttonY, buttonWidth, buttonHeight; 

    public static void main(String[] args) {
        String[] processingArgs = {"App"};
        App mySketch = new App();
        PApplet.runSketch(processingArgs, mySketch);
        PApplet.main("com.mathGameFinal.App");
    }

    // sets canvas size
    public void settings() {
        size(800, 800); 
    }

    // initializes game
    public void setup() {
        background(255, 200, 255);
        gameState = 0; 
        buttonX = 300; 
        buttonY = 400;
        buttonWidth = 200;
        buttonHeight = 50;
        game = new Game(this); // initializes game
    }

    // draw() will always be called to update canvas
    public void draw() {
         // pink ish background color
         background(255, 200, 255);
        game.display();
    }

   
    // called whenever mouse is clicked
    public void mousePressed() {
         game.handleMouseClick(mouseX, mouseY);
    }

    //need to write keypressed 
    //in that method, call game.keypressed u need pass key

}
