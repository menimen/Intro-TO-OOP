/**
 * @author Meni Date 16.3.19 version 1.0
 */
public class Line {
    /**
     * describe line segments by two points from Point Class : starting point of
     * line segment and end point. represented by x and y coordinates respectively.
     */
    private Point start;
    private Point end;
    private boolean isVertical = false;

    /**
     * constructor to initialize current line start and end points with given points
     * as parameters.constructor to initialize current line start and end points
     * with given points as parameters.
     * @param p1 first point given as a parameter to assemble line segment.
     * @param p2 second point given as a parameter to assemble line segment.
     */
    public Line(Point p1, Point p2) {
        this(p1.getX(), p1.getY(), p2.getX(), p2.getY()); /*
         * send p1 and p2 to another constructor which deals with the
         * point's x and y coordinates
         */
    }

    /**
     * constructor method to initialize current line start and end points with given
     * points as parameters.
     * @param x1 x coordinate of first point given as a parameter.
     * @param y1 y coordinate of first point given as a parameter.
     * @param x2 x coordinate of second point given as a parameter.
     * @param y2 y coordinate of second point given as a parameter.
     */
    public Line(double x1, double y1, double x2, double y2) {
        /*
         * first i check which point given as a parameter has smaller x
         * coordinate. that way i use this point set the starting point of current line
         * instance.
         */
        if (x1 <= x2) {
            this.start = new Point(x1, y1);
            this.end = new Point(x2, y2);
        } else {
            this.start = new Point(x2, y2);
            this.end = new Point(x1, y1);
        }
        if(this.start.getX() == this.end().getX()) {
            isVertical = true;
        }
    }

    /**
     * getter method to get the slope of line segment according to line equation
     * logic. value from type double.
     * @return the slope of line. value from type double.
     */
    public double getSlope() {
        double deltaY = (this.start.getY() - this.end.getY());
        double deltaX = (this.start.getX() - this.end.getX());
        /*
         * check if the start and point of line don't have same x coordinate. if so we
         * can't perform line equation logic on the line because it doesn't have slope.
         */
            return deltaY / deltaX;
    }

    /**
     * getter method to get the intercept of line segment according to line equation
     * logic.
     * @return the intercept of line. value from type double.
     */
    public double getIntercept() {
        return start.getY() - this.getSlope() * start.getX();
    }

    /**
     * calculate the length of the line segment and return it to user.
     * @return length of line segment. length is from type double.
     */
    public double length() {

        return this.start.distance(this.end);
    }

    /**
     * return the middle point of line segment.
     * @return middle point. return type from type Point.
     */
    public Point middle() {
        double middleX = (this.start.getX() + this.end.getX()) / 2;
        double middleY = (this.start.getY() + this.end.getY()) / 2;
        return new Point(middleX, middleY); // return instance of Point.
    }

    /**
     * getter method to return the starting point of line segment.
     * @return the starting point of line segment.
     */
    public Point start() {
        return this.start;
    }

    /**
     * getter method to return the ending point of line segment.
     * @return the ending point of line segment.
     */
    public Point end() {
        return this.end;
    }

    /**
     * method which is used to handle specific end case where the user entered the
     * same point as start and point so basically its not a line but a single point.
     * @return true if starting point of line segment is equal to its ending point
     * and false otherwise.
     */
    public boolean isOneDot() {
        return (this.start().equals(this.end()));
    }

    /**
     * check whether current line instance intersects with other line instance given
     * as a parameter.
     * @param other other line instance.
     * @return true if the lines intersect and false otherwise.
     */
    public boolean isIntersecting(Line other) {
        if ((this.intersectionWith(other)) == null) {
            return false;
        }
        return true;
    }

    /**
     * this method returns the intersecting point of two lines or null if they
     * doesn't intersect.
     * @param other other line instance.
     * @return the intersecting point of two lines or null if they doesn't
     * intersect.
     */
    public Point intersectionWith(Line other) {
        if(this.equals(other) == true) {
            return null;
        }
        if(isVertical() == true) {
            return CalculateIntersectionwhenLineIsVertical(other);
        } else {
            return CalculateIntersectionwhenLineIsNotVertical(other);
        }
    }

    private Point CalculateIntersectionwhenLineIsVertical(Line other) {
        double x = 0;
        double y = 0;
        if(other.isVertical() == true) {
            if (other.start.getX() == this.start().getX()) {
                if (other.start().isBetweenDots(this.start(), this.end())) {
                    return other.start();
                } else if (other.end().isBetweenDots(this.start(), this.end())) {
                    return other.end();
                } else {
                    return null;
                }
            } else {
                return null;
            }
        } else {
                x = this.start().getX();
                y = other.getSlope() * x + other.getIntercept();
                Point temp  = new Point(x,y);
                if (temp.isBetweenDots(other.start(),other.end())) {
                    return temp;
                } else {
                    return null;
                }
            }
    }

    private Point CalculateIntersectionwhenLineIsNotVertical(Line other) {
        double x = 0;
        double y = 0;
        if(other.isVertical() == true) {
            x = other.start().getX();
            y = this.getSlope() * x + this.getIntercept();
            Point temp  = new Point(x,y);
            if (this.contains(temp)) {
                return temp;
            } else {
                return null;
            }
        } else {
            x = (this.getIntercept() - other.getIntercept()) / ((other.getSlope() - this.getSlope()));
            y = other.getSlope() * x + other.getIntercept();
            Point temp = new Point (x,y);
            if (other.contains(temp) && this.contains(temp)) {
                return temp;
            } else {
                return null;
            }
        }
    }

    /**
     * this method checks whether both lines are equal or not by comparing both
     * start and end points respectively.
     * @param other other line instance.
     * @return true if the lines are equal, false otherwise.
     */
    public boolean equals(Line other) {
        if ((this.start().equals(other.start())) && (this.end().equals(other.end()))) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * check if a point is in the current line instance borders.
     * @param other other Point instance.
     * @return true if the point is contained inside the line segment, false
     * otherwise.
     */
    public boolean contains(Point other) {
        /*
         * start by checking if the line is not vertical, that way the line has defined
         * slope and intercept and we can check at first stage if point satisfies the
         * line equation.
         */
        if (!this.isVertical()) {
            if (this.getSlope() * other.getX() + this.getIntercept() == other.getY()) {
                return (other.isBetweenDots(this.start(), this.end()));
            }
        }
            /*
             * final phase is to check if the point is in current line segment start and end
             * points.
             */
            return (other.isBetweenDots(this.start(), this.end()));
    }

    /**
     * check if the line is vertical.
     * @return true if the line is vertical, false otherwise.
     */
    public boolean isVertical() {
        return this.isVertical;
    }
}