package shapes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is inheriting BasicShape to draw a square.
  */

public class Square extends BasicShape {

  public Square(int x, int y) {
    super(x, y);
  }

  @Override
  public void draw(Graphics g) {
    // cast the Graphics instance to the 2d version.
    Graphics2D g2d = (Graphics2D) g;

    /*Lists to hold the x and y coordinates of the square.
     */
    List<Integer> xPoints = new ArrayList<Integer>();
    List<Integer> yPoints = new ArrayList<Integer>();

    // Create the x coordinates of the vertices of the square
    xPoints.add(this.x -100);
    xPoints.add(this.x +100);
    xPoints.add(this.x + 100);
    xPoints.add(this.x - 100);


    // Create the y coordinates of the three vertices of the square
    yPoints.add(this.y);
    yPoints.add(this.y);
    yPoints.add(this.y + 200);
    yPoints.add(this.y + 200);
   
    
    /*
     * Add each point to the Polygon p. Each x and y value in the lists index correspondent. This
     * means that the ith point is made of up the ith index of xPoints and the ith index of yPoints.
     * For example, the first point is at index 0 and can be made with xPoints.get(0) and
     * yPoints.get(0).
     */
    Polygon p = new Polygon();
    for (int i = 0; i < xPoints.size(); ++i) {
      p.addPoint(xPoints.get(i), yPoints.get(i));
    }

    /*
     * Sets the outline or stroke properties for the class.
     */
    // specify the color
    Color strokeColor = new Color(0, 0, 0, 0);
    // make the color the active one
    g2d.setColor(strokeColor);
    // set the stroke to have a width of 6.0f
    g2d.setStroke(new BasicStroke(6.0f));
    // draw the stroke outline of Polygon p
    g2d.draw(p);

    /*
     * Sets the internal or fill color of the polygon.
     */
    // creates instance for for the fill color.
    Color fillColor = new Color(106, 118, 193, 255);
    // sets the fill color to be the active color
    g2d.setColor(fillColor);
    // fills Polygon p with fillColor
    g2d.fill(p);
  }
}
