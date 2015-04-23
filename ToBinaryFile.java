import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class ToBinaryFile {
	public static void main(String[] args) throws IOException{
		Scanner scanner = new Scanner(new File(args[0]));
		FileOutputStream file = new FileOutputStream(new File(args[1]));
		
		ArrayList<Byte> bytes = new ArrayList<Byte>();
		int i = 0;
		
		while(scanner.hasNextLine())
		{
			while(++i < 1000 && scanner.hasNextLine())
			{
				for(Byte separatedByte:scanner.nextLine().getBytes())
				{
					bytes.add(separatedByte);
				}
				
				bytes.add((byte)10);
				
			}
			
			i = 0;
			
			for(byte separatedByte: bytes)
			{
				file.write(separatedByte);	
			}
							
			bytes.clear();
			
		}
		scanner.close();
	    file.close();

	}
}
