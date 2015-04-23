package DefaultPackage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
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
	public void read(String fileName, int firstLine, int numberOfLines, String fileToWriteName) throws ParseException
	{
	 File file = new File(fileName);
	    
	 ArrayList<String> text = new ArrayList<String>();
	 
	 try {
		 FileInputStream inputStream = new FileInputStream(new File(fileName));
			
			int i = 0;
			int j = 0;
			
			while(i != firstLine - 1)
			{
				int b = inputStream.read();
				if(b == 10)
				{
					i++;
				}
				if(b == -1)
					break;
			}
			
			ArrayList<Character> byteString = new ArrayList<Character>(); 
			
			StringBuffer buffer = new StringBuffer();
			while(j != numberOfLines)
			{
				int b = inputStream.read();
				byteString.add((char)b);
				
				if(b == 10)
				{
					j++;
					
					
					for(Character ch: byteString)
					{
						buffer.append(ch);
					}
					
					text.add(buffer.toString().trim());
					
					buffer.delete(0, buffer.length());
					byteString.clear();
				}
				
				if(b == -1)
					break;
			}    
	 }
	 catch (Exception e) { 
         System.out.println("ошибка!!! " + e.getMessage()); 
	 } 
	 
	 list = new ArrayList();
	 	 
	 for (String line: text){
			list.add(parser.parse(line));
			for (Line l: list){
			}
	 }
	  
     writer.write(fileToWriteName, list);
	}
	
	
}
