package DefaultPackage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.io.PrintWriter;


public class Writer {
	
	public void Write(String fileName, ArrayList<Line> list)
	{
	try{
		File file = new File(fileName);
		PrintWriter out = new PrintWriter(new BufferedWriter(
    		  new FileWriter(file)));
		
		for(Line line: list)
		out.print(line.toString() + '\n');
    		  out.flush();
	}
    catch (Exception e) { 
	         System.out.println("ошибка!!! " + e.getMessage()); 
	} 
	}
}
