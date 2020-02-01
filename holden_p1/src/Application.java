/*
 * Read 4 digit integer from user
 * Encrypt the integer by calling encrypter
 * Print encrypted int
 * Take the encrypted int and call the decrypter
 * Print the decrypted int
 */
import java.util.Scanner;

public class Application {
	
	public static void main(String[] args) {
		Encrypter encrypter = new Encrypter();
		Decrypter decrypter = new Decrypter();
		
		String userStr = getUserStr();
		
		String encryptedStr = encrypter.encrypt(userStr);
		System.out.println("The encrypted int is: " + encryptedStr);
		
		String decryptedStr = decrypter.decrypt(encryptedStr);
		System.out.println("The decrypted int is: " + decryptedStr);
		
	}
	//Class used to take user input
	public static String getUserStr() {		
		Scanner input = new Scanner(System.in);
		String userinput = null;
		
		//Take user input
		System.out.print("Please input a four digit number: ");
		
		//Ensure the user is enter a four character string, and that every character is a number.
		while(true) {
			while (!input.hasNext("[0-9]+")) {
				System.out.print("Please enter a four digit number: ");
				input.next();
			}
			
			userinput = input.next();
			
			if(userinput.length() == 4) {
				input.close();
				break;
			}
		}
		
		return userinput;
		
	}

}
