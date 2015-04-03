public class LightingBall extends TowerDecorator {

	public LightingBall(ITower temp) {
		super(temp);
		// TODO Auto-generated constructor stub
	}
	public int getRange(){
		return plainTower.getRange()+2;
		
	}
	public int getPower(){
		return plainTower.getPower()+2;
	}

}
