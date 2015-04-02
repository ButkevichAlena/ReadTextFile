package DefaultPackage;

import java.util.ArrayList;
import java.util.Date;

public class SummarySizeOfAnswers implements ISummarySizeOfAnswers< ReportForSummarySizeOfAnswers> {
	
	@Override
	public  ReportForSummarySizeOfAnswers getSize(ArrayList<Line> list, Date firstDate, Date secondDate) {
		int size = 0;
		
		for(Line line: list)
		{
			if(line.timeAndData.after(firstDate) && line.timeAndData.before(secondDate))
			{
				size+=line.bytes;
			}
		}
		
		ReportForSummarySizeOfAnswers report = new  ReportForSummarySizeOfAnswers();
		report.size = size;
		return report;
	}
}
