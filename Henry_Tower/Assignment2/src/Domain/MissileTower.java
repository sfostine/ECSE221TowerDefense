package Domain;

public class MissileTower extends Tower {

	public MissileTower() {
		super( 3, 4);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		updatePower(4);
		updateRange(5);
		this.setRange(getRange()+1);
		this.setPower(getPower()+1);
		// TODO Auto-generated method stub
		
	}

}
