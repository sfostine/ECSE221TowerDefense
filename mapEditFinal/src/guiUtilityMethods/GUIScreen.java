package guiUtilityMethods;

import javax.swing.*;
import javax.swing.border.Border;

import domain.Value;

import java.awt.*;

public class GUIScreen extends JPanel implements Runnable {
	private Thread thread;
	private static GUIMap room;
	private static int myWidth, myHeight;
	private static GUIScreen screen;
	public Graphics graphics;

	// implementing singleton pattern
	private GUIScreen() {
		setMyWidth(Value.getWindowWidth());
		setMyHeight(Value.getWindowHeight());
		Handler handle=new Handler();
		this.addMouseListener(handle);
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
	// overiding paintComponent
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.graphics = g;
		define();
		g.clearRect(0, 0, getMyWidth(), getMyHeight());
		room.update(); // drawing the room.

	}

	public void run() {
		// this is our game loop!
		while (true) {
			repaint();

			try {
				thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

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
