package DefaultPackage;

import java.text.ParseException;

public interface IRecordLineParser<T> {
	T parse(String line) throws ParseException;
}
