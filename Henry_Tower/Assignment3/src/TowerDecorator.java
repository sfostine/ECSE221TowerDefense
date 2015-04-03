public abstract class TowerDecorator implements ITower {
	protected ITower plainTower;
	public TowerDecorator(ITower temp){
		plainTower = temp;
	}
	@Override
	public int getRange() {
		return plainTower.getRange();
	}

	@Override
	public int getPower() {
		// TODO Auto-generated method stub
		return plainTower.getPower();
	}

	@Override
	public void setRange(int range) {
		plainTower.setRange(range);
		
	}

	@Override
	public void setPower(int power) {
		// TODO Auto-generated method stub
		
	}
	
}
