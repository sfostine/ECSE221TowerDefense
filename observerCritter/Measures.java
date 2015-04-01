/***
 * @author Samuel Fostine
 * Date of modification : March 28, 2015
 * This class contains important values that will be used in the game
 * It allows to access those values from different classes
 */
package observerCritter;

public class Measures {
	// width and height of the window
	// the X and y coordinates of the starting point of the map
	// note that this x coordinate will also be used as a reference X for the
	// critters
	private int width, height, startXMap, startYMap;
	private static Measures measures = new Measures();

	private Measures() {
		this.width = 1000;
		this.height = 800;
		this.startXMap = 0;
		this.startYMap = height / 7;
	}

	// get the measures class
	public static Measures getMeasures() {
		return measures;
	}

	/******************* GETTERS **********************************/
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getStartX_OfMap() {
		return startXMap;
	}

	public int getStartY_OfMap() {
		return startYMap;
	}

}
