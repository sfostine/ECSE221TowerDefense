package guiUtilityMethods;

import javax.swing.*;

import observerCritter.CompleteCritterObserver;
import domain.Value;

import java.awt.*;

public class GUIScreen extends JPanel implements Runnable {
	public Thread thread;

	public static boolean isFirst = true;
	public static GUIMap room;
	public static int myWidth;
	public static int myHeight;
	private static GUIScreen screen;
	public Graphics graphics;
	
	
	private int level = 7;
	protected  CompleteCritterObserver cr1;

	// implementing singleton pattern
	private GUIScreen() {
		myWidth = Value.getWindowWidth();
		myHeight = Value.getWindowHeight();
				
		cr1 = new CompleteCritterObserver(level, "src/repo/enemy1.png");
		
		//this.add(CritterScreen.getCritterScreen());

		thread = new Thread(this);
		thread.start();

	}

	public static GUIScreen getGuiScreen() {
		if (screen == null) {
			screen = new GUIScreen();
		}
		return screen;
	}

	public void define() {
		room = GUIMap.getMap();
	}

	private void updatePosition() {
		cr1.move();
	}
	// overiding paintComponent
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.graphics = g;
		define();
		g.clearRect(0, 0, myWidth, myHeight);
		room.update(); // drawing the room.
		cr1.drawCritters(g);
		
	}

	public void run() {
		// this is our game loop!
		while (true) {
			repaint();
			
			try {
				thread.sleep(700);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			updatePosition();
		}
	}
	
}
