package Domain;

import java.awt.Dimension;
import java.awt.Toolkit;

//class that keeps important constants that are useful in controlling program flow
public class Value {
	public static int mapMode=0; //0 for new map, 1 for load map
	
	public static int grass = 0; // grass constant for setting the grass based
									
	public static int path = 1;  //path constant
	public static int entry=2;
	public static int exit=3;
	public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public static int pathCellSize = 52;
	public static int windowWidth, windowHeight;
	public static int width, height;
	public static int paletteHeight=50;
	public static String userInputName;
	
	//creating the minimum and maximum values for the map height and width. going to use that in the getUserInput portion. These values were tested on a 13 inch macbook air
	public static int minWidth=990;
	public static int maxWidth=screenSize.width;
	public static int minHeight=400;
	public static int maxHeight=screenSize.height-150;
	/**
	 * @return the windowWidth
	 */
	public static int getWindowWidth() {
		return windowWidth;
	}

	/**
	 * @return the windowHeight
	 */
	public static int getWindowHeight() {
		return windowHeight;
	}

	/**
	 * @param windowWidth
	 *            the windowWidth to set
	 */
	public static void setWindowWidth(int windowWi) {
		windowWidth = windowWi;
		width = windowWi / pathCellSize;
	}
	/**
	 * @param windowHeight
	 *            the windowHeight to set
	 */
	public static void setWindowHeight(int windowHei) {
		windowHeight = windowHei;
		height = (windowHei / pathCellSize);
	}

}
