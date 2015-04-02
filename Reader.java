package DefaultPackage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.ParseException;
import java.util.ArrayList;

public class Reader implements ILogRecordReadFile {
	
	private IRecordLineParser<Line> parser;
	private ILogRecordFileWriter writer;
	public ArrayList<Line> list;
	
	public Reader(IRecordLineParser<Line> parser, ILogRecordFileWriter writer){
		this.parser = parser;
		this.writer = writer;
	}
	
	@Override
	public void read(String fileName, int firstLine, int secondLine, String fileToWriteName) throws ParseException
	{
	 File file = new File(fileName);
	    
	 ArrayList<String> text = new ArrayList<String>();
	 
	 try {
	    BufferedReader f1 = new BufferedReader(new FileReader(file));
	    int count = 0;
	    while (f1.readLine() != null) count ++;
	    String[] lines = new String[count];
	    f1.close();
	 
	    BufferedReader f2 = new BufferedReader(new FileReader(file));
	    for (int i = 0; i < count; i++ )lines[i] = f2.readLine();
	    
	    if (firstLine > count) System.out.println("Invalid input"); else {
	    	if (secondLine > count) for (int i = firstLine; i <= count ; i++ )text.add(lines[i]); else {
	    		for (int i = firstLine; i < secondLine ; i++ ) text.add(lines[i]);		
	    	}
	    }
	    f2.close();
	    
	 }
	 catch (Exception e) { 
         System.out.println("ошибка!!! " + e.getMessage()); 
	 } 
	 
	 list = new ArrayList();
	 	 
	 for (String line: text){
			list.add(parser.parse(line));
	 }
	  
     writer.write(fileToWriteName, list);
	}
	
	
}
