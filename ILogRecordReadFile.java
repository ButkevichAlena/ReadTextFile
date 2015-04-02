package DefaultPackage;

import java.text.ParseException;

public interface ILogRecordReadFile {
	void read(String fileName, int firstLine, int secondLine, String fileToWriteName) throws ParseException;
}
