package Domain;
import java.awt.event.*;
import java.awt.*;

import javax.swing.JOptionPane;

public class Handler implements MouseMotionListener, MouseListener  {

	@Override
	public void mouseClicked(MouseEvent e) {
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
		GUIMap.executeAction(domainY,domainX);
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
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {

		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	} 

}
