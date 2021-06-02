package Interface;

import processing.core.PVector;

public class Notches {
	//class to create the notch indicator. The small box that shows what notch the rotor is on
	public PVector GridPos = new PVector();
	int ValX;
	int ValY;
	public int R;
	public int G;
	public int B;
	public String NotchText;
	boolean visable;
	public Notches(int number,int x,int y) {
		// notch objects, one for each of the 4 rotors
		int Number = number;
		switch(Number) {
		case 0:
			ValX = ((x/15)*10)+35;
			ValY = (y/8)+60;
			GridPos = new PVector(ValX,ValY);
			R = 255;
			G = 255;
			B = 255;
			NotchText = " ";
			visable=false;
			break;
		case 1:
			ValX = ((x/15)*8)+35;
			ValY = (y/8)+60;
			GridPos = new PVector(ValX,ValY);
			R = 255;
			G = 255;
			B = 255;
			NotchText = " ";
			visable=false;
			break;
		case 2:
			ValX = ((x/15)*6)+35;
			ValY = (y/8)+60;
			GridPos = new PVector(ValX,ValY);
			R = 255;
			G = 255;
			B = 255;
			NotchText = " ";
			visable=false;
			break;
		case 3:
			ValX = ((x/15)*4)+35;
			ValY = (y/8)+60;
			GridPos = new PVector(ValX,ValY);
			R = 255;
			G = 255;
			B = 255;
			NotchText = " ";
			visable=false;
			break;
		}	
	}
	public void setText(String text) {
		NotchText = text;
	}

}
