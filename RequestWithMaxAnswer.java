package DefaultPackage;

import java.util.ArrayList;
import java.util.Date;

public class RequestWithMaxAnswer implements IReportMaker<ReportForRequestWithMaxAnswer> {

	@Override
	public ReportForRequestWithMaxAnswer makeReport(ArrayList<Line> list, Date firstDate, Date secondDate){
		int max = 0;
		
		for(Line line: list)
		{
			if(line.timeAndData.after(firstDate) && line.timeAndData.before(secondDate))
			{
				if(line.bytes > max)
				{
					max = line.bytes;
				}
			}
		}
		
		ReportForRequestWithMaxAnswer report = new ReportForRequestWithMaxAnswer();
		report.max = max;
		
		return report;
	}

}
