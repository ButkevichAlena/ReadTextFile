package DefaultPackage;

import java.util.ArrayList;
import java.util.Date;

public class ParametersOfReport {
	public ArrayList<Line> list;
	public Date firstDate;
	public Date secondDate;
	
	public ParametersOfReport(ArrayList<Line> list, Date firstDate, Date secondDate)
	{
		this.list = list;
		this.firstDate = firstDate;
		this.secondDate = secondDate;
	}
}
