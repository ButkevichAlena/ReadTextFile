package DefaultPackage;
import java.io.*;


public class ReadText {
public static void main(String[] args) throws IOException{
    File file = new File(args[0]);
    
    BufferedReader f1 = new BufferedReader(new FileReader(file));
    int count = 0;
    while (f1.readLine() != null) count ++;
    String[] lines = new String[count];
    f1.close();
    
    BufferedReader f2 = new BufferedReader(new FileReader(file));
    for (int i = 0; i < count; i++ )lines[i] = f2.readLine();
    if (Integer.parseInt(args[1]) > count) System.out.println("Invalid input"); else {
    	if (Integer.parseInt(args[2]) > count) for (int i = Integer.parseInt(args[1]); i < count ; i++ )System.out.println(lines[i]); else {
    		for (int i = Integer.parseInt(args[1]); i < Integer.parseInt(args[2]) ; i++ ) System.out.println(lines[i]);
    	}
    }
    f2.close();
}
}
