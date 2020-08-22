import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;

import java.awt.*;

public class MultipleFramesBouncingBallsAnimation {
    public static void main(String[] args) {
        /*GUI gui = new GUI("Balls Test 1", 400, 400);
        DrawSurface d = gui.getDrawSurface();

        Ball b1 = new Ball(100,100,30,java.awt.Color.RED);
        Ball b2 = new Ball(100,150,10,java.awt.Color.BLUE);
        Ball b3 = new Ball(80,249,50,java.awt.Color.GREEN);

        b1.drawOn(d);
        b2.drawOn(d);
        b3.drawOn(d);

        gui.show(d);
        GUI gui = new GUI("title",200,200);
        biuoop.Sleeper sleeper = new biuoop.Sleeper();
        java.util.Random rand = new java.util.Random();
        while (true) {
            DrawSurface d = gui.getDrawSurface();
            Ball ball = new Ball(rand.nextInt(200), rand.nextInt(200), 30, java.awt.Color.BLACK);
            ball.drawOn(d);
            gui.show(d);
            sleeper.sleepFor(50);  // wait for 50 milliseconds.*/
        GUI gui = new GUI("title", Utils.screenWidth, Utils.screenHeight);
        Rectangle yelloFrame = new Rectangle();
        yelloFrame.setRectangle(50,50,500,500,Color.yellow);

        Rectangle greyFrame = new Rectangle();
        greyFrame.setRectangle(450,450,600,600,Color.lightGray);
        Sleeper sleeper = new Sleeper();
        Ball[] ballArr = new Ball[args.length];
        for (int i = 0; i < args.length; i++) {
            if (i % 2 == 0) {
                ballArr[i] = Ball.generateRandomBall(Integer.parseInt(args[i]),yelloFrame);
            } else {
                ballArr[i] = Ball.generateRandomBall(Integer.parseInt(args[i]),greyFrame);
            }
        }


        //Ball ball = new Ball(0, 0, 30, java.awt.Color.BLACK);
        //ball.setVelocity(2, 2);
        while (true) {
            DrawSurface d = gui.getDrawSurface();
            yelloFrame.drawRectangle(d);
            greyFrame.drawRectangle(d);
            d.setColor(ballArr[0].getColor());
            for (int i = 0; i < args.length; i++) {
                ballArr[i].moveOneStep();
                ballArr[i].drawOn(d);
            }
            gui.show(d);
            sleeper.sleepFor(50);  // wait for 50 milliseconds.
        }
    }
}
