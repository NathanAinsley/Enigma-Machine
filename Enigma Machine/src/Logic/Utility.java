package Logic;

public class Utility {//some utility methods
	//defining the alphabet and qwerty alphabet
	static String Qwerty 	= 	"qwertyuiopasdfghjklzxcvbnm";
	static String Alphabet = 	"abcdefghijklmnopqrstuvwxyz";

	public static int Alphabet_to_Qwerty(int num, char let) {//returns the index value of a letter in the Qwerty array
		if(num != -1 && let == 0) {
			char bubble = Alphabet.charAt(num);
			System.out.println("bubble "+bubble);
			int returnVal = Qwerty.indexOf(bubble);
			System.out.println("returnVal "+returnVal);
			return returnVal;
		}
		if (num ==0 && let != -1) {
			int returnVal = Qwerty.indexOf(let);
			return returnVal;
		}
		return 0;
	}
	public int Qwerty_to_Alphabet(int num, char let) {//returns the index value of a letter in the Alphabet array
		if(num != 0 && let == -1) {
			char bubble = Qwerty.charAt(num);
			int returnVal = Alphabet.indexOf(bubble);
			return returnVal;
		}
		if (num ==-1 && let != 0) {
			int returnVal = Alphabet.indexOf(let);
			return returnVal;
		}
		return 0;
	}
	public static char Number_To_Letter(int num) {//turns letter in the alphabet into a number 0-25
		return Alphabet.charAt(num);
	}
}
