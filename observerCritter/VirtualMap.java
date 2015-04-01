/***
 * @author Samuel Fostine
 * Date of modification : March 28, 2015
 * This class creates holds values for a virtual map, just to indicate the map to the critters so that they can move
 * */
package observerCritter;

public class VirtualMap {
	private Measures measure = Measures.getMeasures();

	/***************** PARAMETERS FOR MAP *******************************/
	// start of the path
	private int startX = measure.getStartX_OfMap();
	private int startY = measure.getStartY_OfMap();

	// width and height of the path
	private int width = measure.getWidth() / 2;
	private int height = 40;

	// new parameter for turn
	private int newX = startX + width - height;
	private int newheight = measure.getHeight() / 2;

	/**
	 * @return the measure
	 */
	public Measures getMeasure() {
		return measure;
	}

	/**
	 * @return the startX
	 */
	public int getStartX() {
		return startX;
	}

	/**
	 * @return the startY
	 */
	public int getStartY() {
		return startY;
	}

	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @return the newX
	 */
	public int getNewX() {
		return newX;
	}

	/**
	 * @return the newheight
	 */
	public int getNewheight() {
		return newheight;
	}

}
