package domain;

public abstract class Cell {
	protected boolean crittersAllowed; //allowed to have critters
	protected boolean towersAllowed; //allowed to construct towers
	public int posx;
	public int posy;
	boolean checked;
	public String coords(){
		return "("+posx+","+posy+")";
	}
	public String toString(){
		return "N";
	}
	public int getPosx() {
		// TODO Auto-generated method stub
		return posx;
	}
	public int getPosy() {
		// TODO Auto-generated method stub
		return posy;
	}
}
