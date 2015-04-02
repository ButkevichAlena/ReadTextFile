package DefaultPackage;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class FileAnalyzer{

	public static void main(String[] args) throws IOException  {
		try{
			ILogRecordFileWriter writer = new Writer();
			IRecordLineParser<Line> parser = new Parser();

			Reader reader = new Reader(parser, writer);
 
			int firstLine = Integer.parseInt(args[1]);
			int secondLine = Integer.parseInt(args[2]);
			int numberOfReport = Integer.parseInt(args[4]);
   
			File file = new File(args[0]);
			File outputFile = new File(args[3]);
			
			reader.read (args[0], firstLine, secondLine, args[3]);
		
			System.out.println("Input first date in format (yyyy.MM.dd:HH:mm:ss): ");
		
			Scanner scanner = new Scanner(System.in);
			String sdate = scanner.next();
		
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd:HH:mm:ss");
			Date firstDate = dateFormat.parse(sdate);
		
			System.out.println("Input second date in format (yyyy.MM.dd:HH:mm:ss): ");
			sdate = scanner.next();
			Date secondDate = dateFormat.parse(sdate);
		       
			if(numberOfReport == 1){
				
				 System.out.println("\nReport 1:");
				 
				 MostActiveHosts mostActiveHosts = new MostActiveHosts();
				 ReportForMostActiveHosts report = new ReportForMostActiveHosts();
				 
				 report = mostActiveHosts.mostActive(reader.list, firstDate, secondDate);
				 System.out.println(report.toString());
			 } 
			
			if(numberOfReport == 2){
				 System.out.println("\nReport 2:");
				 
				 SummarySizeOfAnswers request = new SummarySizeOfAnswers();
				 ReportForSummarySizeOfAnswers report = new  ReportForSummarySizeOfAnswers();
				 
				 report = request.getSize(reader.list, firstDate, secondDate);
				 
				 System.out.println ("Summary size of answers is " + report.toString() + " bytes." );
			}
			
			if(numberOfReport == 3){
				 System.out.println("\nReport 3:\n");
				 
				 RequestWithMaxAnswer request = new RequestWithMaxAnswer();
				 ReportForRequestWithMaxAnswer report = new ReportForRequestWithMaxAnswer();
				 
				 report = request.getReqest(reader.list, firstDate, secondDate);
				 
				 System.out.println ("Size of biggset answer is " + report.toString() + " bytes." );
			}
		}
		catch (ParseException e) {
			System.out.println("Error! Wrong format!");
		}
      }
	}

