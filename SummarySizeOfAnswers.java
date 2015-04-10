package DefaultPackage;

public class SummarySizeOfAnswers implements IReportMaker<ReportForSummarySizeOfAnswers, ParametersOfReport> {
	
	@Override
	public  ReportForSummarySizeOfAnswers makeReport(ParametersOfReport parameters) {
		int size = 0;
		
		for(Line line: parameters.list)
		{
			if(line.timeAndData.after(parameters.firstDate) && line.timeAndData.before(parameters.secondDate))
			{
				size+=line.bytes;
			}
		}
		
		ReportForSummarySizeOfAnswers report = new  ReportForSummarySizeOfAnswers();
		report.size = size;
		return report;
	}
}
