/***
 * @author Samuel Fostine
 * Date of modification : March 28, 2015
 * This class contains all the attributes of a critter 
 * and the functions that will be used to access or modify the attributes 
 * it implements the critter observer for the pattern
 * */
package CritterFactory;

import guiUtilityMethods.GUIMap;

import java.util.ArrayList;

import domain.Cell;
import domain.Value;

public class Critter {

	// private attributes to each critter
	private int reward, hitPoint, strength, level, speed;
	private int pre_hitPoint;

	// coordinate of critters
	private int x, y;

	// position of the critters
	private ArrayList<Cell> path;

	// map
	private GUIMap map;
	private int adjust = 25;

	// NB: attributes are dependent on the game level
	public Critter(int gameLevel) {
		map = GUIMap.getMap();
		this.level = gameLevel;
		this.reward = gameLevel;
		this.hitPoint = gameLevel + 1;
		this.pre_hitPoint = hitPoint;
		this.strength = gameLevel + 1;
		this.speed = gameLevel * 3 + 1;
		path = map.getDomainMap().findPath();

		this.x = path.get(0).getPosy() * Value.getPathCellSize();
		this.y = path.get(0).getPosx() * Value.getPathCellSize() + adjust;


	}

	/***
	 * the update method when notifying
	 */

	/***
	 * reduce the hit points and strength of the critters.
	 */
	public void hit(int val) {
		this.hitPoint -= val ;
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

	public void move(int dist) {

		if (i >= Value.getWidth()) {
			this.setX(this.getX() + Value.getPathCellSize());
			return;
		}

		this.setX(this.path.get(i).getPosy() * Value.getPathCellSize() + adjust + dist);
		this.setY(this.path.get(i++).getPosx() * Value.getPathCellSize() + adjust);

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
