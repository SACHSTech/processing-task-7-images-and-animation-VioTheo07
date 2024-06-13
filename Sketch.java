import processing.core.PApplet;
import processing.core.PImage;

/**
 * Sketching a simple animation
 * The sketch includes a background image, a bouncing dice image, a sinusoidal moving soccer ball image,
 * and a moving red circle 
 * 
 */
public class Sketch extends PApplet {
    // initializes images
    PImage imgBackground;
    PImage imgDice;
    PImage imgBall;

    // initialize screen size
    int intScreenW = 550;
    int intScreenH = 550;

    // initializes dice variables
    float fltDiceX;
    float fltDiceY;
    float fltDiceSpeedX = 2;
    float fltDiceSpeedY = 2;
    int intDiceSize = 200;

    // initializes ball variables
    float fltBallX;
    float fltBallY;
    float fltBallSpeedX = 2; // Horizontal speed
    float fltBallSpeedY = 0; // Vertical speed will be updated by the sine wave
    int intBallW = 150;
    int intBallH = 150;

    // initializes circle variables 
    float fltCircleX;
    float fltCircleY;
    float fltCircleSpeedX = 3;
    float fltCircleSpeedY = 3;
    int intCircleDiameter = 50;

    /**
     * Sets the size of the window.
     */
    public void settings() {
        size(intScreenW, intScreenH);
    }

    /**
     * Loads images and initializes their properties.
     */
    public void setup() {
        imgBackground = loadImage("ColorDesert.png");
        if (imgBackground == null) {
            System.out.println("Error loading background image.");
        } else {
            imgBackground.resize(intScreenW, intScreenH);
        }

        imgDice = loadImage("Dice.png");
        if (imgDice == null) {
            System.out.println("Error loading dice image.");
        } else {
            imgDice.resize(intDiceSize, intDiceSize);
        }

        imgBall = loadImage("SoccerBall.png");
        if (imgBall == null) {
            System.out.println("Error loading ball image.");
        } else {
            imgBall.resize(intBallW, intBallH);
        }

        fltBallX = 10;
        fltBallY = 200;
        fltCircleX = 25;
        fltCircleY = height - 25;  // Start from bottom left
    }

    /**
     * Draws the images and shapes, and updates their positions in the window.
     */
    public void draw() {
        image(imgBackground, 0, 0);
        
        // Draw and update the dice position
        image(imgDice, fltDiceX, fltDiceY);
        fltDiceX += fltDiceSpeedX;
        fltDiceY += fltDiceSpeedY;
        if (fltDiceX + intDiceSize > width) {
            fltDiceX = width - intDiceSize;
            fltDiceSpeedX *= -1;
        } else if (fltDiceX < 0) {
            fltDiceX = 0;
            fltDiceSpeedX *= -1;
        }
        if (fltDiceY + intDiceSize > height) {
            fltDiceY = height - intDiceSize;
            fltDiceSpeedY *= -1;
        } else if (fltDiceY < 0) {
            fltDiceY = 0;
            fltDiceSpeedY *= -1;
        }

        // Draw and update the ball position
        image(imgBall, fltBallX, fltBallY);
        fltBallX += fltBallSpeedX;
        fltBallY = 200 + 50 * (float) Math.sin(0.05 * fltBallX);
        if (fltBallX + intBallW > width) {
            fltBallX = width - intBallW;
            fltBallSpeedX *= -1;
        } else if (fltBallX < 0) {
            fltBallX = 0;
            fltBallSpeedX *= -1;
        }

        if (fltBallY + intBallH > height) {
            fltBallY = height - intBallH;
        } else if (fltBallY < 0) {
            fltBallY = 0;
        }

        // Draw and update the circle position
        stroke(0);
        fill(255, 0, 0);
        ellipse(fltCircleX, fltCircleY, intCircleDiameter, intCircleDiameter);
        fltCircleX += fltCircleSpeedX;
        fltCircleY -= fltCircleSpeedY;  // Move up and to the right
        if (fltCircleX + intCircleDiameter / 2 > width) {
            fltCircleX = width - intCircleDiameter / 2;
            fltCircleSpeedX *= -1;
        } else if (fltCircleX - intCircleDiameter / 2 < 0) {
            fltCircleX = intCircleDiameter / 2;
            fltCircleSpeedX *= -1;
        }
        if (fltCircleY + intCircleDiameter / 2 > height) {
            fltCircleY = height - intCircleDiameter / 2;
            fltCircleSpeedY *= -1;
        } else if (fltCircleY - intCircleDiameter / 2 < 0) {
            fltCircleY = intCircleDiameter / 2;
            fltCircleSpeedY *= -1;
        }
    }
}
