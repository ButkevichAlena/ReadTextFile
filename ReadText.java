package DefaultPackage;
import java.io.*;
import java.util.*;


public class ReadText {
public static void main(String[] args) throws IOException{
    
	ArrayList<String> text = new ArrayList<String>();
	
    Reader reader = new Reader();
    text = reader.Read(args[0], args[1], args[2]);
    
    ArrayList<Line> list = new ArrayList<Line>();
    
    for(String line: text){
    list.add(toSplitLine(line));
    }
      
    Writer writer = new Writer();
    
    writer.Write(args[3], list);
}

    public static Line getLine (String _ip, String _timeAndData, String _way, int _numberOfAnswer, int _bytes)
    {
      Line line = new Line();
      line.ip = _ip;
		line.timeAndData = _timeAndData;
		line.way = _way;
		line.numberOfAnswer = _numberOfAnswer;
		line.bytes = _bytes;
      return line;
    }
    
    public static Line toSplitLine(String line){
    String[] split1 = null;
    String[] split2 = null;
    String[] split3 = null; 
    String[] split4 = null; 
    

    split1 = line.split(" - - "); 
    split2 = split1[1].split(" \""); 
    split3 = split2[1].split("\""); 
    split4 = split3[1].split(" "); 
    	
    	
    Line l = getLine(split1[0], split2[0], split3[0], Integer.parseInt(split4[1]), Integer.parseInt(split4[2]) );
     
    return l;
    	}
    	
    }

