int rollNumber;
void setup()
{
	size(1024,768);
	background(0);
	noLoop();
}

void draw()
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

void mousePressed()
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

	void show()
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
