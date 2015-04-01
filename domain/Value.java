package domain;
//class that keeps important constants that are useful in controlling program flow
public class Value {
	
	public static int grass = 0; //grass constant for setting the grass based on what Instance is in the model
	public static int path = 1; //
	public static int width= 12;
	public static int height= 8;
	public static int pathCellSize=52;
	public static int windowWidth=52*width;
	public static int windowHeight=52*height;
	

	
	
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
	 * @param windowWidth the windowWidth to set
	 */
	public static void setWindowWidth(int windowWidth) {
		Value.windowWidth = windowWidth;
	}
	/**
	 * @param windowHeight the windowHeight to set
	 */
	public static void setWindowHeight(int windowHeight) {
		Value.windowHeight = windowHeight;
	}
	
}
