package Domain;

import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.ArrayList;

import Domain.Cell;
import Domain.Map;
import Domain.PathCell;
import Domain.Value;
import Domain.GUICell;
import presentation.ConsoleMapEvents;
import presentation.IObserver;


public class GUIMap implements IObserver {
	private int worldWidth, worldHeight;
	private int blockSize = Value.pathCellSize; // adjusting blocksize depending
												// on input
	public static GUICell firstCell;
	private GUICell block[][];
	private Map domainMap;
	private ArrayList<Cell> path;
	private static GUIMap map;

	// predefined size for the map, will adjust for various map sizes
	private GUIMap() {
		initGUIMap();
	}

	public static GUIMap getMap() {
		if (map == null) {
			map = new GUIMap();
		}
		return map;
	}

	private void initGUIMap() {
		worldWidth = Value.width;
		worldHeight = Value.height;
		//setDomainMap(new Map(worldHeight, worldWidth, Value.userInputName));
//		getDomainMap().addObserver(theGuiMap);
		setDomainMap(new Map("savedMaps/"+Value.userInputName));
		path = getDomainMap().findPath();
		block = new GUICell[worldHeight][worldWidth];

		for (int y = 0; y < block.length; y++) {
			for (int x = 0; x < block[0].length; x++) {
				// setting path if it contains a tower or a cell
				int pathSet;
				if (getDomainMap().getCell(y, x) instanceof PathCell) {
					pathSet = Value.path;
				} else {
					pathSet = Value.grass;
				}
				block[y][x] = new GUICell(((GUIScreen.getMyWidth() / 2)
						- ((worldWidth * blockSize / 2)) + x * blockSize),
						(GUIScreen.getMyHeight() / 2)
								- ((worldHeight * blockSize / 2)) + y
								* blockSize, blockSize, blockSize, pathSet);
			}
		}
	}

	public void update() {
		draw(GUIScreen.getGuiScreen().graphics);
	}

	public void draw(Graphics g) {
		for (int y = 0; y < block.length; y++) {
			for (int x = 0; x < block[0].length; x++) {
				block[y][x].drawCell(g);
			}
		}
		Toolkit.getDefaultToolkit().sync();
	}

	/**
	 * @return the domainMap
	 */
	public Map getDomainMap() {
		return domainMap;
	}

	/**
	 * @param domainMap
	 *            the domainMap to set
	 */
	public void setDomainMap(Map domainMap) {
		this.domainMap = domainMap;
	}
	
	public GUICell getOffSet(){ return block[0][0]; }

}
