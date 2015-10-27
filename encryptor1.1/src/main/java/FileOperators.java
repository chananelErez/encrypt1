import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileOperators {
	
	public static String [] GetForEnDE(){
		String key=null;
		String eORd;
		Character compere;
		String fileName;
		Scanner user_input=new Scanner(System.in);
		System.out.println("It is encryption algorithm please insert E for "
				+ "encryption and D for decryption ");
		eORd=user_input.next();
		compere=eORd.charAt(0);
		System.out.println("please insert the file source path ");
		fileName=user_input.next();
		if (compere=='D'){
			System.out.println("please insert the key: ");
			key=user_input.next();
		}
		String [] encryInf={eORd,key,fileName};
		user_input.close();
		return encryInf;
		
	}
	
	public static String NameConvert(String fileName,String eORd){
		String convertName="";
		for(int i=0;i<fileName.length();i++){
			if (fileName.charAt(i)=='.'){
				if(eORd.charAt(0)=='E'){
					convertName+="_encrypted.";
				}
				if(eORd.charAt(0)=='D'){
					convertName+="_decrypted.";
				}
				
			}
			else{
				convertName+=String.valueOf(fileName.charAt(i));
			}
			
		} 
		return convertName;
		
	}
	
	static String readFile(String path, Charset encoding) 
			  throws IOException 
			{
			  byte[] encoded = Files.readAllBytes(Paths.get(path));
			  return new String(encoded, encoding);
			}
	
	public static void writeFile(String content,String name,String path) {

		File file = new File(path);

		try (FileOutputStream fop = new FileOutputStream(file)) {

			// if file doesn't exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			// get the content in bytes
			byte[] contentInBytes = content.getBytes();

			fop.write(contentInBytes);
			fop.flush();
			fop.close();
			System.out.println("The "+name+" file "+"created in "+path);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	 
		
	

}
