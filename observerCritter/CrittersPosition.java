/***
 * @author Samuel Fostine
 * Date of modification : March 28, 2015
 * This class defines the starting position of the map and critters, then keep updating the positions of the critters
 */
package observerCritter;

public class CrittersPosition {
	// screen to retrieve the starting position of the critters
	protected Measures measure = Measures.getMeasures();

	// X and Y coordinates
	private int x, y;

	/***
	 * initialize the starting point of the critters to always be the starting
	 * point from the screen class
	 */
	public CrittersPosition() {
		this.x = measure.getStartX_OfMap();
		this.y = measure.getStartY_OfMap();
	}

	/************************* GETTERS **********************************/
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

}
