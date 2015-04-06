package Domain;

public class FireBall extends TowerDecorator{

	protected FireBall(Tower tower) {
		super(tower);
		tower.description = "Fireball " + tower.getDescription();
	}

	public int cost(){
		return 100 + UnDecoratedTower.cost();
	}

	
	@Override
	 public Tower upgrade(){
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
