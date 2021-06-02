package Interface;
import processing.core.*;

public class Buttons {//class to create the buttons in the interface
	//creates all the variables used for the button objects
	public PVector GridPos = new PVector();
	int ValX;
	int ValY;
	public int R;
	public int G;
	public int B;
	public String ButtonText;
	int TextHue;
	boolean Toggle;
	public Buttons(int number,int x,int y) {
		// creates the button objects, using a switch for the multiple different objects as each one is different.
		int Number = number;
		switch(Number) {
		case 0:
			ValX = (x/15)*12;
			ValY = (y/8);
			GridPos = new PVector(ValX,ValY);
			R = 255;
			G = 0;
			B = 0;
			TextHue = 0;
			ButtonText = "Lock Rotor Positions";
			Toggle = false;
			break;
		case 1:
			ValX = (x/15)*4;
			ValY = (y/8);
			GridPos = new PVector(ValX,ValY);
			R = 0;
			G = 0;
			B = 0;
			TextHue = 255;
			ButtonText = "Beta";
			Toggle = false;
			break;
		case 2:
			ValX = (x/15)*4;
			ValY = (y/8)-50;
			GridPos = new PVector(ValX,ValY);
			R = 0;
			G = 0;
			B = 0;
			TextHue = 255;
			ButtonText = "Gama";
			Toggle = false;
			break;
		case 3:
			ValX = (x/15)*2;
			ValY = (y/8);
			GridPos = new PVector(ValX,ValY);
			R = 0;
			G = 0;
			B = 0;
			TextHue = 255;
			ButtonText = "UKW-b";
			Toggle = false;
			break;
		case 4:
			ValX = (x/15)*2;
			ValY = (y/8)-50;
			GridPos = new PVector(ValX,ValY);
			R = 0;
			G = 0;
			B = 0;
			TextHue = 255;
			ButtonText = "UKW-c";
			Toggle = false;
			break;
		}
	}

}
