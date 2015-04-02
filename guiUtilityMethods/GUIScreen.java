package guiUtilityMethods;

import javax.swing.*;

import observerCritter.CompleteCritterObserver;
import domain.Value;

import java.awt.*;

public class GUIScreen extends JPanel implements Runnable {
	private Thread thread;
	private static GUIMap room;
	private static int myWidth, myHeight;
	private static GUIScreen screen;
	public Graphics graphics;

	private int level = 1;
	protected CompleteCritterObserver cr1;

	// implementing singleton pattern
	private GUIScreen() {
		setMyWidth(Value.getWindowWidth());
		setMyHeight(Value.getWindowHeight());
		cr1 = new CompleteCritterObserver(level, "src/repo/enemy1.png");
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
		g.clearRect(0, 0, getMyWidth(), getMyHeight());
		room.update(); // drawing the room.
		cr1.drawCritters(g);

	}

	public void run() {
		// this is our game loop!
		while (true) {
			repaint();

			try {
				thread.sleep(1500 / level);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			updatePosition();
		}
	}

	/**
	 * @return the myHeight
	 */
	public static int getMyHeight() {
		return myHeight;
	}

	/**
	 * @param myHeight
	 *            the myHeight to set
	 */
	public static void setMyHeight(int myHeight) {
		GUIScreen.myHeight = myHeight;
	}

	/**
	 * @return the myWidth
	 */
	public static int getMyWidth() {
		return myWidth;
	}

	/**
	 * @param myWidth
	 *            the myWidth to set
	 */
	public static void setMyWidth(int myWidth) {
		GUIScreen.myWidth = myWidth;
	}

}
