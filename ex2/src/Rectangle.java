import java.awt.Color;
import biuoop.DrawSurface;
/**
 * class to represent rectangle with upper left and lower right points.
 * @author meni-pc
 */
public class Rectangle {
    private double upperleftX;
    private double upperleftY;
    private double lowerrightX;
    private double lowerrightY;
    private Color color;

    /**
     * default constructor to initialize rectangle by fixed size and points.
     * used for task 3.2.
     */
    public Rectangle() {
        this.upperleftX = 0;
        this.upperleftY = 0;
        this.lowerrightX = 600;
        this.lowerrightY = 600;
    }

    /**
     * constructor to initialize rectangle size by given input of upper left and lower right points.
     * @param upperleftx x coordinate of upper left point given as an argument.
     * @param upperlefty y coordinate of upper left point given as an argument.
     * @param lowerrightx x coordinate of lower right point given as an argument.
     * @param lowerrighty y coordinate of lower right point given as an argument.
     * @param otherColor color given as an argument.
     */
    public void setRectangle(double upperleftx, double upperlefty, double lowerrightx, double lowerrighty,
                             Color otherColor) {
        this.upperleftX = upperleftx;
        this.upperleftY = upperlefty;
        this.lowerrightX = lowerrightx;
        this.lowerrightY = lowerrighty;
        this.color = otherColor;
    }

    /**
     * getter method to return upper left point x coordinate.
     * @return upper left point x coordinate.
     */
    public double getUpperleftX() {
        return upperleftX;
    }
    /**
     * getter method to return upper left point y coordinate.
     * @return upper left point y coordinate.
     */
    public double getUpperleftY() {
        return upperleftY;
    }
    /**
     * getter method to return lower right point x coordinate.
     * @return upper lower right x coordinate.
     */
    public double getLowerrightX() {
        return lowerrightX;
    }

    /**
     * getter method to return lower right point y coordinate.
     * @return lower right point y coordinate.
     */
    public double getLowerrightY() {
        return lowerrightY;
    }

    /**
     * getter method to return the color of current instance.
     * @return color of rectangle.
     */
    public Color getColor() {
        return color;
    }

    /**
     * method to draw rectangle to the panel.
     * @param drawsurface instance of the panel on which the drawing is on.
     */
    public void drawRectangle(DrawSurface drawsurface) {
        drawsurface.setColor(this.color);
        int width = (int) (this.lowerrightX - this.upperleftX);
        int height = (int) (this.lowerrightY - this.upperleftY);
        drawsurface.fillRectangle((int) this.upperleftX, (int) this.upperleftY, width, height);
    }
}
