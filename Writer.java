package DefaultPackage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Writer implements ILogRecordWriteFile {
    @Override 
    public void write(String fileName, ArrayList<Line> list){
		try{
			File file = new File(fileName);
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file)));
		
			for(Line line: list)
			out.print(line.getString() + '\n');
    		out.flush(); out.close();
		}
		catch (Exception e) { 
			System.out.println("ошибка!!! " + e.getMessage()); 
		} 
    }
}
