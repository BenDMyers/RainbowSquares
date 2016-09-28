/**
 * @(#)RainbowSquaresFrame.java
 * A RainbowSquaresFrame stores a RainbowSquaresPanel. How 'bout that!
 *
 * @author Ben Myers <ben.myers@okstate.edu>
 * @version 1.00 2016/1/29
 */

import javax.swing.*;
import java.awt.*;

public class RainbowSquaresFrame extends JFrame
{
	/**
	 * RainbowSquaresFrame constructor.
	 * @param n structure designator -- 0 for iterative, 1 for recursive
	 * @param s seed to use (-1 for random seed)
	 */
    public RainbowSquaresFrame(int n, int s)
    {
    	// Basic frame instantiation stuff
    	setTitle("Rainbow Squares");
    	Toolkit kit = Toolkit.getDefaultToolkit();
    	Dimension screen = kit.getScreenSize();
    	setSize(screen.width, screen.height);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
    	// Creates the RainbowSquaresPanel
    	add(new RainbowSquaresPanel(this, n, s));
    	
    	// Sets the Frame to visible for full effect
    	setVisible(true);
    }
    
    
}