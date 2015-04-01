/***
 * @author Samuel Fostine
 * Date of modification : March 28, 2015
 * This class contains all the attributes of a critter 
 * and the functions that will be used to access or modify the attributes 
 * it implements the critter observer for the pattern
 * */
package observerCritter;

import guiUtilityMethods.GUIMap;

import java.util.ArrayList;

import domain.Cell;
import domain.PathCell;
import domain.Value;

public class Critter implements ICritterObserver {

	// private attributes to each critter
	private int reward, hitPoint, strength, level, speed;
	private int pre_hitPoint;

	// coordinate of critters
	private int x, y;

	// position of the critters
	private ArrayList<Cell> path;
	
	//map 
	GUIMap map;
	private int adjust = 10;
	
	// NB: attributes are dependent on the game level
	public Critter(int gameLevel) {
		map = GUIMap.getMap();
		this.level = gameLevel;
		this.reward = gameLevel;
		this.hitPoint = gameLevel + 1;
		this.pre_hitPoint = hitPoint;
		this.strength = gameLevel + 1;
		this.speed = gameLevel * 3 + 1;
		path = map.domainMap.findPath();
		this.x = path.get(0).posx;
		this.y = path.get(0).posy + adjust;
		
		
		
	}

	/***
	 * the update method when notifying
	 */
	@Override
	public void update() {

		// when the previous hit point is greater than the new hit point, the
		// critter is hit
		// then we set previous hit point equal to the new hit point
		// because we want to know if the critter is hit again
		if ((pre_hitPoint > getHitPoint()) && !isDead()) {
			System.out.println("I AM HIT");
			System.out.println("My new hit points is " + this.getHitPoint());
			System.out.println("My new strength is " + this.getStrength());
			pre_hitPoint = getHitPoint();

			// if the critter is dead, notify that it is dead
		} else if (isDead()) {

			System.out.println("********* I AM DEAD ***********");
			System.out.println("You have just received " + getreward()
					+ " coin(s) for killing me ");
		}
		System.out.println();
	}

	/***
	 * reduce the hit points and strength of the critters.
	 */
	public void hit() {
		this.hitPoint--;
		this.strength--;
	}

	/***
	 * @return boolean true if the hitpoint of critter less or equal to 0, false
	 *         otherwise
	 */
	public boolean isDead() {
		return hitPoint <= 0;
	}

	/***
	 * @return int reward for the user when killing a critter
	 */
	public int getreward() {
		return reward;
	}

	/***
	 * @return int get the strength of the critter to remove coin to the user
	 */
	public int getStrength() {
		return strength;
	}

	/***
	 * @return int the speed of the critter dependent on the level
	 * */
	public int getSpeed() {
		return speed;
	}

	/***
	 * 
	 * @return the hit point of the critter
	 */
	public int getHitPoint() {
		return hitPoint;
	}

	/***
	 * Move the critter along the path
	 * 
	 * @param map
	 */
	private int i = 0;
	public void move() {
		//int adjust = 10;// adjust the display of the critters on the map
		
		this.setX(this.getX() + Value.pathCellSize);
		this.setY(path.get(i).posx + adjust );
		
		System.out.println("(" + getX() + "," + getY() + ")");
	}
	
	

	/********************** GETTERS AND SETTERS FOR THE COORDINATE OF A CRITTER ************************/
	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}
	
}
