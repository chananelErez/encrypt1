import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class MenuDial {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int key=0;
		String [] eORd=FileOperators.GetForEnDE();
		if (eORd[0].charAt(0)=='E'){
			key=(int)(Math.random()*13)+1;
			FileOperators.writeFile(String.valueOf(key), "key", "C:/key.txt");
		}
		if (eORd[0].charAt(0)=='D'){
			key=-Integer.parseInt(eORd[1]);
		}
		
        String content=FileOperators.readFile(eORd[2], StandardCharsets.UTF_8);
        String cipher=EncryptorAlgo.caesar(content, key);
        String newPath=FileOperators.NameConvert(eORd[2], eORd[0]);
        
        FileOperators.writeFile(cipher, "Modified", newPath);
	}
}
