package DefaultPackage;

import java.text.ParseException;

public interface ILogRecordReadFile {
	void read(String fileName, String firstLine, String secondLine, String fileToWriteName) throws ParseException;
}
