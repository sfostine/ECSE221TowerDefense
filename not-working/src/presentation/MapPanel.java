package presentation;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Domain.Bow;
import Domain.Cannon;
import Domain.Map;
import Domain.Rocket;
import Domain.Tower;
import Domain.Value;
import MapEditorGuiUtilityMethods.GUICell;
import MapEditorGuiUtilityMethods.GUIMap;

public class MapPanel extends JPanel implements MouseListener{

	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MapPanel(){
		 
		  this.setLayout(null);
		  this.setBackground(Color.YELLOW); 
		  this.addMouseListener(this);
	 }

	 //buildTower method takes two int which represents the position
	 //build a tower object and towerGUI object
	 //link towerGUI to tower as an observer
	 public void buildTower(int x, int y){
	  if (ButtonPanel.isBuildCannon){
	   Tower a = new Cannon(1);
	   TowerCannonGUI ag = new TowerCannonGUI(a, x, y);
	   a.addObserver(ag);
	  }else if (ButtonPanel.isBuildRocket){
	   Tower a = new Rocket(1);
	   TowerRocketGUI ag = new TowerRocketGUI(a, x, y);
	   a.addObserver(ag);
	  }else if (ButtonPanel.isBuildBow){
	   Tower a = new Bow(1);
	   TowerBowGUI ag = new TowerBowGUI(a, x, y);
	   a.addObserver(ag);
	  }else{
	   System.out.println("wrong type of tower");
	  }
	 }
	 

	 @Override
	 //Once the mapPanel detects a mouse click
	 //it calls buildTower method if isBuildTower is also true
	 public void mouseClicked(MouseEvent e) {
	  // TODO Auto-generated method stub
		 Point currentPoint=new Point(e.getX(),e.getY());
			GUICell startingPoint=GUIMap.firstCell;
			//just to control flow
			int domainX=-1;
			int domainY=-1;
			for(int x=0;x<Value.width&&domainX==-1;x++){
				for(int y=0;y<Value.height&&domainX==-1;y++){
					int startX=Value.pathCellSize*x+startingPoint.x;
					int startY=Value.pathCellSize*y+startingPoint.y;
					int stopX=startX+Value.pathCellSize;
					int stopY=startY+Value.pathCellSize;
					if(inRange(startX,stopX,startY,stopY,currentPoint)){
						domainX=x;
						domainY=y;
						
					}
				}
			}
	  if((ButtonPanel.isBuildCannon || ButtonPanel.isBuildRocket || ButtonPanel.isBuildBow) && (GameFrame.getGUIScreen().getGUIMap().getDomainMap().isScenery(domainX, domainY))){
	   this.buildTower(domainX/Value.pathCellSize * Value.pathCellSize, domainY/Value.pathCellSize * Value.pathCellSize);
	  }else{
		  
		  JOptionPane.showMessageDialog(GameFrame.mapPanel, "You can't put the tower on a path cell,\n try a scenery one.");
	  }
	 }
	 
	 public boolean inRange(int startX, int stopX, int startY, int stopY,Point currentPoint){
			if(currentPoint.x>=startX&&currentPoint.x<=stopX){
				if(currentPoint.y>=startY&&currentPoint.y<=stopY){
					return true;
				}
				else{
					return false;
				}
			}
			else{
				return false;
			}
		}

	 @Override
	 public void mousePressed(MouseEvent e) {
	  // TODO Auto-generated method stub
	 }

	 @Override
	 public void mouseReleased(MouseEvent e) {
	  // TODO Auto-generated method stub
	  
	 }

	 @Override
	 public void mouseEntered(MouseEvent e) {
	  // TODO Auto-generated method stub
	  
	 }

	 @Override
	 public void mouseExited(MouseEvent e) {
	  // TODO Auto-generated method stub
	 }
	 
	 public MapPanel getMapPanel(){ return this; }
}
