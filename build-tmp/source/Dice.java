import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Dice extends PApplet {

int rollNumber;
public void setup()
{
	size(1024,768);
	background(0);
	noLoop();
}

public void draw()
{
	background(0);
	rollNumber = 0;
	for(int diceY = 0; diceY < 769; diceY += 8)
	{
		for(int diceX = 0; diceX < 1025; diceX += 8)
		{
			Die theNewDice = new Die(diceX,diceY);
			theNewDice.show();
		}
	}
	fill(0,0,255);
	textAlign(CENTER);
	textSize(26);
	text("Total = " + rollNumber, 512, 384);
}

public void mousePressed()
{
	redraw();
}

class Die
{
	int dieX, dieY, numDots;
	Die(int x, int y)
	{
		numDots = (int)(Math.random()*6+1);
		dieX = x;
		dieY = y;
		rollNumber = rollNumber + numDots;
	}

	public void show()
	{
		fill(255);
		rect(dieX,dieY,8,8);
		if(numDots == 1)
		{
			fill(0);
			ellipse(dieX+4,dieY+4,1,1);
		}
		else if(numDots == 2)
		{
			fill(0);
			ellipse(dieX+2,dieY+2,1,1);
			ellipse(dieX+6,dieY+6,1,1);
		}
		else if(numDots == 3)
		{
			fill(0);
			ellipse(dieX+2,dieY+2,1,1);
			ellipse(dieX+4,dieY+4,1,1);
			ellipse(dieX+6,dieY+6,1,1);
		}
		else if(numDots == 4)
		{
			fill(0);
			ellipse(dieX+2,dieY+2,1,1);
			ellipse(dieX+6,dieY+2,1,1);
			ellipse(dieX+6,dieY+6,1,1);
			ellipse(dieX+2,dieY+6,1,1);
		}
		else if(numDots == 5)
		{
			fill(0);
			ellipse(dieX+2,dieY+2,1,1);
			ellipse(dieX+6,dieY+2,1,1);
			ellipse(dieX+6,dieY+6,1,1);
			ellipse(dieX+2,dieY+6,1,1);
			ellipse(dieX+4,dieY+4,1,1);
		}
		else if(numDots == 6)
		{
			fill(0);
			ellipse(dieX+2,dieY+2,1,1);
			ellipse(dieX+2,dieY+4,1,1);
			ellipse(dieX+2,dieY+6,1,1);
			ellipse(dieX+6,dieY+2,1,1);
			ellipse(dieX+6,dieY+4,1,1);
			ellipse(dieX+6,dieY+6,1,1);
		}
		
	}
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Dice" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
