/***
 * @author Samuel Fostine
 * Date of modification : April 2, 2015
 * This class just allows to have critters for the first waves
 * */
package CritterFactory;

import java.util.ArrayList;


public class CritterThirdWave extends CompleteCritter {
	
	private final static String IMAGEPATH = "src/repo/enemy3.png";
	private final static int LEVEL = 3;
	private final static  int NUMCRITTER = 12;
	private int distance;

	public CritterThirdWave() {
		super(LEVEL, IMAGEPATH);
		}
	
	/**
	 * @return the NUMCRITTER
	 */
	public static int getNUMCRITTER() {
		return NUMCRITTER;
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
	
}
