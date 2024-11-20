/*
 * Name: Maria Murad
 * Class Name: Confetti
 * Date: November 26th, 2024
 * Description: This class handles the creation, movement, and fading of animated confetti particles, adding a celebratory effect to the game.
 */

package com.mathGameFinal;

import processing.core.PApplet;

public class Confetti {

    PApplet p; 
    float x, y; // position
    float vx, vy; // velocity
    float size;
    int c; 
    float angle; 
    float angularVelocity; 
    float alpha; 

    // constructor
    Confetti(PApplet p, float startX, float startY) {
        this.p = p;
        x = startX;
        y = startY;
        // random velocity
        vx = p.random(-2, 2); 
        vy = p.random(-7, -3); 
        size = p.random(5, 15); 
        c = p.color(p.random(255), p.random(255), p.random(255)); // randomizes color
        angle = p.random(PApplet.TWO_PI);
        angularVelocity = p.random((float)-0.1, (float)0.1);
        alpha = 255; 
    }

    // updates horizontal and vertical positions + rotation
    void update() {
        x += vx; 
        y += vy; 
        angle += angularVelocity;
        alpha -= 3; // gradually fades out
        if (alpha < 0)
            alpha = 0; 
    }

    // draws rectangle shaped confetti and adds fade effect using alpha
    void display() {
        p.pushMatrix();
        p.translate(x, y);
        p.rotate(angle);
        p.fill(p.red(c), p.green(c), p.blue(c), alpha); 
        p.noStroke();
        p.rectMode(PApplet.CENTER);
        p.rect(0, 0, size, size / 2); 
        p.popMatrix();
    }

    // removes if off the top or fully faded
    boolean isOffScreen() {
        return y < -size || alpha <= 0; 
    }
}
