package DefaultPackage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser implements ILogRecordFileParser {
	public	static final String IPADDRESS_PATTERN = 
			"^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
			"([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
			"([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
			"([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
	
	public static Line getLine (ArrayList<String>ip, Date timeAndData, String way, int numberOfAnswer, int bytes){
    	Line line = new Line();
    	line.host = ip;
		line.timeAndData = timeAndData;
		line.way = way;
		line.numberOfAnswer = numberOfAnswer;
		line.bytes = bytes;
		return line;
    }
	
	 @Override 
	    public Line parse(String line) throws ParseException{
	    	String[] split1 = null;
	    	String[] split2 = null;
	    	String[] split3 = null; 
	    	String[] split4 = null; 
	    
	    	split1 = line.split(" - - "); 
	    	split2 = split1[1].split(" \""); 
	    	split3 = split2[1].split("\""); 
	    	split4 = split3[1].split(" "); 
	    
	    	ParseAddress(split1[0]);
	    
	    	if(isValidate(split1[0])){
	    		ArrayList <Integer> ip = new ArrayList();
	    		for(String s: ParseAddress(split1[0])){
	    			ip.add(Integer.valueOf(s)); 
	    		}
	    	}
	    
	    	SimpleDateFormat format = new SimpleDateFormat("[dd/MMM/yyyy:HH:mm:ss Z]", Locale.ENGLISH);
	    
	    	Date date = format.parse(split2[0]);
	    		
	    	Line l = getLine(ParseAddress(split1[0]), date ,split3[0], Integer.parseInt(split4[1]), Integer.parseInt(split4[2]) );
	     
	    	return l;
	    }
	    	
	    public static boolean isValidate(String IP){   
			Pattern pattern = Pattern.compile(IPADDRESS_PATTERN);
	        Matcher matcher = pattern.matcher(IP);
	        return matcher.matches();     
	    }
	    
	    public static ArrayList<String> ParseAddress(String IP){
	    	ArrayList<String> IPAddress = new ArrayList<String>();
	          
	    	for(String num: IP.split("\\.")){
	    	   IPAddress.add(num);
	    	}
	        return IPAddress;
		}
}
