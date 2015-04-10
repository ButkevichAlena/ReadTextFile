package DefaultPackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostActiveHosts implements IReportMaker<ReportForMostActiveHosts, ParametersOfReport> {

	@Override
	public ReportForMostActiveHosts makeReport(ParametersOfReport parameters) {
			Map<String,Integer> hosts = new HashMap<String, Integer>();
			int count = 5;
			for(Line line: parameters.list)
			{
				if(line.timeAndData.after(parameters.firstDate) && line.timeAndData.before(parameters.secondDate))
				{
					if(hosts.containsKey(line.getAddress()))
					{
						hosts.put(line.getAddress(),  hosts.get(line.getAddress()) + 1);
					}
					else
					{
						hosts.put(line.getAddress(), 1);
					}
				}
			}
			
			List<Map.Entry<String, Integer>> newList = new ArrayList<Map.Entry<String, Integer>>();
			newList.addAll(hosts.entrySet());
			
				
			Collections.sort(newList, new Comparator<Map.Entry<String, Integer>>()
					{
				         @Override
				         public int compare(Map.Entry<String, Integer> el1, Map.Entry<String, Integer> el2)
				         {
				        	 return el2.getValue().compareTo(el1.getValue());
				         }
			        });
			
			List<Map.Entry<String, Integer>> listOfHosts = new ArrayList<Map.Entry<String, Integer>>();
			
			for(Map.Entry<String, Integer> pair: newList)
			{
				if(count == 0)
				{
					break;
				}
				
				listOfHosts.add(pair);
				count--;
			}
			
			ReportForMostActiveHosts report = new ReportForMostActiveHosts();
			report.hosts = listOfHosts;
			
			return report;

	}
	
}
