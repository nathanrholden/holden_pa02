/*
 * Take the encrypted string as input
 * Use a loop to get each digit and convert it back into the original number
 * Reset the digits into their original places.
 */
public class Decrypter {

	public String decrypt(String input) {
		String decryptedStr = "";
		int inputArr[] = new int[4];
		
		for(int i = 0; i < 4; i++) {
			inputArr[i] = input.charAt(i);
			inputArr[i] += 5;
			inputArr[i] %= 10;
		}
		
		decryptedStr += inputArr[2];
		decryptedStr += inputArr[3];
		decryptedStr += inputArr[0];
		decryptedStr += inputArr[1];
		
		return decryptedStr;
	}

}
