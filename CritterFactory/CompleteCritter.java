/***
 * @author Samuel Fostine
 * Date of modification : March 4, 2015
 * This class extends the critter class and complete the Critter class by adding the image for a critter
 * And it also provides the method to draw a critter
 */
package CritterFactory;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;

import domain.Value;

public class CompleteCritter extends Critter{

	private String path;
	protected Image crit;
	private ImageIcon image;
	

	// extends critter class, and add the image for a critter in different level
	public CompleteCritter(int gameLevel, String imagePath) {
		super(gameLevel);	
		this.path = imagePath;
		loadImage();
		
	}
	
	

	/*** Load the sprite and assign ot to the Image variable */
	private void loadImage() {
		image = new ImageIcon(path);
		crit = image.getImage();
	}
	
	public void setNewImage(String newPath)
	{
		path = newPath;
		loadImage();	
	}

	/***
	 * draw critters at specific coordinates and some String on the screen
	 * 
	 * @param g
	 */
	public void drawCritters(Graphics g) {
		g.drawImage(crit, this.getX(), getY(), null);
		
		Toolkit.getDefaultToolkit().sync();

	}
	
	public void drawDead(Graphics g)
	{
		g.setColor(Color.green);
		
		g.fillRect(0, 0, 
				Value.getWindowWidth(), Value.getWindowHeight());
		
		g.setColor(Color.BLACK);
		g.setFont(new Font("default", Font.BOLD, 40));
		g.drawString("HIT POINT IS : 0\nCRITTER IS DEAD", Value.getWindowWidth()/4, Value.getWindowHeight()/2);	
	}
	
}
