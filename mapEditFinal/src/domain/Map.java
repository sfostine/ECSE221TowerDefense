package domain;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import presentation.ConsoleMapEvents;
import presentation.IObserver;

public class Map {
	public String name;
	private Cell[][] grid;
	private int width, height;
	private PathCell entrypoint; // setter methods provided that account for
									// when the user may accidently assign a
									// scenery cell as the entry point
	private PathCell exitpoint;
	private List<IObserver> observers;

	public Map(String filePath){
		super();
		FileReader readFile;
			try {
				readFile = new FileReader(filePath);
				BufferedReader in= new BufferedReader(readFile);
				this.name=in.readLine();
				this.width=Integer.parseInt(in.readLine());
				this.height=Integer.parseInt(in.readLine());
				
				//setting up the map cells!
				grid=new Cell[width][height];
				for(int i=0;i<width;i++){
					int j=0;
					String row=in.readLine();
					while(j<this.height){
						char temp=row.charAt(2*j);
						if(temp=='P'){
							grid[i][j]=new PathCell(i,j);
						}
						else{
							grid[i][j]=new SceneryCell(i,j);
						}
						j++;
					}
				}
				this.entrypoint=(PathCell) this.getCell(Integer.parseInt(in.readLine()), Integer.parseInt(in.readLine()));
				this.exitpoint=(PathCell) this.getCell(Integer.parseInt(in.readLine()), Integer.parseInt(in.readLine()));
			} catch (FileNotFoundException e) {
			} catch (IOException e) {
				e.printStackTrace();
			} 
			observers=new ArrayList<IObserver>();
	}
	public Map(int width, int height,String nameM) {
		// intializing an empty grid with given length and width.
		setGrid(new Cell[width][height]);
		this.name=nameM;
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				getGrid()[i][j] = new SceneryCell(i, j);
			}
		}
		this.setWidth(width);
		this.setHeight(height);
		observers = new ArrayList<IObserver>();
	}

	// setting a cell to a path cell in the map.
	public void setToPath(int posx, int posy) {
		if (!(getGrid()[posx][posy] instanceof PathCell)) {
			getGrid()[posx][posy] = new PathCell(posx, posy);
		}
		notifyObservers();
	}

	// setting a cell to a scenery cell in the path.
	public void setToScenery(int posx, int posy) {
		if (!(getGrid()[posx][posy] instanceof SceneryCell)) {
			getGrid()[posx][posy] = new SceneryCell(posx, posy);
		}
		notifyObservers();
	}

	// getter method for a particular cell in the array.
	public Cell getCell(int posx, int posy) {
		return getGrid()[posx][posy];
	}

	// setting the entry point on a map.
	public boolean setEntryPoint(int posx, int posy) {
		if (getGrid()[posx][posy] instanceof PathCell) {
			this.entrypoint = (PathCell) getGrid()[posx][posy];
			notifyObservers();
			return true;
		} else {
			System.out.println("Error, only path cells can be the entry point");
			notifyObservers();
			return false;
		}
	}

	// setting the exit point on a map.
	public boolean setExitPoint(int posx, int posy) {
		if (getGrid()[posx][posy] instanceof PathCell) {
			this.exitpoint = (PathCell) getGrid()[posx][posy];
			notifyObservers();
			return true;
		} else {
			System.out
					.println("Error, only path cells can be the exit point,nothing has been changed");
			return false;
		}
	}

	private void setCellToTower(int i, int j) {
		if (getGrid()[i][j] instanceof SceneryCell) {
			((SceneryCell) getGrid()[i][j]).setTower(new Tower());
		} else {
			System.out.println("Not a SceneryCell");
		}
		notifyObservers();
	}

	// creates a default path for ease of testing
	public void setDefaultMap() {
		for (int i = 0; i < getWidth(); i++) {
			for (int j = 0; j < getHeight(); j++) {
				getGrid()[i][j] = new SceneryCell(i, j);
				if (i == ((this.getWidth() / 2))) {
					getGrid()[i][j] = new PathCell(i, j);
					if (j == 0) {
						this.entrypoint = (PathCell) getGrid()[i][j];
					}
					if (j == getHeight() - 1) {
						this.exitpoint = (PathCell) getGrid()[i][j];
					}
				}
			}
		}
		this.notifyObservers();
	}

	// utility method to print out a representation of the map.
	/*
	 * Assumed Conditions for a valid Map. 1) Entry and exit point are on the
	 * edge of the grid, are path cells and are not the same cell. 2) Except for
	 * the entry and exit points, each path cell has at least one other path
	 * cell that has not already been visited and that is connected to it. 3) If
	 * the last cell in the check is not the exit point, the check fails. 4) The
	 * path successfully connects the entry and exit points sequentially. 5) All
	 * PathCells must be along the path.(no unconnected random cells. ) 6)No
	 * loops from the entry point to the exit point.
	 */
	// ensures that the assumed conditions of a valid map are met.
	public boolean verifyMap() {
		if (this.checkEntryAndExit() == false) {
			return false;
		}
		if (this.findPath() == null) {
			return false;
		} else {
			return true;
		}
	}

	// helper method to get adjacent cells in a map.
	private ArrayList<Cell> getAdjCells(Cell currentCell) {
		ArrayList<Cell> adjList = new ArrayList<Cell>();
		if (currentCell.getPosx() - 1 >= 0) {
			adjList.add(this.getCell(currentCell.getPosx() - 1,
					currentCell.getPosy()));
		}
		if (currentCell.getPosx() + 1 <= getWidth() - 1) {
			adjList.add(this.getCell(currentCell.getPosx() + 1,
					currentCell.getPosy()));
		}
		if (currentCell.getPosy() - 1 >= 0) {
			adjList.add(this.getCell(currentCell.getPosx(),
					currentCell.getPosy() - 1));
		}
		if (currentCell.getPosy() + 1 <= getHeight() - 1) {
			adjList.add(this.getCell(currentCell.getPosx(),
					currentCell.getPosy() + 1));
		}
		return adjList;
	}

	// helper method that checks to see if entry and exit points are on the edge
	// of the map.
	private boolean checkEntryAndExit() {
		if (this.entrypoint == null || this.exitpoint == null) {
			System.out
					.println("Do not forget to set the entry and exit points");
			return false;
		}
		if (this.entrypoint == this.exitpoint) {
			return false;
		}
		boolean onEdge = true;
		if ((this.entrypoint.getPosx() != 0)
				&& (this.entrypoint.getPosx() != getWidth() - 1)
				&& (this.entrypoint.getPosy() != 0)
				&& (this.entrypoint.getPosy() != getHeight() - 1)) {
			onEdge = false;
		}

		if ((this.exitpoint.getPosx() != 0)
				&& (this.exitpoint.getPosx() != getWidth() - 1)
				&& (this.exitpoint.getPosy() != 0)
				&& (this.exitpoint.getPosy() != getHeight() - 1)) {
			onEdge = false;
		}
		return onEdge;
	}

	// helper method to set all cells in a grid to unvisited so that the
	// findPath algorithm works appropriately.
	private void setUnvisited() {
		for (int i = 0; i < this.getWidth(); i++) {
			for (int j = 0; j < this.getHeight(); j++) {
				this.getGrid()[i][j].setChecked(false);
			}
		}
	}

	// method that determines if there is a single, unique and appropriate path
	// following the rules stated above the method "verify method"
	public ArrayList<Cell> findPath() {
		// setting all cells as unvisited
		setUnvisited();
		// creating an arraylist which will store the proposed path.
		ArrayList<Cell> proposedPath = new ArrayList<Cell>();
		// starting at the entrypoint for the path.
		Cell tempCell = this.entrypoint;
		// continue looping until we reach the exitpoint
		while (!tempCell.equals(exitpoint)) {
			// using the helper method we get all adj cells
			ArrayList<Cell> adjCells = this.getAdjCells(tempCell);
			Iterator itrAdj = adjCells.iterator();
			int count = 0;
			// getting a count of the number of adj cells next to the current
			// cell that are path cells.
			while (itrAdj.hasNext()) {
				if (itrAdj.next() instanceof PathCell) {
					count++;
				}
			}
			// if there are more than two path cells, then we will return a null
			// arraylist as this isn't a valid path
			if (count == 2 || (count == 1 && tempCell.equals((entrypoint)))) {
			} else {
				return null;
			}
			// iterate through all the adjacent cells again and find the cell
			// that has not been visited. Once you find that cell, add the
			// current cell to the proposed path, mark it as visited and move on
			// to the next cell.
			itrAdj = adjCells.iterator();
			while (itrAdj.hasNext()) {
				Cell tempCell2 = (Cell) itrAdj.next();
				if ((tempCell2 instanceof PathCell)
						&& tempCell2.isChecked() == false) {
					tempCell.setChecked(true);
					proposedPath.add(tempCell);
					tempCell = tempCell2;
				}
			}
		}
		// adding the last cell (should be the exit cell) in the map.
		proposedPath.add(tempCell);
		// checking if there are other path cells that have been placed 1 square
		// or more away from the path. If so, they will not be in the proposed
		// path and we will return a null arraylist.
		for (int i = 0; i < this.getWidth(); i++) {
			for (int j = 0; j < this.getHeight(); j++) {
				if (this.getGrid()[i][j] instanceof PathCell
						&& !proposedPath.contains(this.getGrid()[i][j])) {
					return null;
				}
			}
		}
		// everything checks out, let's return our proposed Path!
		return proposedPath;
	}
	public int saveMap(){
		
		if(verifyMap()){
		String fileName=this.name;
		PrintWriter writer;
		try {
			writer=new PrintWriter("savedMaps/"+fileName,"UTF-8");
			writer.println(this.name);
			writer.println(this.width);
			writer.println(this.height);
			//prints out the string representation of each cell (path or scenery)
			for(int i=0;i<width;i++){
				for(int j=0;j<height;j++){
					writer.print(grid[i][j].toString());
					if(j!=height-1){
					writer.print(",");
					}
				}
				writer.println("");
			}
			writer.println(this.entrypoint.posx);
			writer.println(this.entrypoint.posy);
			writer.println(this.exitpoint.posx);
			writer.println(this.exitpoint.posy);
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return -2;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return -3;
		}
		}
		else{
			System.out.println("Map not valid can not be saved");
			return -1;
		}
		return 0;
	}
	// utility method to help
	public void addObserver(IObserver o) {
		observers.add(o);
	}

	public void removeObserver(IObserver o) {
		observers.remove(o);
	}

	protected void notifyObservers() {
		for (IObserver o : observers) {
			o.update();
		}
	}

	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * @return the grid
	 */
	public Cell[][] getGrid() {
		return grid;
	}

	/**
	 * @param grid the grid to set
	 */
	public void setGrid(Cell[][] grid) {
		this.grid = grid;
	}
	public PathCell getEntryPoint(){
		return this.entrypoint;
	}
	public PathCell getExitPoint(){
		return this.exitpoint;
	}
}
