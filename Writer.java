package DefaultPackage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Writer implements ILogRecordFileWriter {
    @Override 
    public void write(String fileName, ArrayList<Line> list){
		try{
			BufferedWriter out = new BufferedWriter(new BufferedWriter(new FileWriter(fileName)));
		
			for(Line line: list)
			out.write(line.getString());
			out.newLine();
			out.close();
		}
		catch (Exception e) { 
			System.out.println("ошибка!!! " + e.getMessage()); 
		} 
    }
}
