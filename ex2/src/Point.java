/**
 * @author meni Date: 10.3.19 version 1.0
 */
public class Point {
    /**
     * describe point with x,y coordinates and its behavior. coordinates are
     * double.
     */
    private double x; // x coordinate of the point.
    private double y; // y coordinate of the point.

    /**
     * setter method to initialize x coordinate of point according to given
     * parameter.
     * @param otherX location of point in space according to X axis. set coordinate
     * of point according to given x.
     */
    public void setX(double otherX) {
        this.x = otherX;
    }

    /**
     * setter method to initialize y coordinate of point according to given
     * parameter.
     * @param otherY location of point in space according to Y axis. set coordinate
     * of point according to given y.
     */
    public void setY(double otherY) {
        this.y = otherY;
    }

    /**
     * constructor method to initialize x,y coordinate according to given
     * parameters.
     * @param otherX location of point in space according to X axis. set coordinate
     * of point according to given x.
     * @param otherY location of point in space according to Y axis. set coordinate
     * of point according to given y.
     */
    public Point(double otherX, double otherY) {
        this.setPoint(otherX, otherY);
    }

    /**
     * setter method to initialize x and y coordinates. of point according to x and
     * y coordinates of another point. uses setX method to initialize X and setY
     * method to initialize Y.
     * @param otherX location of point in space according to X axis. set coordinate
     * of point according to given x.
     * @param otherY location of point in space according to Y axis. set coordinate
     * of point according to given y.
     */
    public void setPoint(double otherX, double otherY) {
        this.setX(otherX);
        this.setY(otherY);
    }

    /**
     * getter method to return value of x coordinate.
     * @return x coordinate of current point. number of type double.
     */
    public double getX() {
        return this.x;
    }

    /**
     * getter method to return value of y coordinate.
     * @return y coordinate of current point. number of type double.
     */
    public double getY() {
        return this.y;
    }

    /**
     * this method compares between current point location and other point's
     * location in space.
     * @param other given Point instance.
     * @return true if current point is the same. location in space as the other
     * point instance and false otherwise.
     */
    public boolean equals(Point other) {
        if (other != null) {
            if (this.x == other.getX()) {
                if (this.y == other.getY()) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * check if the point's location in space is between the two points given as
     * parameters.
     * @param p1 given point instance.
     * @param p2 given point instance.
     * @return true if current point is between the two points given as a parameter
     * in Cartesian Axis system.
     */
    public boolean isBetweenDots(Point p1, Point p2) {
        if (this.isBetweenDotshelper(p1.getX(), p2.getX(), this.getX())) {
            return (this.isBetweenDotshelper(p1.getY(), p2.getY(), this.getY()));
        } else {
            return false;
        }
    }

    /**
     * helper method to isBetweenDots method. its access modifier is private because
     * its for internal use only.
     * @param num1 number of type double given as a parameter.
     * @param num2 number of type double given as a parameter.
     * @param curnum number of current point coordinate, x or y location.
     * @return true if "curnum" is between bigger than num1 and smaller than num2.
     */

    private boolean isBetweenDotshelper(double num1, double num2, double curnum) {
        if ((num1 > num2) && (curnum <= num1 && curnum >= num2)) {
            return true;
        } else {
            return (curnum >= num1 && curnum <= num2);
        }
    }

    /**
     * @param other other point's instance with its own x and y coordinates in
     * space.
     * @return the distance between current point and given point as a parameter.
     * the distance is from type double.
     */
    public double distance(Point other) {
        double distance = 0;
        distance = Math.sqrt(((this.x - other.getX()) * (this.x - other.getX()))
                + ((this.y - other.getY()) * (this.y - other.getY())));
        return distance;
    }
}
