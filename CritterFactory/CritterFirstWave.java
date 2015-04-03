/***
 * @author Samuel Fostine
 * Date of modification : April 2, 2015
 * This class just allows to have critters for the first waves
 * */
package CritterFactory;

import java.util.ArrayList;


public class CritterFirstWave extends CompleteCritter {
	
	private final static String IMAGEPATH = "src/repo/enemy1.png";
	private final static int LEVEL = 1;
	private final static  int NUMCRITTER = 7;
	private int distance;


	public CritterFirstWave() {
		super(LEVEL, IMAGEPATH);
		}
	
	/**
	 * @return the distance
	 */
	public int getDistance() {
		return distance;
	}

	/**
	 * @param distance the distance to set
	 */
	public void setDistance(int distance) {
		this.distance = distance;
	}
	/**
	 * @return the nUMCRITTER
	 */
	public static int getNUMCRITTER() {
		return NUMCRITTER;
	}
	
}
