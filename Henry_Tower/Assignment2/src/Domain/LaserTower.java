package Domain;

public class LaserTower extends Tower {
private static LaserTower laser = null;
	private LaserTower() {
		super( 2, 3);
		// TODO Auto-generated constructor stub
	}
	public static LaserTower getInstance(){
		if(laser == null){
			laser = new LaserTower();
		}
		return laser;
	}
	@Override
	public void update() {
		updatePower(3);
		updateRange(4);
		this.setRange(getRange()+1);
		this.setPower(getPower()+1);
		
		// TODO Auto-generated method stub
		
	}

}

