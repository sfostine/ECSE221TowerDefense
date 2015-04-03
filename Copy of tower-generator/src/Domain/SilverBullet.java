package Domain;

public class SilverBullet extends TowerDecorator{

	protected SilverBullet(Tower tower) {
		super(tower);
	}

	public int cost(){
		return 50 + UnDecoratedTower.cost();
	}
	
	 
	 public String getDescription(){ 
		 return "Silver Bullet + " + UnDecoratedTower.getDescription();
	 }
	
	@Override
	public Tower upgrade() {
		return this;
	}
	
}
