package Domain;

public class SceneryCell extends Cell {
	public SceneryCell(int positionX, int positionY){
		this.crittersAllowed=false;
		this.towersAllowed=true;
		this.setPosx(positionX);
		this.setPosy(positionY);
	}

	public String toString(){
			return "S";
	}
}
