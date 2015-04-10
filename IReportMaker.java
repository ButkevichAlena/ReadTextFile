package DefaultPackage;

import java.util.ArrayList;
import java.util.Date;

public interface IReportMaker<Report, T> {
	Report makeReport(T parameters);
}
