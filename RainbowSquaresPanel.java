/**
 * @(#)RainbowSquaresPanel.java
 * The RainbowSquaresPanel is where all the square-generating magic happens.
 *
 * @author Ben Myers <ben.myers@okstate.edu>
 * @version 2.00 2016/9/28
 */

import java.util.Random;
import javax.swing.*;
import java.awt.*;


public class RainbowSquaresPanel extends JPanel
{
	// CONSTANTS
	private static final int ITERATIVE = 0;
	private static final int RECURSIVE = 1;
	
	// Stores information that will be useful for the square generation to know how big the squares should be
	RainbowSquaresFrame frame;
	Toolkit kit = Toolkit.getDefaultToolkit();
    Dimension screen = kit.getScreenSize();
    
    // Other important variables
    int structure; // 0 for iterative, 1 for recursive
    Random r = new Random(); // RNG
    int seed = -1; // stored mostly for displaying seed in title

	/**
	 * Constructs a RainbowSquaresPanel.
	 * @param fr the RainbowSquaresFrame hosting this panel
	 * @param n structure designator -- 0 for iterative, 1 for recursive
	 * @param s seed to use (-1 for random seed)
	 */
    public RainbowSquaresPanel(RainbowSquaresFrame fr, int n, int s)
    {
    	// The RainbowSquaresFrame has passed itself such that the panel can use its info. Nifty.
    	frame = fr;
    	String seedDescription = ""; // if the user chose a seed, this will be replaced to be used in frame title
    	if(s != -1) // user chose a seed
    	{
    		r = new Random(s);
    		seedDescription = ", Seed: " + s;
    	}
    	if(n == ITERATIVE)
    	{
    		frame.setTitle("Rainbow Squares: Iterative" + seedDescription);
    	}
    	else // recursive
    	{
    		frame.setTitle("Rainbow Squares: Recursive" + seedDescription);
    	}
    }
    
    /**
     * Called every time the window needs to be repainted.
     * Contains the option to paint using iteration or recursion -- whichever is not commented out.
     * @param g the graphics context
     */
    public void paintComponent(Graphics g)
    {
    	// Iterative
    	if(structure == ITERATIVE)
    	{
    		iterative(g, Math.min(frame.getWidth(), frame.getHeight()));
    		
    	}
    	else // Recursive -- structure should equal RECURSIVE
    	{
    		recursive(g, Math.min(frame.getWidth(), frame.getHeight()), 0);
    		frame.setTitle("Rainbow Squares: Recursive");
    	}
    }
    
    /**
     * Generates rainbow squares iteratively.
     * @param g the graphics context
     * @param s the side length of the largest square
     */
    public void iterative(Graphics g, int s)
    {
    	int side = s;
    	
    	// In iterative methods, we solve the problem using a loop
    	// 'i' will be the ordinal number of the current square (the current square is the i-th square)
    	// Each square's border is a pixel thick. Ergo, the required # of squares is s/2 (int division). Ergo, i goes to s/2.
    	for(int i = 0; i <= s/2; i++)
    	{
    		// Generates random color and sets the graphics context to that color
    		Color c = new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256));
    		g.setColor(c);
    		
    		// Here, i is used as the offset, to nudge the square 1px by 1px closer to the center than the square before it
    		g.drawRect(0+i, 0+i, side, side);
    		
    		// Side lengths shrink by 2 to account for the next, smaller square
    		side -= 2; 
    	}
    }
    
    /**
     * Generates rainbow squares recursively.
     * @param g the graphics context
     * @param s the side length of the current square
     * @param i the ordinal number of the current square -- the current square is the i-th one drawn
     */
    public void recursive(Graphics g, int s, int i)
    {
    	// Generates random color and sets the graphics context to that color
    	Color c = new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256));
    	g.setColor(c);
    	
    	// Here, i is used as the offset, to nudge the square 1px by 1px closer to the center than the square before it
    	g.drawRect(0+i, 0+i, s, s);
    	
    	// If the side length could be smaller, go smaller!
    	if(s > 1)
    	{
    		// Recursive functions call themselves to solve a smaller problem.
    		// This recursive square leads to the next, smaller square...
    			// ... drawn with the same graphics context
    			// ... with slightly smaller sides
    			// ... and with an incremented ordinal index
    		recursive(g, s - 2, i + 1);
    	}
    }
    
}
