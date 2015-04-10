package DefaultPackage;

public class RequestWithMaxAnswer implements IReportMaker<ReportForRequestWithMaxAnswer, ParametersOfReport> {

	@Override
	public ReportForRequestWithMaxAnswer makeReport(ParametersOfReport parameters){
		int max = 0;
		
		for(Line line: parameters.list)
		{
			if(line.timeAndData.after(parameters.firstDate) && line.timeAndData.before(parameters.secondDate))
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
