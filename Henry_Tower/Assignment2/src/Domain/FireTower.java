package Domain;

public class FireTower extends Tower {

	public FireTower() {
		super( 1, 2);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		updatePower(2);
		updateRange(3);// Update the IObserver 
		this.setRange(getRange()+1);
		this.setPower(getPower()+1);
		// TODO Auto-generated method stub
		
	}

}
