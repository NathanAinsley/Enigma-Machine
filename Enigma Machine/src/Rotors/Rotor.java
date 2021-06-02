package Rotors;

public class Rotor {
	//base rotor class, the parent class of the children that each house their own rotor settings
	//creates the base methods used in alot of the rotor classes.
	public int[][] getwiring() {
		// returns the wiring of the rotor
		return null;
	}
	public int getPosition() {
		// returns the position of the rotor
		return 0;
	}
	public void incPosition() {
		// incraments the position of the rotor
	}
	public int getTurnover1() {
		// gets the turnover position of a rotor, the position it incraments the next rotor along
		return 0;
	}
	public int getTurnover2() {
		// gets the turnover position of a rotor, the position it incraments the next rotor along
		return 0;
	}
	public boolean getCanTurn() {
		// returns boolean on if the rotor is able to turn or not
		return false;
	}
	public void setCanTurn(boolean canTurn) {
		// Sets the boolean of if the rotor can turn or not
	}
}
