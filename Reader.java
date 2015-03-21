package DefaultPackage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.ParseException;
import java.util.ArrayList;

public class Reader implements ILogRecordReadFile {
	
	@Override
	public void read(String fileName, String firstLine, String secondLine, String fileToWriteName) throws ParseException
	{
	 File file = new File(fileName);
	    
	 ArrayList<String> text = new ArrayList<String>();
	 
	 try {
	    BufferedReader f1 = new BufferedReader(new FileReader(file));
	    int count = 0;
	    while (f1.readLine() != null) count ++;
	    String[] lines = new String[count];
	    System.out.println(count);
	    f1.close();
	 
	 
	    BufferedReader f2 = new BufferedReader(new FileReader(file));
	    for (int i = 0; i < count; i++ )lines[i] = f2.readLine();
	    
	    if (Integer.parseInt(firstLine) > count) System.out.println("Invalid input"); else {
	    	if (Integer.parseInt(secondLine) > count) for (int i = Integer.parseInt(firstLine); i <= count ; i++ )text.add(lines[i]); else {
	    		for (int i = Integer.parseInt(firstLine); i < Integer.parseInt(secondLine) ; i++ ) text.add(lines[i]);		
	    	}
	    }
	    f2.close();
	    
	 }
	 catch (Exception e) { 
         System.out.println("ошибка!!! " + e.getMessage()); 
	 } 
	 
	 ArrayList<Line> list = new ArrayList();
	 
	 Parser parser = new Parser();
	 for (String line: text){
			list.add(parser.parse(line));
	 }
	 
	 Writer writer = new Writer();
     writer.write(fileToWriteName, list);
	}
	
	
}
