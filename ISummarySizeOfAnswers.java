package DefaultPackage;

import java.util.ArrayList;
import java.util.Date;

public interface ISummarySizeOfAnswers<T> {
	T getSize(ArrayList<Line> list, Date firstDate, Date secondDate);
}
