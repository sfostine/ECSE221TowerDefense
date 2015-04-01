/***
 * @author Samuel Fostine
 * Date of modification : March 28, 2015
 * This class contains the observers, we can add a new one, remove it
 * and notidy the observers when there is an update
 * */
package observerCritter;

import java.util.ArrayList;

public class ItemContainer {

	// list of all observers
	private ArrayList<ICritterObserver> observers;

	public ItemContainer() {
		observers = new ArrayList<ICritterObserver>();
	}

	/***
	 * when declare an observer, we can add it to the list of all the observer
	 * for this Subject
	 * 
	 * @param observer
	 */
	public void addObserver(ICritterObserver observer) {
		observers.add(observer);
	}

	/***
	 * Remove the observer from the list for this particular subject
	 * 
	 * @param observer
	 */
	public void removeObserver(ICritterObserver observer) {
		observers.remove(observer);
	}

	/***
	 * update all the observers in the list when there is a new event
	 */
	public void notifyObservers() {
		for (ICritterObserver obs : observers)
			obs.update();
	}

}
