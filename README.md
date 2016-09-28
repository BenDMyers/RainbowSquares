# RainbowSquares
#### *A project created to demonstrate the structure of iterative and recursive code doing the same thing.*
 
 
The interesting code is located in [RainbowSquaresPanel.java](https://github.com/BenDMyers/RainbowSquares/blob/master/RainbowSquaresPanel.java), which generates concentric squares of random colors either iteratively or recursively. The `iterative()` method solves the problem using a for-loop

```
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
```

The `recursive()` method, however, solves the problem recursively by calling the `recursive()` method on a smaller subset of the problem. 

```
/**
 * Generates rainbow squares recursively.
 * @param g the graphics context
 * @param s the side length of the current square
 * @param i the ordinal number of the current square -- the current square is the i-th one drawn
 */
public void recursive(Graphics g, int s, int i)
{
  // Generates random color and sets the graphics context to that color
  Color c = new Color((int)(255*Math.random()), (int)(255*Math.random()), (int)(255*Math.random()));
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
```

Because computers have limited memory and limited time, we can't go infinitely far down the rabbit hole of recursion. We have to stop at some point. This point is the "base case": a problem so small, we already know the solution or how to handle it. In the `recursive()` method described above, the base case is when the side length (`s`) equals 1. At that point, we know the square in question is a pixel, and we can't go smaller.

The `iterative()` and `recursive()` methods will end up with the exact same result if they both use the same seed. To prove this, we allow the user to select the seed that the colors are randomly generated with. Tests of both iteration and recursion with seed *42* show the same thing:
* **Iterative, seed 42**:
![Iterative, seed 42](https://github.com/BenDMyers/RainbowSquares/blob/master/iterative42.PNG?raw=true "Iterative, seed 42")
* **Recursive, seed 42**:
![Recursive, seed 42](https://github.com/BenDMyers/RainbowSquares/blob/master/recursive42.PNG?raw=true "Recursive, seed 42")
