package guiUtilityMethods;

import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.ArrayList;

import domain.Map;
import presentation.ConsoleMapEvents;
import presentation.IObserver;
import domain.Cell;
import domain.PathCell;
import domain.Value;

public class GUIMap implements IObserver {
	private int worldWidth, worldHeight;
	private int blockSize = Value.getPathCellSize(); // adjusting blocksize depending
												// on input
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
		worldWidth = Value.getWidth();
		worldHeight = Value.getHeight();
	
		setDomainMap(new Map(worldHeight, worldWidth));
		ConsoleMapEvents theGuiMap = new ConsoleMapEvents(getDomainMap());
		getDomainMap().addObserver(theGuiMap);
		getDomainMap().setDefaultMap();

		path = getDomainMap().findPath();
		block = new GUICell[worldHeight][worldWidth];

		for (int y = 0; y < block.length; y++) {
			for (int x = 0; x < block[0].length; x++) {
				// setting path if it contains a tower or a cell
				int pathSet;
				if (getDomainMap().getCell(y, x) instanceof PathCell) {
					pathSet = Value.getPath();
				} else {
					pathSet = Value.getGrass();
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

}
