package guiUtilityMethods;

import java.awt.*;

import javax.swing.ImageIcon;

import domain.Value;

public class GUICell extends Rectangle {
	private int groundID;
	private Image grassTile, groundTile,entryTile,exitTile;

	public GUICell(int x, int y, int width, int height, int idG) {
		setBounds(x, y, width, height);
		this.groundID = idG;
		loadImages();
	}

	// load the images
	private void loadImages() {
		grassTile = new ImageIcon("src/repo/grasstile.png").getImage();
		groundTile = new ImageIcon("src/repo/groundTile.png").getImage();
		entryTile= new ImageIcon("src/repo/entry.png").getImage();
		exitTile= new ImageIcon("src/repo/exit.png").getImage();
	}
	
	public void drawCell(Graphics g) {
		g.drawRect(x, y, width, height);
		if (this.groundID == Value.grass) {
			g.drawImage(grassTile, x, y, null);
		} 
		else if(this.groundID==Value.path) {
			g.drawImage(groundTile, x, y, width, height, null);
		}
		else if(this.groundID==Value.entry){
			g.drawImage(entryTile, x, y, width,height,null);
		}
		else{
			g.drawImage(exitTile,x,y,width,height,null);
		}
		Toolkit.getDefaultToolkit().sync();
	}
}