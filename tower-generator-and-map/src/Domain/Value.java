package Domain;

//class that keeps important constants that are useful in controlling program flow
public class Value {

	private static int grass = 0; // grass constant for setting the grass based
									// on what Instance is in the model
	private static int path = 1; //
	private static int pathCellSize = 52;
	private static int windowWidth, windowHeight;
	private static int width, height;

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
		setWidth(windowWi / getPathCellSize());
	}

	/**
	 * @param windowHeight
	 *            the windowHeight to set
	 */
	public static void setWindowHeight(int windowHei) {
		windowHeight = windowHei;
		setHeight(windowHei / getPathCellSize());
	}

	/**
	 * @return the pathCellSize
	 */
	public static int getPathCellSize() {
		return pathCellSize;
	}

	/**
	 * @param pathCellSize the pathCellSize to set
	 */
	public static void setPathCellSize(int pathCellSize) {
		Value.pathCellSize = pathCellSize;
	}

	/**
	 * @return the width
	 */
	public static int getWidth() {
		return width;
	}

	/**
	 * @param width the width to set
	 */
	public static void setWidth(int width) {
		Value.width = width;
	}

	/**
	 * @return the grass
	 */
	public static int getGrass() {
		return grass;
	}

	/**
	 * @param grass the grass to set
	 */
	public static void setGrass(int grass) {
		Value.grass = grass;
	}

	/**
	 * @return the height
	 */
	public static int getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public static void setHeight(int height) {
		Value.height = height;
	}

	/**
	 * @return the path
	 */
	public static int getPath() {
		return path;
	}

	/**
	 * @param path the path to set
	 */
	public static void setPath(int path) {
		Value.path = path;
	}

}
