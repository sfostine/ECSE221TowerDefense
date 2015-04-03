package Domain;
import java.util.ArrayList;


public abstract class Tower {
	
	
	private int range;
	private int power;
	private ArrayList<IObserver> Observer;
	
	
	public Tower(int range, int power ){
		Observer = new ArrayList<IObserver>();
		this.range = range;
		this.power = power;
	}
	public void setPower(int power){
		this.power = power;
	}
	public int getPower(){
		return power;
	}
	public void setRange(int range){
		this.range = range;
	}
	public int getRange(){
		return range;
	}
	public void addObserver(IObserver a){
		Observer.add(a);
	}
	public void removeObserver(IObserver a){
		Observer.remove(a);
	}
	public abstract void update();// Updating each kind of Tower 
	
	public void ObserverUpdate(){
		for(IObserver b: Observer ){
			b.update();// updating the IObserver 
		}
	}
	public void updateRange(int range){
		if(this.range != range){
			ObserverUpdate();
			
		}
	}
	public void updatePower(int power){
		if(this.power !=power){
			ObserverUpdate();
		}
	}
	
}
