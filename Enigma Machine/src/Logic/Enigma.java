package Logic;

import Rotors.Rotor;

public class Enigma {//class for doing all the encryption
	//create all the arrays to store the wiring
	int[][] rotor_1_wiring;
	int[][] rotor_2_wiring;
	int[][] rotor_3_wiring;
	int[][] rotor_4_wiring;
	int[][] reflector_wiring;
	//auto generated constructor
	public Enigma() {
	}

	public int run(int key, Rotor rotorA, Rotor rotorB, Rotor rotorC, Rotor reflector, Rotor rotorD, Wiring[] PlugboardWires) {
		//gets the key passed to the encryption process
		int CurrentKey = key;
		//Increments the rotors
		moveRotor(rotorA, rotorB, rotorC);
		//Through the plugboard for the first time
		CurrentKey = PlugboardRunThrough(CurrentKey, PlugboardWires);
		//Forward First Rotor
		CurrentKey = runRotor(rotorA, CurrentKey, true);
		//Forward Second Rotor
		CurrentKey = runRotor(rotorB, CurrentKey, true);
		//Forward Third Rotor
		CurrentKey = runRotor(rotorC, CurrentKey, true);
		//Forward 4th Rotor
		CurrentKey = runRotor(rotorD, CurrentKey, true);
		//Forward reflector
		CurrentKey = runRotor(reflector, CurrentKey, true);
		//Backwards 4th Rotor
		CurrentKey = runRotor(rotorD, CurrentKey, false);
		//Backwards Third Rotor
		CurrentKey = runRotor(rotorC, CurrentKey, false);
		//Backwards Second Rotor
		CurrentKey = runRotor(rotorB, CurrentKey, false);
		//Backwards First Rotor
		CurrentKey = runRotor(rotorA, CurrentKey, false);
		//Back through the plugboard
		CurrentKey = PlugboardRunThrough(CurrentKey, PlugboardWires);
		//returns the encrypted character to the GUI
		return CurrentKey;
	}
	
	private int runRotor(Rotor rotor, int CurrentKey, boolean forward) {//method to actually encrypt a character
		int[][]wiring = rotor.getwiring();//get the wiring of the rotor we are currently on
		if (forward) {//are we moving forward through the rotors
			//generates the manipulator, This is calculated by getting the current key + the position of the rotor MOD 26
			int manipulator = (CurrentKey + rotor.getPosition()) %26;
			//
			CurrentKey = (wiring[manipulator][1] - rotor.getPosition());//
			while (CurrentKey < 0) {
				CurrentKey = 26+CurrentKey;
			}
			CurrentKey = CurrentKey %26;
		}
		else {//or have we reached the reflector and now on our way back through all the rotors
			int Position = rotor.getPosition();
			CurrentKey = ArraySearch(wiring,CurrentKey,Position);
		}
		System.out.println("CurrentKeyOut: " + Utility.Number_To_Letter(CurrentKey));
		return CurrentKey;
		
	}
	
	private int PlugboardRunThrough(int CurrentKey, Wiring[] PlugboardWires) {//method to simulate the plugboard, aka switches the two letters that are connected
		for (int i = 0; i < PlugboardWires.length; i ++) {//goes through all the wires
			int ConnectionA = PlugboardWires[i].getConnectionA();//gets connectionA
			int ConnectionB = PlugboardWires[i].getConnectionB();//gets connectionB
			if (ConnectionA != -1 && ConnectionB != -1) {//are the connections valid
				if (CurrentKey == ConnectionA ) {//swaps the letters
					return ConnectionB;
				}
				else if (CurrentKey == ConnectionB) {
					return ConnectionA;
				}
			}
		}
		return CurrentKey;//returns the current key thus doing nothing if there is an issue
	}
	
	private int ArraySearch(int[][] array, int search, int Position) {//used to find the input from the output. When we go back through the rotors
			for (int row = 0; row < array.length; row ++) {//loops through the array
				if (array[row][1] == (search+Position)%26) {// validates if the array contains the search item
					int out = (array[row][0] - Position);
					while (out<0) {
						out = 26+out;
					}
					out = out %26;
					return out;
				}
		}
		return search;
	}
	
	private void moveRotor(Rotor rotorA, Rotor rotorB, Rotor rotorC) {//incraments the rotors
		rotorA.incPosition();//rotorA + 1
		if (rotorA.getPosition() == rotorA.getTurnover1()+1 || rotorA.getPosition() == rotorA.getTurnover2()) {//are we at the turnover position for rotor A
			rotorB.incPosition();//rotorB + 1
			if(rotorB.getPosition() == rotorB.getTurnover1()+1 || rotorB.getPosition() == rotorB.getTurnover2()) {//are we at the turnover position for rotor B
				rotorC.incPosition();//rotorC + 1
			}
		}
	}

}
