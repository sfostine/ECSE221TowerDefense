package presentation;
import domain.Map;
public class ConsoleMapEvents implements IObserver {
	private Map observedMap; 
	
	public ConsoleMapEvents(Map theMap){
		super();
		this.observedMap=theMap;
	}
	@Override
	public void update(){
		//when a change occurs, the utility method printMap will display the map. 
		//this.printMap();
	}
	
	public Map getMapObserver()
	{
		return observedMap;
	}
	
	public void printMap(){
		for(int i= 0;i< observedMap.width;i++){
			for(int j=0;j<observedMap.height;j++){
				System.out.print(observedMap.grid[i][j].posx +"\t");
			}
			System.out.println("");
		}
	}
}
