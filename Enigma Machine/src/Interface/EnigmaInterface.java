package Interface;

import Logic.Enigma;
import Logic.Utility;
import Logic.Wiring;
import Rotors.Reflector_B;
import Rotors.Reflector_C;
import Rotors.Rotor;
import Rotors.Rotor_i;
import Rotors.Rotor_ii;
import Rotors.Rotor_iii;
import Rotors.Rotor_iv;
import Rotors.Rotor_v;
import Rotors.Rotor_vi;
import Rotors.Rotor_vii;
import Rotors.Rotor_viii;
import Rotors.Rotor_Beta;
import Rotors.Rotor_Gamma;
import processing.core.*;

public class EnigmaInterface extends PApplet{
	//Creating the alphabet variables and also the letters used in the GUI
	String LettersOrder 	= 	"QWERTYUIOPASDFGHJKLZXCVBNM";
	String LettersOrderLC 	= 	"qwertyuiopasdfghjklzxcvbnm";
	String Alphabet 		= 	"abcdefghijklmnopqrstuvwxyz";
	//Creates all the arrays needed within the program
	Letters[] letter = new Letters[26];
	RotorSpots[] slots = new RotorSpots[11];
	RotorSelector[] rotorselection = new RotorSelector[8];
	Wiring[] PlugboardWires = new Wiring[10];
	Buttons[] buttons = new Buttons[5];
	Notches[] notches = new Notches[4];
	
	//Variables used throughout the project
	char currentLetter;
	Boolean KeyIsPressed = false;
	Enigma enigmaLogic;
	Rotor RotorA;
	Rotor RotorB;
	Rotor RotorC;
	Rotor Reflector;
	Rotor RotorD;
	int LitKey;
	Boolean MovingRotor = false;
	int RotorNumber = -1;
	int itemsMoved = 0;
	int DW;
	int DH;
	
	// The argument passed to main must match the class name
    public static void main(String[] args) {
        PApplet.main("Interface.EnigmaInterface");
        
    }
    // method for setting the size of the window
    public void settings(){
    	fullScreen();
    	DW = displayWidth;
    	DH = displayHeight;
    	
    }
    public void setup() {
    	System.out.println(DW + " " + DH);
    	frameRate(30);
    	for(int i = 0; i<letter.length; i++) {
        	letter[i]=new Letters(LettersOrder.charAt(i),i,DW,DH);//creates a letter object for each of the letters in the alphabet
        }
    	for(int i = 0; i < (slots.length); i++) {
    		slots[i]=new RotorSpots(i,DW,DH);//creates a slot object for each of the rotor slots
    	}
    	for(int i = 0; i < (rotorselection.length); i++) {
    		rotorselection[i]=new RotorSelector(i,DW,DH);//creates a selection object for each of the rotors
    	}
    	for(int i = 0; i < buttons.length; i++) {
    		buttons[i]=new Buttons(i,DW,DH);//creates a button object for each of the buttons
    	}
    	for(int i = 0; i < notches.length; i++) {
    		notches[i]=new Notches(i,DW,DH);//Creates a notch object for each of the notches
    	}
		for(int i = 0; i < (PlugboardWires.length); i++) {
			PlugboardWires[i]=new Wiring();//creates an object for the wiring
    	}
		enigmaLogic = new Enigma();//creates a new enigma object
		//Hard wires some plugboard settings, hardcode was done due to time constraints on the project
		//PlugboardWires[0].setConnectionA(0);
		//PlugboardWires[0].setConnectionB(13);
		//PlugboardWires[1].setConnectionA(10);
		//PlugboardWires[1].setConnectionB(1);
    }
    
    public void draw() {
    	//Puts in a new background on layer 0
    	background(75,38,0);
    	KeyBoardVis();//Displays the Keyboard on layer 1
    	RotorVis();//Displays the Rotors on layer 2
    	ButtonsVis();//Displays the Buttons on layer 3
    	NotchVis();//Displays the Notches on layer 4
    	
    }
    
    public void mouseClicked() {
    	//when the mouse is clicked the following methods will be ran, each check where the mouse click occured
    	RotorMover();
    	ButtonClicker();
    	NotchClicker();
    }
    public void keyPressed() {//when a key is pressed
    	if (Alphabet.indexOf(key) != -1 && !KeyIsPressed) {//is the key that was pressed a letter and is a key already pressed?
    		int Key = Alphabet.indexOf(key);//get the letter that was pressed from the key value
    		int encryptedChar = enigmaLogic.run(Key, RotorA, RotorB, RotorC, Reflector, RotorD, PlugboardWires);//Pass this letter on to the encryption method
    		char NULL = 0;
    		encryptedChar = Utility.Alphabet_to_Qwerty(encryptedChar,NULL);//convert the encrypted character back into qwerty format from alphabet, as each one has a different number for each letter		
    		LitKey = encryptedChar;
    		letter[encryptedChar].Light = true;//lights the key that is returned from the encryption method by setting its Light value to true, changing the colour from white to yellow
    		KeyIsPressed = true;//Sets that a key is currently being pressed preventing this method from running again the key is released
    		NotchUpdater();//iterates the notches
    	}
    }
    
    public void keyReleased() {//when a key that was pressed is now released
    	if (LettersOrderLC.indexOf(key) != -1 ) {//is that key a letter
    		letter[LitKey].Light = false;//turns the light that was on off
    		KeyIsPressed = false;//sets it that no keys are currently being pressed
    	}
    }
   
    public void ButtonsVis() {//displays the buttons
    	for(int i = 0; i<buttons.length;i++) {//Iterates through the button objects
    		PVector GridPos = buttons[i].GridPos;//grabs the location that the buttons should be
    		String ButtonText = buttons[i].ButtonText;//grabs the text of the button
    		fill(buttons[i].R,buttons[i].G,buttons[i].B);//sets the buttons colour to the colour from the object
    		rect(GridPos.x,GridPos.y,100,50);//creates the rectangle for the button
    		textAlign(CENTER, CENTER);//sets the text to aligned to the centre
    	    textSize(10);//sets the text size
    	    fill(buttons[i].TextHue);//sets the colour of the text
    	    text(ButtonText, GridPos.x+50, GridPos.y+25);//sets the position of the text to be in the centre of the rectangle/button
    	}
    }
      
    public void KeyBoardVis(){//displays the keyboard    	
    	for(int i = 0; i<letter.length;i++) {//iterates through all the letters
    		PVector GridPos = letter[i].getGridPos();//gets the positions of the letter
    		currentLetter = letter[i].getLetter();//gets the textr for the letter
    		Boolean Light = letter[i].Light;//gets if the light of this letter should be on or off
    		int x = (int) GridPos.x;//gets the x position of the letter
    		int y = (int) GridPos.y;//gets the y position of the letter
    		if(Light == false) {//if the light is false then set it to be white
    			fill(255,255,255);
    		}else {//if the light is true then set it to be yellow
    			fill(255,255,0);
    		}
    		ellipse(x,y,80,80);//creating the circle for the light
    		textAlign(CENTER, CENTER);
    	    textSize(20);//sets text size
    		fill(0);//sets the text to be black
    	    text(currentLetter, x, y);//sets the text in the middle of the light
    	}
    }

    public void RotorVis() {//displays the rotors
    	for(int i=0; i< slots.length; i++) {//creates the slots for the rotors to socket into.
    		PVector GridPos = slots[i].GridPos;//gets the location of the socket 
    		fill(slots[i].R,slots[i].G,slots[i].B);//sets the colour of the socket
    		rect(GridPos.x,GridPos.y,100,50);//sets the location of the socket
    		textAlign(CENTER, CENTER);
    	    textSize(10);
    		if(slots[i].R==0 && slots[i].G==0 && slots[i].B==0 ) {//if the socket background is black then set the text to white
        		fill(255);
    		}
    		else {//if its any other colour then set it to black
        		fill(0);
    		}
    	    text(slots[i].SlotName, GridPos.x+50, GridPos.y+25);//places the sockets
    	}//closes socket creation
    	
    	for(int i=0; i< rotorselection.length; i++) {//creates the rotors that are movable
    		PVector GridPos = rotorselection[i].GridPos;//gets the location of the movable rotor 
    		strokeWeight(4);//sets the border to be thick
    		fill(rotorselection[i].R,rotorselection[i].G,rotorselection[i].B);//sets the colour of the rotor
    		if (rotorselection[i].move == true) {//if the rotor is currently moving then the position will follow the mouse
    			rect(mouseX-50,mouseY-25,100,50);
    			textAlign(CENTER, CENTER);
        	    textSize(10);
        		fill(0);
        	    text(rotorselection[i].RotorNumber, mouseX, mouseY);
    		}else {//if the rotor isnt moving then the position will be what it gets from the object
    			rect(GridPos.x,GridPos.y,100,50);
    			textAlign(CENTER, CENTER);
        	    textSize(10);
        		fill(0);
        	    text(rotorselection[i].RotorNumber, GridPos.x+50, GridPos.y+25);
    		}
    		
    	}	
    }
 
    public void NotchVis() {//displays the notches on the rotors
    	for(int i = 0; i<notches.length;i++) {//Iterates through all the notches
    		if(notches[i].visable == true) {//if the notches are visable
	    		PVector GridPos = notches[i].GridPos;//gets the notch position
	    		fill(notches[i].R,notches[i].G,notches[i].B);//sets the notch colour
	    		rect(GridPos.x,GridPos.y,30,20);//creates the notch rectangle
	    		textAlign(CENTER, CENTER);
	    	    textSize(10);
	    	    fill(0);
	    	    text(notches[i].NotchText, GridPos.x+15, GridPos.y+10);//sets the text in the rectangle
    		}
    	}
    }
    
 
    public void RotorMover() {//method for moving the rotors
    	for(int i=0; i< rotorselection.length; i++) {//iterates through all the available rotors
    		if(MovingRotor==false) {//is the user currently NOT moving a rotor
    			if (pointInBox(mouseX,mouseY,i)&&itemsMoved<3) {//is the mouse hovering over a rotor? and also has there been less than 3 rotors moved thus far?
    				rotorselection[i].move = true;//sets the rotor in question to be moving
    				RotorNumber = i;//saves the id of the rotor that is moving
    				MovingRotor=true;//sets that we are moving a rotor
    				}	
    			}
    		else {//if we are moving a rotor then we do this
    			if(pointInRotor(mouseX,mouseY,i)) {//is the mouse hovering over the location of a slot?
    				//sets the rotor box to the position of the slot
					rotorselection[RotorNumber].GridPos.x=slots[i].GridPos.x;
	    			rotorselection[RotorNumber].GridPos.y=slots[i].GridPos.y;
	    			rotorselection[RotorNumber].move = false;//sets that the rotor box is no longer moving
	    			MovingRotor=false;//no longer moving
	    			rotorselection[RotorNumber].moved = true;//sets that this rotor has been moved
	    			slots[i].occupied = true;//sets a slot to be occupied
	    			slots[i].occupant = RotorNumber;//sets the rotor number that is occupying the slot
	    			itemsMoved=itemsMoved+1;//increases the amount of items moved by 1
    			}
    		} 
    	}
    }
    			
    public boolean pointInBox(int x, int y, int i) {//method for checking if the mouse is hovering over a rotor
    	if (	x < rotorselection[i].GridPos.x +100 && 
				x > rotorselection[i].GridPos.x - 0 && 
				y < rotorselection[i].GridPos.y +50 && 
				y > rotorselection[i].GridPos.y - 0) {
    		if (rotorselection[i].moved==false) {
    			return true;
    		}
    		return false;
    	} else {
    		return false;
    	}
    }
    public boolean pointInRotor(int x, int y, int i) {//method for if the mouse is hovering over a slot
    	if (	x < slots[i].GridPos.x +100 && 
				x > slots[i].GridPos.x - 0 && 
				y < slots[i].GridPos.y +50 && 
				y > slots[i].GridPos.y - 0 &&
				slots[i].occupied==false) {
    		return true;
    	} else {
    		return false;
    	}
    }
    public boolean pointInButton(int x, int y, int i) {//method for if the mouse is hovering of a button
    	if (	x < buttons[i].GridPos.x +100 && 
				x > buttons[i].GridPos.x - 0 && 
				y < buttons[i].GridPos.y +50 && 
				y > buttons[i].GridPos.y - 0) {
    		return true;
    	} else {
    		return false;
    	}
    }
    public boolean pointInNotch(int x, int y, int i) {//method for is if the mouse is hovering over a notch
    	if (	x < notches[i].GridPos.x +30 && 
				x > notches[i].GridPos.x - 0 && 
				y < notches[i].GridPos.y +20 && 
				y > notches[i].GridPos.y - 0) {
    		return true;
    	} else {
    		return false;
    	}
    }

    public void NotchUpdater() {//sets the notch to the position of the rotor after a key has been pressed
    	for(int i = 0; i<notches.length;i++) {//iterates through all the notches
    		switch(i) {
    			case 0:
    				notches[i].NotchText=String.valueOf(Utility.Number_To_Letter(RotorA.getPosition()));
    	    		break;
    			case 1:
    				notches[i].NotchText=String.valueOf(Utility.Number_To_Letter(RotorB.getPosition()));
    	    		break;
    			case 2:
    				notches[i].NotchText=String.valueOf(Utility.Number_To_Letter(RotorC.getPosition()));
    	    		break;
    			case 3:
    				notches[i].NotchText=String.valueOf(Utility.Number_To_Letter(RotorD.getPosition()));
    	    		break;	
    		}
    	}
    }
    
    public void NotchSetter() {//method for setting the value of the notch for the first time 
    	for(int i = 0; i<notches.length;i++) {//iterates through all the notches
    		switch(i) {
    			case 0:
    				notches[i].NotchText=String.valueOf(Utility.Number_To_Letter(RotorA.getPosition()));
    	    		notches[i].visable=true;
    	    		break;
    			case 1:
    				notches[i].NotchText=String.valueOf(Utility.Number_To_Letter(RotorB.getPosition()));
    	    		notches[i].visable=true;
    	    		break;
    			case 2:
    				notches[i].NotchText=String.valueOf(Utility.Number_To_Letter(RotorC.getPosition()));
    	    		notches[i].visable=true;
    	    		break;
    			case 3:
    				notches[i].NotchText=String.valueOf(Utility.Number_To_Letter(RotorD.getPosition()));
    	    		notches[i].visable=true;
    	    		break;	
    		}
    	}
    }
    
    public void NotchClicker() {//method for when the notch is clicked
    	for(int i = 0; i<notches.length;i++) {
    		if(pointInNotch(mouseX,mouseY,i)) {
    			switch(i) {
    				case 0:
    					RotorA.incPosition();//iterates the position of rotor A
    					notches[i].setText(String.valueOf(Utility.Number_To_Letter(RotorA.getPosition())));
    					break;
    				case 1:
    					RotorB.incPosition();//iterates the position of rotor B
    					notches[i].NotchText=String.valueOf(Utility.Number_To_Letter(RotorB.getPosition()));
    					break;
    				case 2:
    					RotorC.incPosition();//iterates the position of rotor C
    					notches[i].NotchText=String.valueOf(Utility.Number_To_Letter(RotorC.getPosition()));
    					break;
    				case 3:
    					RotorD.incPosition();//iterates the position of rotor D
    					notches[i].NotchText=String.valueOf(Utility.Number_To_Letter(RotorD.getPosition()));
    					break;
    			}
    		}
    	}
    }
    
    public void ButtonClicker() {//method for when a button is pressed
    	//Rotor Lock button, If pressed it will lock the rotors and reflectors into position
    	if(pointInButton(mouseX,mouseY,0)) {
    		DragLock();
    		NavalLocked();
    		ReflectorLocked();
    		buttons[0].ButtonText="Rotors Locked";
    		NotchSetter();    		
    	}//close if statment
    	else if(pointInButton(mouseX,mouseY,1)) {//sets the Beta rotor as active
    		BetaPressed();
    	}//close if statment
    	else if(pointInButton(mouseX,mouseY,2)) {//sets the Gama rotor as active
    		GammaPressed();
    	}//close if statment
    	else if(pointInButton(mouseX,mouseY,3)) {//sets the b reflector as active
    		bPressed();
    	}//close if statment
    	else if(pointInButton(mouseX,mouseY,4)) {//sets the c reflector as active
    		cPressed();
    	}//close if statment
    }//close method
    
    public void DragLock() {//method for setting the rotors to the ones selected by the user by dragging the rotors in the GUI
    	for(int i=0; i<3; i++) {
			System.out.println(slots[i].occupant);
			int Occupant = slots[i].occupant;
			switch(i){
			case 0:
				switch(Occupant) {
				case 0:
					RotorA = new Rotor_i();
					break;
				case 1:
					RotorA = new Rotor_ii();
					break;
				case 2:
					RotorA = new Rotor_iii();
					break;
				case 3:
					RotorA = new Rotor_iv();
					break;
				case 4:
					RotorA = new Rotor_v();
					break;
				case 5:
					RotorA = new Rotor_vi();
					break;
				case 6:
					RotorA = new Rotor_vii();
					break;
				case 7:
					RotorA = new Rotor_viii();
					break;
				}//close nested switch
			case 1:
				switch(Occupant) {
				case 0:
					RotorB = new Rotor_i();
					break;
				case 1:
					RotorB = new Rotor_ii();
					break;
				case 2:
					RotorB = new Rotor_iii();
					break;
				case 3:
					RotorB = new Rotor_iv();
					break;
				case 4:
					RotorB = new Rotor_v();
					break;
				case 5:
					RotorB = new Rotor_vi();
					break;
				case 6:
					RotorB = new Rotor_vii();
					break;
				case 7:
					RotorB = new Rotor_viii();
					break;
				}//close nested switch
			case 2:
				switch(Occupant) {
				case 0:
					RotorC = new Rotor_i();
					break;
				case 1:
					RotorC = new Rotor_ii();
					break;
				case 2:
					RotorC = new Rotor_iii();
					break;
				case 3:
					RotorC = new Rotor_iv();
					break;
				case 4:
					RotorC = new Rotor_v();
					break;
				case 5:
					RotorC = new Rotor_vi();
					break;
				case 6:
					RotorC = new Rotor_vii();
					break;
				case 7:
					RotorC = new Rotor_viii();
					break;
				}//close nested switch
			}//close outer switch
		}//close for loop
    	
    }

    public void BetaPressed() {//if Beta is pressed then sets Beta to active and Gama to false
    	buttons[2].R=0;
    	buttons[2].G=0;
    	buttons[2].B=0;
    	buttons[2].Toggle=false;
    	buttons[1].R=0;
    	buttons[1].G=0;
    	buttons[1].B=255;
    	buttons[1].Toggle=true;
    	
    }
    public void GammaPressed() {//if Beta is pressed then sets Gama to active and Beta to false
    	buttons[2].R=0;
    	buttons[2].G=0;
    	buttons[2].B=255;
    	buttons[2].Toggle=true;
    	buttons[1].R=0;
    	buttons[1].G=0;
    	buttons[1].B=0;
    	buttons[1].Toggle=false;
    } 
    public void NavalLocked() {//locks the 4th rotors into place
    	if (buttons[2].Toggle == true) { 
    		RotorD = new Rotor_Gamma();
    		System.out.println("Gamma");
    	} else if (buttons[1].Toggle == true) {
    		RotorD = new Rotor_Beta();
    		System.out.println("Beta");
    	}
    }

    public void bPressed() {//if Beta is pressed then sets b to active and c to false
    	buttons[4].R=0;
    	buttons[4].G=0;
    	buttons[4].B=0;
    	buttons[4].Toggle=false;
    	buttons[3].R=0;
    	buttons[3].G=0;
    	buttons[3].B=255;
    	buttons[3].Toggle=true;
    }
    public void cPressed() {//if Beta is pressed then sets c to active and b to false
    	buttons[4].R=0;
    	buttons[4].G=0;
    	buttons[4].B=255;
    	buttons[4].Toggle=true;
    	buttons[3].R=0;
    	buttons[3].G=0;
    	buttons[3].B=0;
    	buttons[3].Toggle=false;
    }
    public void ReflectorLocked() {//locks the reflector into place
    	if (buttons[4].Toggle == true) { 
    		Reflector = new Reflector_C();
    	} else if (buttons[3].Toggle == true) {
    		Reflector = new Reflector_B();
    	}
    }
}

