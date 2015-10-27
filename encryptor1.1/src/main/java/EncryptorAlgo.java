/*from http://www.dotnetperls.com/caesar-java*/
public class EncryptorAlgo {
	static String caesar(String value, int shift) {
		// Convert to char array.
		char[] buffer = value.toCharArray();

		// Loop over characters.
		for (int i = 0; i < buffer.length; i++) {

		    // Shift letter, moving back or forward 26 places if needed.
		    char letter = buffer[i];
		    int ascii_code=(int)(letter);
		    letter = (char) (ascii_code + shift);
		    /*if (letter > 'z') {
			letter = (char) (letter - 26);
		    } else if (letter < 'a') {
			letter = (char) (letter + 26);
		    }*/
		    buffer[i] = letter;
		}
		// Return final string.
		return new String(buffer);
	}
  
}
