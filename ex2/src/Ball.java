import biuoop.*;

import java.awt.*;
import java.util.Random;

public class Ball {
    private Point center;
    private int radius;
    private Color color;
    private Velocity speed;
    private Rectangle border;
    // constructor
    public Ball(double centerX,double centerY, int r, java.awt.Color color) {
        this.center = new Point(centerX,centerY);
        this.radius = r;
        this.color = color;
        this.setVelocity(0,0);
        border = new Rectangle();
        border.setRectangle(0,0,Utils.screenWidth,Utils.screenHeight,Color.BLACK);
    }
    public Ball(double centerX,double centerY, int r, java.awt.Color color, Velocity speed) {
        this.center = new Point(centerX,centerY);
        this.radius = r;
        this.color = color;
        this.speed = speed;
        border = new Rectangle();
        border.setRectangle(0,0,Utils.screenWidth,Utils.screenHeight,Color.BLACK);
    }
    public Ball(double centerX,double centerY, int r, java.awt.Color color, Velocity speed, Rectangle frame) {
        this.center = new Point(centerX,centerY);
        this.radius = r;
        this.color = color;
        this.speed = speed;
        this.border = frame;
    }
    public void setFrame(Rectangle frame) {
        this.border = frame;
    }

    // accessors
    public int getX() {
        return (int)this.center.getX();
    }
    public int getY() {
        return  (int)this.center.getY();
    }
    public int getSize() {
        return this.radius;
    }
    public java.awt.Color getColor() {
        return this.color;
    }

    // draw the ball on the given DrawSurface
    public void drawOn(DrawSurface surface) {
        surface.fillCircle((int)this.center.getX(),(int)this.center.getY(),this.radius);
    }
    public void setVelocity(Velocity v) {
        this.speed = v;
    }
    public void setVelocity(double dx, double dy) {
        this.speed = new Velocity(dx,dy);
    }
    public Velocity getVelocity() {
        return this.speed;
    }

    public void moveOneStep() {

        if( this.getVelocity().getDx() > 0 && (this.center.getX() + this.radius + this.getVelocity().getDx()) >
                border.getLowerrightX()) {
            moveOneStepRight();
        }
        if(this.getVelocity().getDx() < 0 && ((this.center.getX()  - this.radius + this.getVelocity().getDx()) < border.getUpperleftX() )) {
            //this.setVelocity(this.getVelocity().getDx() * -1, this.getVelocity().getDy());
            moveOneStepLeft();
        }
        if(this.getVelocity().getDy() > 0 && ((this.center.getY() + radius + this.getVelocity().getDy()) > border.getLowerrightY()) ) {
            //this.setVelocity(this.getVelocity().getDx() , this.getVelocity().getDy() * -1);
            moveOneStepDown();
        }
        if(this.getVelocity().getDy() < 0 && (this.center.getY() - radius + this.getVelocity().getDy()) < border.getUpperleftY())  {
            //this.setVelocity(this.getVelocity().getDx() , this.getVelocity().getDy() * -1);
            moveOneStepUp();
        }
        this.center = this.getVelocity().applyToPoint(this.center);
    }

    private void moveOneStepDown() {
        this.center.setPoint(this.center.getX() + this.getVelocity().getDx() , border.getLowerrightY() - this.radius);
        this.setVelocity(this.getVelocity().getDx(), this.getVelocity().getDy() * -1);
    }

    private void moveOneStepUp() {
        this.center.setPoint(this.center.getX() + this.getVelocity().getDx() , border.getUpperleftY() + this.radius);
        this.setVelocity(this.getVelocity().getDx(), this.getVelocity().getDy() * -1);
    }

    private void moveOneStepLeft() {
        this.center.setPoint(border.getUpperleftX() + this.radius , this.center.getY() + this.getVelocity().getDy());
        this.setVelocity(this.getVelocity().getDx() * -1, this.getVelocity().getDy());
    }


    private void moveOneStepRight() {
            this.center.setPoint(border.getLowerrightX() - this.radius , this.center.getY() + this.getVelocity().getDy());
            this.setVelocity(this.getVelocity().getDx() * -1, this.getVelocity().getDy());
    }

    public static Ball generateRandomBall(int radius,Rectangle rec) {
        Random rand = new Random(); // create a random-number generator
        double x1 = rand.nextInt((int)rec.getLowerrightX()) + rec.getUpperleftX(); // get integer in range 1-200
        double y1 = rand.nextInt((int)rec.getLowerrightY()) + rec.getUpperleftY(); // get integer in range 1-200
        //int radius = rand.nextInt(Utils.MAXSPEED) + 1; // get integer in range 1-50
        double angle = rand.nextDouble() * 360;
        double speed = Utils.MAXSPEED - radius;
        return new Ball(x1,y1,radius,Color.BLUE,Velocity.fromAngleAndSpeed(angle,speed),rec);
    }
}