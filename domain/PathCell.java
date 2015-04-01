package domain;
public class PathCell extends Cell {
	
	public PathCell(int positionX, int positionY){
		this.crittersAllowed=true;
		this.towersAllowed=false;
		this.posx= positionX;
		this.posy= positionY;
	}
	
	public String toString(){
		return "P";
	}
}

