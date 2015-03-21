package DefaultPackage;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

public class ReadText{

	public static void main(String[] args) throws IOException, ParseException{
	 Reader reader = new Reader();
	 
	 reader.read (args[0], args[1], args[2], args[3]);
	}
}
