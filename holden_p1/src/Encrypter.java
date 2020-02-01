/*
 * Take int from main
 * Encrypt int by:
 * 		Adding each digit by 7
 * 		Taking remainder of each digit divided by 10
 * 		Replacing 1st digit with 3rd, 2nd digit with 4th and vice versa
 */

public class Encrypter {

	public String encrypt(String input) {
		String encryptedStr = "";
		int inputArr[] = new int[4];
		//Encrypt the numbers
		for(int i = 0; i < 4; i++) {
			inputArr[i] = input.charAt(i);
			inputArr[i] += 9;
			inputArr[i] %= 10;
		}
		//Swap digit locations
		encryptedStr += inputArr[2];
		encryptedStr += inputArr[3];
		encryptedStr += inputArr[0];
		encryptedStr += inputArr[1];
		
		return encryptedStr;
	}

}
