package DefaultPackage;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

public class ReadText{

	public static void main(String[] args) throws IOException, ParseException{
		ArrayList<String> text = new ArrayList<String>();
		LogRecord logRecord = new LogRecord();
	
		text = logRecord.read(args[0], args[1], args[2]);
    
		ArrayList<Line> list = new ArrayList<Line>();
    
		for(String line: text){
			list.add(logRecord.parse(line));
		}
      
		logRecord.write(args[3], list);
	}
}
