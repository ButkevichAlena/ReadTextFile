package DefaultPackage;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;



public class Line {
	
	public ArrayList<String> host = new ArrayList<String>() ;
	public ArrayList<Integer> ip = new ArrayList<Integer>(); 
	public Date timeAndData;
	public String way;
	public int numberOfAnswer;
	public int bytes;
	
	public String getString(){
	SimpleDateFormat dateFormat = new SimpleDateFormat("[dd/MMM/yyyy:HH:mm:ss Z]", Locale.ENGLISH);
	StringBuilder string = new StringBuilder();

	string.append(getAddress());
	
	string.append(" - - " + dateFormat.format(timeAndData) + " \"" + way + "\" " + numberOfAnswer + " " + bytes);
	  
	return string.toString();
	}
	
	public String getAddress(){
		StringBuilder string = new StringBuilder();
		  
		  if(ip.size() != 0){
			  for(Integer i: ip){
				  string.append(i.toString() + ".");        	 
			  }
		  }
		  else{
			  for(String i: host){
				  string.append(i + ".");
			  }
		  }
		  
		  string.deleteCharAt(string.length() - 1);
		  
		  return string.toString();
	}
}
