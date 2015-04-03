public class FireBall extends TowerDecorator {

	public FireBall(ITower temp) {
		super(temp);
		// TODO Auto-generated constructor stub
	}
	public int getRange(){
		return plainTower.getRange()+5;
		
	}
	public int getPower(){
		return plainTower.getPower()+5;
	}

}
