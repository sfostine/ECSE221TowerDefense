package driver;

import presentation.ConsoleMapEvents;
import domain.Map;

public class driver{
	public static void main (String[] args){
		//initializing theDomainMap with theGuiMap as well. adding guiMap as an observer
		Map theDomainMap=new Map(10,10);
		
		ConsoleMapEvents theGuiMap=new ConsoleMapEvents(theDomainMap);
		theDomainMap.addObserver(theGuiMap);
		theDomainMap.setDefaultMap();
		
		System.out.println(theDomainMap.findPath().get(0));
	}
}
