package Logic;

public class Wiring {//class for the wiring
	int ConnectionA;
	int ConnectionB;
	public Wiring() {
		// creates a wiring object that wont work, this is the default as -1 represents not plugged in. The user would have to plug the plugs in for the plugs to work.
		ConnectionA = -1;
		ConnectionB = -1;
		
	}
	//methods for getting and setting the connections.
	public int getConnectionA() {
		return ConnectionA;
	}
	public int getConnectionB() {
		return ConnectionB;
	}
	public void setConnectionA(int input) {
		ConnectionA = input;
	}
	public void setConnectionB(int input) {
		ConnectionB = input;
	}

}
