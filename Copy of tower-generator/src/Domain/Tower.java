package Domain;
//Xu Ji 260562839
import java.util.*;

public abstract class Tower {
 
 //Declare variables
 private double range;
 private double power;
 private double rateOfFire;
 private int level;
 private LinkedList<IObserver> observers;
 private StrategyIObserver towerStrategy;
 
 //Constructor 
 public Tower(int level){
  this.observers = new LinkedList<IObserver>();
  this.level = level;
  this.towerStrategy = new nearestCritterStrategy();
 }

 public Tower(Tower a){
	 this.observers = a.getObservers();
	 this.level = a.getLevel();
	 this.towerStrategy = a.getStrategy();
 }
 
 public Tower(){
	 System.out.println("This is no good.");
 }
 
 //Add and remove observers
 public void addObserver(IObserver o){ observers.add(o); }
 public void removeObserver(IObserver o){ observers.remove(o); }
 
 protected void notifyObservers(){
  for(IObserver o: observers){
   o.update();
  }
 }
 
 //Abstract upgrade method 
 public abstract Tower upgrade();
 
 public abstract int cost();
 
 public abstract String getDescription();
 
 public void sell(){ System.out.println("tower sold"); }
 
 
 //Setter and getter
  
 public void setRange(double range){
  if (this.range != range){
   this.range = range;
   notifyObservers();
  }
 }
 
 public void setStrategy(StrategyIObserver newStrategy){ this.towerStrategy = newStrategy; }
 
 public void performStrategy(){ this.towerStrategy.performStrategy(); }
 
 public void setPower(double power){ this.power = power; }
 
 public void setRateOfFire(double rateOfFire){ this.rateOfFire = rateOfFire; }
   
 public double getRange(){ return range; }
 
 public double getPower(){ return power; }
 
 public double getRateOfFire(){ return rateOfFire; }

 public int getLevel() { return level; }
 
 public LinkedList<IObserver> getObservers(){ return observers; }
 
 public StrategyIObserver getStrategy(){ return towerStrategy; } 

 public void setLevel(int level) { this.level = level; }

 
}
