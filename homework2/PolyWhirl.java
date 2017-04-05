/**
 * Homework 2 - PolyWhirl
 * Name: Beszalle
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

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

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
     // this.readAndGenerateShapes();
    }

    /**This section uses scanner to ask for the user to input the #of sides, and the x and y coordinates of
     * the shape.
     * @sideNum stores the number of sides, which is then tested with if statements to deterimine which
     * shape will be created
     * @xMid is the x coordinate of the shape.
     * @yMid is the y coordinate of the shape.
     * Once the number of sides is determined, a new shape is added to be drawn.
     * If the user inputs a number of sides that is too small or large, the user is told to choose a number
     * within the range 3-6.
    */
    public void readAndGenerateShapes() {
      Scanner scan = new Scanner (System.in);
      System.out.println("Please input the number of sides, the x value, and the y value (space in between each): ");
      int sideNum = scan.nextInt();
      int xMid = scan.nextInt();
      int yMid = scan.nextInt();

      if (sideNum==3) {
        this.triangles.add (new Triangle(xMid, yMid));
      }
      else if (sideNum==4) {
	this.squares.add (new Square(xMid, yMid));
      }
      else if(sideNum==5) {
	this.pentagons.add (new Pentagon(xMid, yMid));
      }
      else if(sideNum==6) {
	this.hexagons.add (new Hexagon(xMid, yMid));
      }
      else{
	System.out.println("Please input a number between 3 and 6 to get a shape");
      }
    }



/*This area was me trying to figure out how to take the input from a file in order to create shapes. The plan
 * was to make thre seperate lists, one containing the number of sides, one containing the x coordinate of 
 * the shape center, and one containing the y value of the shape center. I was able to get these three lists
 * formed, but in the end, could not get the numbers in the lists converted to ints and passed through the
 * shape constructor. So I went with plan B, which was to have the user manually enter the # of sides, and the
 * x and y values. That is the code above this section.
    try{

      System.out.print("Enter the file name with extension: ");
      Scanner input=new Scanner(System.in);
      File file = new File(input.nextLine());
      input = new Scanner(file);
      int count = 0;
     
      ArrayList<String> sides = new ArrayList<String>();
      ArrayList<String> xVal = new ArrayList<String>();
      ArrayList<String> yVal = new ArrayList<String>();

      while(input.hasNext()){
	sides.add(input.next());
        xVal.add(input.next());
	yVal.add(input.next());
      }

     /* for(int i = 0; i < sides.size(); i++) {
	 List<Integer> sidesInt = new ArrayList<Integer>();
	 sidesInt.add(Integer.parseint((String)str));
	 if(sidesInt==3){
           this.triangles.add(new Triangle(300, 125));
	 }
	 else{
           System.out.println(sides.get(i));
	 }
      }
      ----This is me trying to convert the sides list to a list of ints---

      List<Integer> sidesInt = new ArrayList<Integer>(sides.size());
        for(Object s : sides){
	  sidesInt.add(Integer.valueOf(s));
	 // int sInt = Integer.valueOf(s);
	  System.out.println(sidesInt);
        }  
      input.close();
    }
      catch (Exception ex){
      ex.printStackTrace();
    }
    -------end of attempt to read input from file-------
*/    

    public void drawShapes(Graphics g) {
      /*This section draws the shapes and background.
       * @param g is the graphics engine and does the drawing
       * Makes the shapes appear on the background.
       * Depending on which shape was selected to be drawn, the graphics engine will draw either a 
       * triangle, square, pentagon, or hexagon.
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
      }
      for (Hexagon h: this.hexagons){
	h.draw(g);
    }
    

   }
  }
 }



