package domain;

public abstract class Cell {
	protected boolean crittersAllowed; //allowed to have critters
	protected boolean towersAllowed; //allowed to construct towers
	private boolean checked;
	/**
	 * @param checked the checked to set
	 */
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	/**
	 * @return the checked
	 */
	public boolean isChecked() {
		return checked;
	}
	private int posx, posy;
	/**
	 * @param posx the posx to set
	 */
	public void setPosx(int posx) {
		this.posx = posx;
	}
	/**
	 * @param posy the posy to set
	 */
	public void setPosy(int posy) {
		this.posy = posy;
	}
	
	public String coords(){
		return "("+posx+","+posy+")";
	}
	public String toString(){
		return "N";
	}
	public int getPosx() {
		return posx;
	}
	public int getPosy() {
		// TODO Auto-generated method stub
		return posy;
	}
}
