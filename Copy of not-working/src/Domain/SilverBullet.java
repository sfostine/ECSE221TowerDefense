package Domain;

public class SilverBullet extends TowerDecorator{

	protected SilverBullet(Tower tower) {
		super(tower);
		tower.description = "SilverBullet " + tower.getDescription();
		System.out.println(tower.description);
	}

	public int cost(){
		return 50 + UnDecoratedTower.cost();
	}
	
	
	@Override
	public Tower upgrade() {
		if (this.getLevel() == 1){
			 this.setLevel(getLevel() + 1);
			 return new FireBall(this);
		 }else if(this.getLevel() == 2){
			 this.setLevel(getLevel() + 1);
			 return new SilverBullet(this);
		 }else{
			 return this;
		 }
	}

//	@Override
//	public void attack(Critter c) {
//		c.hit(this.getPower());		
//	}
	
}
