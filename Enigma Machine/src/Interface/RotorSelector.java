package Interface;

import processing.core.PVector;

public class RotorSelector {//class to create the rotors that are dragged around the program
	public PVector GridPos = new PVector();
	int ValX;
	int ValY;
	public String RotorNumber;
	public int R = 138;
	public int G = 138;
	public int B = 138;
	public boolean move = false;
	public boolean moved;
	public RotorSelector(int number,int x,int y) {
		// rotor selector objects. The boxes that are used to select the rotors used. The ones that are dragged around and interacted with.
		int Number = number;
		switch(Number) {
		case 0:
			ValX = (x/15)*14;
			ValY = (y/20)*3;
			GridPos = new PVector(ValX,ValY);
			RotorNumber = "Rotor I";
			moved = false;
			break;
		case 1:
			ValX = (x/15)*14;
			ValY = (y/20)*4;
			GridPos = new PVector(ValX,ValY);
			RotorNumber = "Rotor II";
			moved = false;
			break;
		case 2:
			ValX = (x/15)*14;
			ValY = (y/20)*5;
			GridPos = new PVector(ValX,ValY);
			RotorNumber = "Rotor III";
			moved = false;
			break;
		case 3:
			ValX = (x/15)*14;
			ValY = (y/20)*6;
			GridPos = new PVector(ValX,ValY);
			RotorNumber = "Rotor IV";
			moved = false;
			break;
		case 4:
			ValX = (x/15)*14;
			ValY = (y/20)*7;
			GridPos = new PVector(ValX,ValY);
			RotorNumber = "Rotor V";
			moved = false;
			break;
		case 5:
			ValX = (x/15)*14;
			ValY = (y/20)*8;
			GridPos = new PVector(ValX,ValY);
			RotorNumber = "Rotor VI";
			moved = false;
			break;
		case 6:
			ValX = (x/15)*14;
			ValY = (y/20)*9;
			GridPos = new PVector(ValX,ValY);
			RotorNumber = "Rotor VII";
			moved = false;
			break;
		case 7:
			ValX = (x/15)*14;
			ValY = (y/20)*10;
			GridPos = new PVector(ValX,ValY);
			RotorNumber = "Rotor VIII";
			moved = false;
			break;
		}
	}
	public boolean click (int x, int y) {
		return move;
		
	}

}
