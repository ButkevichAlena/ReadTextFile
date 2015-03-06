package DefaultPackage;
import java.io.*;
import java.util.*;


public class ReadText {
public static void main(String[] args) throws IOException{
    File file = new File(args[0]);
    
    BufferedReader f1 = new BufferedReader(new FileReader(file));
    int count = 0;
    while (f1.readLine() != null) count ++;
    String[] lines = new String[count];
    System.out.println(count);
    f1.close();
    
    BufferedReader f2 = new BufferedReader(new FileReader(file));
    for (int i = 0; i < count; i++ )lines[i] = f2.readLine();
    ArrayList<String> text = new ArrayList<String>();
    if (Integer.parseInt(args[1]) > count) System.out.println("Invalid input"); else {
    	if (Integer.parseInt(args[2]) > count) for (int i = Integer.parseInt(args[1]); i <= count ; i++ ){System.out.println(lines[i]);text.add(lines[i]);} else {
    		for (int i = Integer.parseInt(args[1]); i < Integer.parseInt(args[2]) ; i++ ){System.out.println(lines[i]); text.add(lines[i]);}		
    	}
    }
    f2.close();
    
    String[] Split = null;
    String[] Split1 = null;
    String[] Split2 = null; 
    String[] Split3 = null; 
    
    for(String line : text)
    {
    	Split = line.split(" - - "); 
    	Split1 = Split[1].split(" \""); 
    	Split2 = Split1[1].split("\""); 
    	Split3 = Split2[1].split(" "); 
    	
    	Line l = new Line(Split[0], Split1[0], Split2[0], Integer.valueOf(Split3[1]), Integer.valueOf( Split3[2]));

    	System.out.println (l.ip+ " " + l.timeAndData + "\"" + l.way + "\""+" "+ l.numberOfAnswer +" "+ l.bytes);
    }
       
    file = new File(args[3]);
    PrintWriter out = new PrintWriter(new BufferedWriter(
    		  new FileWriter(file)));

    for(String line : text) {out.print(line + '\n');};
    		  out.flush();
	}
}
