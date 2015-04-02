package DefaultPackage;

import java.util.ArrayList;
import java.util.Date;

public interface IMostActiveHosts<T> {
	
	T mostActive(ArrayList<Line> list, Date firstDate, Date secondDate);
}
