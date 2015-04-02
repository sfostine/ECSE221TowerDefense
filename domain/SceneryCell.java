package domain;

public class SceneryCell extends Cell {
	private Tower theTower;
	public SceneryCell(int positionX, int positionY){
		this.crittersAllowed=false;
		this.towersAllowed=true;
		this.setPosx(positionX);
		this.setPosy(positionY);
	}
	public void setTower(Tower setT){
		this.theTower=setT;
	}
	public void deleteTower(){
		this.theTower=null;
	}
	public String toString(){
		if(this.theTower!=null){
			return "T";
		}
		else{
			return "S";
		}
	}
}
