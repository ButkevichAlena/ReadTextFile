package DefaultPackage;

public class Line {
	public String ip ;
	public String timeAndData;
	public String way;
	public int numberOfAnswer;
	public int bytes;
	
	Line (){
		
		}
	@Override
    public String toString() {
        return ip + timeAndData + way + Integer.toString(numberOfAnswer) + Integer.toString(bytes);
    }
}
