package DefaultPackage;

import java.util.ArrayList;
import java.util.Date;

public interface IRequestWithMaxAnswer <T> {
	
	T getReqest(ArrayList<Line> list, Date firstDate, Date secondDate);	
}
