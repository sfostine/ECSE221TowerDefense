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

public class GUIMap implements IObserver{
	public int worldWidth=Value.getWindowWidth(), worldHeight;
	public int blockSize = Value.pathCellSize; // adjusting blocksize depending on input
	public GUICell block[][];
	public Map domainMap;
	ArrayList<Cell> path;
	
	private static GUIMap map;
	//predefined size for the map, will adjust for various map sizes
	private GUIMap(){
		initGUIMap();
	}
	
	public static GUIMap getMap()
	{
		if(map ==null){
			map = new GUIMap();
		}
		return map;
	}
	
	private void initGUIMap(){
		worldWidth = Value.width;
		worldHeight = Value.height;
		
		domainMap = new Map(worldHeight,worldWidth);
		ConsoleMapEvents theGuiMap = new ConsoleMapEvents(domainMap);
		domainMap.addObserver(theGuiMap);
		domainMap.setDefaultMap();
		
		path = domainMap.findPath();
		
		for(Object o : path)
			System.out.println(o);
		
		
		block = new GUICell[worldHeight][worldWidth];
		
		for(int y=0;y<block.length;y++){
			for(int x=0;x<block[0].length;x++){
				//setting path if it contains a tower or a cell
				int pathSet;
				if(domainMap.getCell(y, x) instanceof PathCell){
					pathSet=Value.path;
				}
				else{
					pathSet=Value.grass;
				}
				block[y][x]=new GUICell(((GUIScreen.myWidth/2)-((worldWidth*blockSize/2))+x*blockSize),(GUIScreen.myHeight/2)-((worldHeight*blockSize/2))+y*blockSize,blockSize,blockSize,pathSet);
			}
		}
	}
	
	
	public void update(){
		draw(GUIScreen.getGuiScreen().graphics);
	}
	
	public void draw(Graphics g){
		for(int y = 0;y<block.length;y++){
			for(int x=0;x<block[0].length;x++){
				block[y][x].drawCell(g);
			}
		}
		Toolkit.getDefaultToolkit().sync();
	}
	
	public static void main(String [] args)
	{
		Value.setWindowHeight(100);
		Value.setWindowWidth(100);
		GUIMap m = new GUIMap();
		/*for(Cell o : m.path)
			System.out.println("(" + o.posy + "," + o.posx + ")");*/
		
	}
}
