import biuoop.DrawSurface;
import biuoop.GUI;

import java.awt.*;
import java.util.Random;

public class AbstractArtDrawing {
    public void drawRandomLines() {
        final Line[] arr = new Line[Utils.arrayLineSize];
        //Random rand = new Random(); // create a random-number generator
        // Create a window with the title "Random Circles Example"
        // which is 400 pixels wide and 300 pixels high.
        GUI gui = new GUI("Random Lines Example", 400, 300);
        DrawSurface d = gui.getDrawSurface();
        for (int i = 0; i < Utils.arrayLineSize; ++i) {
            arr[i] = generateRandomLine();
            drawLine(arr[i],d);
            d.setColor(Color.BLUE);
            d.fillCircle((int)arr[i].middle().getX(),(int)arr[i].middle().getY(),Utils.blueCircleSize);
        }
        drawIntersectionPoint(arr, d);
        gui.show(d);
    }
    public void drawIntersectionPoint(Line[] arr, DrawSurface d) {
        for(int i = 0; i<arr.length; i++) {
            for(int j = 0; j<arr.length; j++) {
                if ( arr[i].isIntersecting(arr[j]) ) {
                    d.setColor(Color.RED);
                    Point temp = arr[i].intersectionWith(arr[j]);
                    d.fillCircle((int)temp.getX(),(int)temp.getY(),Utils.redCircleSize);
                }
            }
        }
    }
    public void drawLine(Line l, DrawSurface d) {
        d.setColor(Color.BLACK);
        d.drawLine((int)l.start().getX(),(int)l.start().getY(),(int)l.end().getX(),(int)l.end().getY());
    }
    public Line generateRandomLine() {
        Random rand = new Random(); // create a random-number generator
        int x1 = rand.nextInt(400) + 1; // get integer in range 1-400
        int y1 = rand.nextInt(300) + 1; // get integer in range 1-300
        int x2 = rand.nextInt(400) + 1; // get integer in range 1-400
        int y2 = rand.nextInt(300) + 1; // get integer in range 1-300
        return new Line(x1,y1,x2,y2);
    }

    public static void main(String[] args) {
        AbstractArtDrawing example = new AbstractArtDrawing();
        example.drawRandomLines();
    }
}
