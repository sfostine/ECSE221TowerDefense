package guiUtilityMethods;

import java.awt.*;

import javax.swing.ImageIcon;

import domain.Value;

public class GUICell extends Rectangle {
	public int groundID;
	Image grassTile;
	Image groundTile;

	public GUICell(int x, int y, int width, int height, int idG) {
		setBounds(x, y, width, height);
		this.groundID = idG;
		loadImages();
	}
	
	// load the images
	private void loadImages(){
		grassTile = new ImageIcon("src/repo/grasstile.png").getImage();
		groundTile = new ImageIcon("src/repo/groundTile.png").getImage();
		
	}

	/***
	 * draw the cells
	 * @param g
	 */
	public void drawCell(Graphics g) {
		g.drawRect(x, y, width, height);
		
		if (this.groundID == Value.grass) {
			g.drawImage(grassTile, x, y, null);
		} else {
			g.drawImage(groundTile, x, y, width, height, null);
		}
		Toolkit.getDefaultToolkit().sync();
	}
}