package MapEditorGuiUtilityMethods;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import MapEditorDomain.Cell;
import MapEditorDomain.Map;
import MapEditorDomain.PathCell;
import MapEditorDomain.Value;
import MapEditorPresentation.IObserver;

public class GUIMap implements IObserver {
	private int worldWidth, worldHeight;
	private int blockSize = Value.pathCellSize; // adjusting blocksize depending
	private static GUICell block[][];
	public static GUICell firstCell;
	public static Map domainMap;
	private ArrayList<Cell> path;
	private static GUIMap map;
	public static String mode;
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
		if(Value.mapMode==0){
		setDomainMap(new Map(worldHeight, worldWidth,Value.userInputName));
		getDomainMap().setDefaultMap();
		}
		else{
			setDomainMap(new Map("savedMaps/"+Value.userInputName));
		}
		mode="SetPath"; //setting default action
		block = new GUICell[worldHeight][worldWidth];
		for (int y = 0; y < block.length; y++) {
			for (int x = 0; x < block[0].length; x++) {
				// setting path if it contains a tower or a cell
				int pathSet=determineTypeOfTile(y,x);
				block[y][x] = new GUICell(((GUIScreen.getMyWidth() / 2)
						- ((worldWidth * blockSize / 2)) + x * blockSize),
						(GUIScreen.getMyHeight() / 2)
								- ((worldHeight * blockSize / 2)) + y
								* blockSize, blockSize, blockSize, pathSet);
			}
		}
		//used in handler class to convert between GUIMap and domain Map.
		firstCell=block[0][0];
	}
	public static void executeAction(int x, int y){
		if(mode.equals("SetEntry")){
			if(domainMap.getCell(x, y) instanceof PathCell){
				try{
				domainMap.setEntryPoint(x, y);
				}
				catch(ArrayIndexOutOfBoundsException e){
					System.out.println("Clicked on edge of map");
				}
			}
			else{
				JOptionPane.showMessageDialog(null,"An Entry Cell Must be a Path Cell");
			}
		}
		else if(mode.equals("SetExit")){
			if(domainMap.getCell(x, y) instanceof PathCell){
				try{
				domainMap.setExitPoint(x, y);
				}
				catch(ArrayIndexOutOfBoundsException e){
					System.out.println("Clicked on edge of map");
				}
			}
			else{
				JOptionPane.showMessageDialog(null,"An Entry Cell Must be a Path Cell");
			}
		}
		else if(mode.equals("SetPath")){
			try{
				domainMap.setToPath(x, y);
			}
			catch(ArrayIndexOutOfBoundsException e){
				System.out.println("Clicked on edge of map");
			}
		}
		else{
			try{
			domainMap.setToScenery(x, y);
			}
			catch(ArrayIndexOutOfBoundsException e){
				System.out.println("Clicked on edge of map");
			}
		}
	}
	private int determineTypeOfTile(int x, int y){
		int pathSet=0;
		if (getDomainMap().getCell(x, y) instanceof PathCell) {
			pathSet = Value.path;
		} 
		else {
			pathSet = Value.grass;
		}
		if(domainMap.getCell(x, y).equals(domainMap.getEntryPoint())){
			pathSet=Value.entry;
		}
		if(domainMap.getCell(x, y).equals(domainMap.getExitPoint())){
			pathSet=Value.exit;
		}
		return pathSet;
	}
	public void update() {
		//reset the path cell/scenery cell
		for (int y = 0; y < block.length; y++) {
			for (int x = 0; x < block[0].length; x++) {
				// setting path if it contains a tower or a cell
				int pathSet=determineTypeOfTile(y,x);
				block[y][x] = new GUICell(((GUIScreen.getMyWidth() / 2)
						- ((worldWidth * blockSize / 2)) + x * blockSize),
						(GUIScreen.getMyHeight() / 2)
								- ((worldHeight * blockSize / 2)) + y
								* blockSize, blockSize, blockSize, pathSet);
			}
		}
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
