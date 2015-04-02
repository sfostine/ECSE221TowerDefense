package presentation;

import domain.Map;

public class ConsoleMapEvents implements IObserver {
	private Map observedMap;

	public ConsoleMapEvents(Map theMap) {
		super();
		this.observedMap = theMap;
	}

	@Override
	public void update() {
		// when a change occurs, the utility method printMap will display the
		// map.
		// this.printMap();
	}

	public Map getMapObserver() {
		return observedMap;
	}

	public void printMap() {
		for (int i = 0; i < observedMap.getWidth(); i++) {
			for (int j = 0; j < observedMap.getHeight(); j++) {
				System.out.print(observedMap.getGrid()[i][j].getPosx() + "\t");
			}
			System.out.println("");
		}
	}
}
