package presentation;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import Domain.Bow;
import Domain.Cannon;
import Domain.Rocket;
import Domain.Tower;

public class MapPanel extends JPanel implements MouseListener{

	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//	final JPanel mapPanel;

	 public MapPanel(){
		 
//		  this.mapPanel = new JPanel();
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
	  if(ButtonPanel.isBuildCannon || ButtonPanel.isBuildRocket || ButtonPanel.isBuildBow){
	   this.buildTower(e.getX(), e.getY());
	   System.out.println("mouse clicked " + e.getX() + e.getY());
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
