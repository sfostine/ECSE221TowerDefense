package Domain;

public abstract class TowerDecorator extends Tower {

	protected Tower UnDecoratedTower;
	
	public TowerDecorator(Tower newTower){
		super(newTower);
		UnDecoratedTower = newTower;
		UnDecoratedTower.notifyObservers();
	}

}
