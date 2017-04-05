/**
 * Homework 2 - PolyWhirl
 * 
 * Due: Monday, April 3rd at 11:59pm. Follow the standard homework submission guidelines.
 * 
 * Grading: 70 points for correct completion of all tasks and 30 points for style, creativity, and
 * following instructions. Up to 10 points can be recovered if you successfully complete the bonus.
 * 
 * Tasks:
 * 
 * -Read in shape specifications that consist of 3 numbers: number of sides of the shape, the left
 * coordinate of the center in pixels, and the right coordinate of the center in pixels. There will
 * be one shape per line of input text via standard input.
 * 
 * -Make a list per shape to store instances of that shape.
 * 
 * -Read through each shape specification from the input and add a new instance of that shape to the
 * appropriate shape list. For example, the input of 3 100 100 would result in code like the
 * following in the readAndGenerateShapes method of the Surface class: this.tris.add(new Tri(100,
 * 100));
 * 
 * -Create a set of classes that extend BasicShape with the following number of sides: Tri - 3
 * sided, Quad - 4 sided, Pent - 5 sided, and Hex - 6 sided. Note that these shapes do not need to
 * be regular; each shape can have sides of non-uniform length (e.g. both squares and rectangles are
 * valid Quads.
 * 
 * -Pick a fill and stroke color for each class. Let your inner graphic designer or color theorist
 * shine through!
 * 
 * -Each shape should be ~50 pixels wide (i.e. all of the points should be roughly 25 pixels from
 * the center of the shape).
 * 
 * -Document the classes and methods you create.
 * 
 * -Document the functions that are declared after comments that contain TODO: document.
 * 
 * Bonus: Create an additional class that inherits BasicShape that can draw a regular shape with any
 * number of sides.
 */

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import shapes.*;

/**
 * The entry point for the PolyWhirl program. This class inherits JFrame and acts as a window in the
 * graphical user interface.
 * 
 * You do not need to edit this class for the assignment.
 */
public class PolyWhirl extends JFrame {

  public static final int WINDOW_WIDTH = 600;
  public static final int WINDOW_HEIGHT = 700;

  private Surface surface;

  public PolyWhirl() {
    initUI();
  }

  /**
   * Initializes the graphics window (a JFrame) and adds the drawing surface (a JPanel).
   */
  private void initUI() {
    this.surface = new Surface();
    setTitle("PolyWhirl");
    // set the resolution of the window to be glorious 720p
    setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    add(this.surface);
  }

  public static void main(String[] args) {

    EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        PolyWhirl polyWhirl = new PolyWhirl();
        //polyWhirl.drawShapes();
        polyWhirl.surface.readAndGenerateShapes();
        polyWhirl.setVisible(true);
      }
    });
  }

  /**
   * The Surface class inherits JPanel and acts as a drawing surface. It is the core of this program
   * and does the following:
   * 
   * -Reads input, creates appropriate instances of shapes, and adds them to the correct list via
   * the readAndGenerateShapes method.
   * 
   * -Manages the lists of shapes and is responsible for rendering them via the drawShapes method.
   * 
   * You are responsible for editing and adding capabilities to this class for the assignment.
   */
  /* This section keeps track of types of shapes using lists
   */
  class Surface extends JPanel {

    /**Creating shape lists for the shapes to be kept track of with.
     * There is one list for each type of shape.
     */	  
    List<Triangle> triangles;
    List<Square> squares;
    List<Pentagon> pentagons;
    List<Hexagon> hexagons;

    /**Initializing shape lists
     * @triangles, squares, pentagons, and hexagons, are the lists which the shapes are added to
     * to each of their respective shapes. Triangle, Square, Pentagon, and Hexagon are the classes
     * that the shapes are drawn from to form the list.
     * */
    public Surface() {
      triangles = new ArrayList<Triangle>();
      squares = new ArrayList<Square>();
      pentagons = new ArrayList<Pentagon>();
      hexagons = new ArrayList<Hexagon>();
    }

    @Override
    public void paintComponent(Graphics g) {
      super.paintComponent(g);
      this.drawShapes(g);
      this.readAndGenerateShapes();
    }

    public void readAndGenerateShapes() {
       /* This section creates the x and y coordinates of where the shapes will be.
	* The first number in the parenthesis is the x coordinate of the center of the shape
	* and the second number is the y coordinate of the shape center.
	* Creates the new shapes for the graphics engine to draw.
       */
      
      this.triangles.add(new Triangle(250, 125));
      this.triangles.add(new Triangle(300, 125));
      this.triangles.add(new Triangle(350, 125));
      this.triangles.add(new Triangle(275, 175));
      this.triangles.add(new Triangle(325, 175));
      this.triangles.add(new Triangle(300, 225));

      this.squares.add(new Square(250, 275));
      this.squares.add(new Square(300, 275));
      this.squares.add(new Square(350, 275));
      this.squares.add(new Square(250, 325));
      this.squares.add(new Square(300, 325));
      this.squares.add(new Square(350, 325));
      this.squares.add(new Square(250, 375));
      this.squares.add(new Square(300, 375));
      this.squares.add(new Square(350, 375));

      this.pentagons.add(new Pentagon(275,425));
      this.pentagons.add(new Pentagon(325,425));
      this.pentagons.add(new Pentagon(250,458));
      this.pentagons.add(new Pentagon(300,458));
      this.pentagons.add(new Pentagon(350,458));
      this.pentagons.add(new Pentagon(275,492));
      this.pentagons.add(new Pentagon(325,492));
      this.pentagons.add(new Pentagon(300,525));

      this.hexagons.add(new Hexagon(125,325));
      this.hexagons.add(new Hexagon(475,325));
      this.hexagons.add(new Hexagon(300,25));
      this.hexagons.add(new Hexagon(300,625));



	  
      //This is the end of the shape coordinate section.
    }

    public void drawShapes(Graphics g) {
      /*This section draws the shapes and background.
       * @param g is the graphics engine and does the drawing
       * Makes the shapes appear on the background.
      */
      ((Graphics2D) g).setColor(java.awt.Color.WHITE);
      ((Graphics2D) g).fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);

      for (Triangle t : this.triangles){
	t.draw(g);
    }
      for (Square s : this.squares){
	s.draw(g);
    }	      
      for (Pentagon p: this.pentagons){
	p.draw(g);
    
      for (Hexagon h: this.hexagons){
	h.draw(g);
    }
    }

  }
}
}

