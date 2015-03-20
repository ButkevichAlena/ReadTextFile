package DefaultPackage;

public interface ILogRecordReadFile<T> {
	T read (String fileName, String firstLine, String secondLine);
}
