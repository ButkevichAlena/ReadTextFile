package DefaultPackage;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class ReportForMostActiveHosts {
	public List<Map.Entry<String, Integer>> hosts;
	@Override
    public String toString(){
		StringBuilder s = new StringBuilder();
		for(Entry<String, Integer> nameOfHost: hosts){
		s.append(nameOfHost.getKey() + " " + nameOfHost.getValue()+ '\n');
		}
		return s.toString();
	}
}
