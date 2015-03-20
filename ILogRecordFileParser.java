package DefaultPackage;

import java.text.ParseException;

public interface ILogRecordFileParser<T> {
	T parse(String line) throws ParseException;
}
