/**
 * @(#)RainbowSquares.java
 * Main method for rainbow square generation
 *
 * @author Ben Myers <ben.myers@okstate.edu>
 * @version 2.00 2016/9/28
 */

import javax.swing.*;

public class RainbowSquares {

    /**
     * Kicks off the whole ordeal by requesting iterative/recursive and the seed, and then constructing a frame.
     * @param args the command line arguments -- unused
     */
    public static void main(String[] args)
    {
    	// Ask user for iterative/recursive/cancel
    	Object[] options = {"Iterative", "Recursive", "Cancel"};
		int n = JOptionPane.showOptionDialog(new JFrame(), "Which program structure would you like to use?", "Program Structure", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		int seed = -1;
		
		// If the user chosen to cancel, exit
		if(n == 2)
		{
			System.exit(0);
		}
		
		else // get a seed, which can be blank for a random seed
		{
			String seedString;
			
			do // keep querying user for a valid seed (or no seed) until user gives one
			{
				seedString = JOptionPane.showInputDialog(null, "Enter a positive integer seed. Leave blank for a random seed.");
			} while(!seedString.equals("") && !isValidSeed(seedString));
			
			if(!seedString.equals("")) // user chose a valid seed
			{
				seed = Integer.parseInt(seedString);	
			}
			
			new RainbowSquaresFrame(n, seed);
		}
    }
    
    /**
     * Confirms that s is a valid seed, ie a positive integer.
     * @param s string to check the seed validity of
     * @return true if s is a valid seed, otherwise false
     */
    public static boolean isValidSeed(String s)
    {
    	try
    	{
    		int n = Integer.parseInt(s);
    		return n >= 0;
    	} catch(Exception e)
    	{
    		return false;
    	}
    }
}
