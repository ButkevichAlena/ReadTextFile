package DefaultPackage;

import java.util.ArrayList;
import java.util.Date;

public interface IReportMaker<Report> {
	Report makeReport(ArrayList<Line> list, Date firstDate, Date secondDate);
}
