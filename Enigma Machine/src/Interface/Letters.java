package Interface;

import processing.core.*;

public class Letters extends PApplet{
	//class to create the letter objects, aka the keyboard
	PVector GridPos = new PVector();
	char Letter;
	public Boolean Light = false;
	public Letters(char letter, int number,int displayWidth,int displayHeight){
		//creates the letter object
		Letter = letter;
		int Dx = displayWidth;
		int Dy = displayHeight;
		int Dx11 = Dx/11;
		int Number = number;
    	int row = 1;
    	float ValX;
    	float ValY;
    	int position = Number;
		if (Number < 10) {//top row
			row = 1;
			position = Number;
			ValX = (float) ((position+1.0)*Dx11);
		} 
		else if (Number < 19) {//middle row
			row = 2;
			position = Number - 10;
			ValX = (float) ((position+1.5)*Dx11);
		}else {//bottom row
			row = 3;
			position = Number - 19;
			ValX = (float) ((position+2.0)*Dx11);
		}
		//if statment for the keyboard resolution. This is because when ran on 1080p or smaller the bottom row of the light board will be lost. Thus the scalling is reduced. For the best effect use either a 1080p or 1440p (ideal) monitor
		if (displayHeight == 1080) {
			ValY = Dy/3 + row*200;
			GridPos = new PVector(ValX, ValY);
		} else if (displayHeight == 1440) {
			ValY = Dy/2 + row*200;
			GridPos = new PVector(ValX, ValY);
		}
		else {
			ValY = Dy/3 + row*100;
			GridPos = new PVector(ValX, ValY);
		}
		
		
	}
	public PVector getGridPos() {
		return GridPos;
		
	}
	public char getLetter() {
		return Letter;
	}	
}
