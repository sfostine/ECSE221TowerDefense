package MapEditorDomain;
import java.util.ArrayList;
import java.util.List;

import MapEditorPresentation.IObserver;
public abstract class Subject {
	
	public Subject(){
		observers=new ArrayList<IObserver>();
	}
	public void addObserver(IObserver o){
		observers.add(o);
	}
	public void removeObserver(IObserver o){
		observers.remove(o);
	}
	protected void notifyObservers(){
		for( IObserver o:observers){
			o.update();
		}
	}
	private List<IObserver> observers;
}
