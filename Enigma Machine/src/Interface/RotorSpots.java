package Interface;
import processing.core.*;

public class RotorSpots {//class to create the rotor spots aka the slots that the rotors slot into
	
	public PVector GridPos = new PVector();
	int ValX;
	int ValY;
	public String SlotName;
	public int R = 0;
	public int G = 0;
	public int B = 0;

	public boolean occupied;
	public int occupant;
	public RotorSpots(int number,int x,int y) {
		// Rotor spots object, the sockets that the selectors slot into
		int Number = number;
		switch(Number) {
		case 0:
			ValX = (x/15)*10;
			ValY = (y/8);
			GridPos = new PVector(ValX,ValY);
			SlotName = "Rotor Slot 1";
			occupied = false;
			occupant = -1;
			break;
		case 1:
			ValX = (x/15)*8;
			ValY = (y/8);
			GridPos = new PVector(ValX,ValY);
			SlotName = "Rotor Slot 2";
			occupied = false;
			occupant = -1;
			break;
		case 2:
			ValX = (x/15)*6;
			ValY = (y/8);
			GridPos = new PVector(ValX,ValY);
			SlotName = "Rotor Slot 3";
			occupied = false;
			occupant = -1;
			break;
		case 3:
			ValX = (x/15)*14;
			ValY = (y/20)*3;
			GridPos = new PVector(ValX,ValY);
			SlotName = "Rotor I";
			occupied = true;
			occupant = 1;
			break;
		case 4:
			ValX = (x/15)*14;
			ValY = (y/20)*4;
			GridPos = new PVector(ValX,ValY);
			SlotName = "Rotor II";
			occupied = true;
			occupant = 2;
			break;
		case 5:
			ValX = (x/15)*14;
			ValY = (y/20)*5;
			GridPos = new PVector(ValX,ValY);
			SlotName = "Rotor III";
			occupied = true;
			occupant = 3;
			break;
		case 6:
			ValX = (x/15)*14;
			ValY = (y/20)*6;
			GridPos = new PVector(ValX,ValY);
			SlotName = "Rotor IV";
			occupied = true;
			occupant = 4;
			break;
		case 7:
			ValX = (x/15)*14;
			ValY = (y/20)*7;
			GridPos = new PVector(ValX,ValY);
			SlotName = "Rotor V";
			occupied = true;
			occupant = 5;
			break;
		case 8:
			ValX = (x/15)*14;
			ValY = (y/20)*8;
			GridPos = new PVector(ValX,ValY);
			SlotName = "Rotor VI";
			occupied = true;
			occupant = 6;
			break;
		case 9:
			ValX = (x/15)*14;
			ValY = (y/20)*9;
			GridPos = new PVector(ValX,ValY);
			SlotName = "Rotor VII";
			occupied = true;
			occupant = 7;
			break;
		case 10:
			ValX = (x/15)*14;
			ValY = (y/20)*10;
			GridPos = new PVector(ValX,ValY);
			SlotName = "Rotor VIII";
			occupied = true;
			occupant = 8;
			break;
		}
	}

}
