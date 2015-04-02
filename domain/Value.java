package domain;

//class that keeps important constants that are useful in controlling program flow
public class Value {

	public static int grass = 0; // grass constant for setting the grass based
									// on what Instance is in the model
	public static int path = 1; //
	public static int pathCellSize = 52;
	public static int windowWidth, windowHeight;
	public static int width, height;

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
		height = windowHei / pathCellSize;
	}

}
