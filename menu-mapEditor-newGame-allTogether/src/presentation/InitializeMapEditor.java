package presentation;

import java.io.File;
import java.util.ArrayList;

import Domain.GUIFrame;
import Domain.getUserInput;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import Domain.Map;
import Domain.Value;

public class InitializeMapEditor {
	private static ImageIcon logo = new ImageIcon("src/repo/logo.jpg");
	public InitializeMapEditor(){
		String[] options={"Load Map", "New Map"};
		int newGameOrLoad=JOptionPane.showOptionDialog(null,"Would you like to start a new map or edit an old one?","Map Editor",JOptionPane.INFORMATION_MESSAGE,0,logo,options,0);
		
		// if they decide to cancel.
		if(newGameOrLoad==-1){
			System.exit(-1);
		}
		//execute the new map method to start a new map
		else if(newGameOrLoad==1){
			Value.mapMode=0;
			newMap();
		}
		
		//execute the load map method to load an old map
		else{
			Value.mapMode=1;
			loadMap();
		}
		// in both cases we initialize a new frame. 
		GUIFrame frame = GUIFrame.getInstance();
	}

	public static void newMap(){
		Value.userInputName=(String) JOptionPane.showInputDialog(null,"Please Enter the Name of your Map","Map Name",JOptionPane.INFORMATION_MESSAGE,logo,null,"");
		//exit in case where the user doesn't input anything.
		if(Value.userInputName==null){
			System.exit(-1);
		}
		
		Value.setWindowHeight(getUserInput.getInput("Height","Please enter the height of your map:"+"("+Value.minHeight+"-"+Value.maxHeight+")", Value.minHeight,Value.maxHeight));
		Value.setWindowWidth(getUserInput.getInput("Width","Please enter the width of your map:"+"("+Value.minWidth+"-"+Value.maxWidth+")",Value.minWidth,Value.maxWidth));
	}
	
	public static ArrayList<String> getFileNamesInFolder(String folder){
		File folderA = new File(folder);
		File[] listOfFiles=folderA.listFiles();
		ArrayList<String> files=new ArrayList<String>();
		for(int i=0;i<listOfFiles.length;i++){
			if(!listOfFiles[i].isHidden()){
			files.add(listOfFiles[i].getName());
			}
		}
		return files;
	}
	public static void loadMap(){
		ArrayList<String>fileNames=getFileNamesInFolder("savedMaps");
		fileNames.add(0,"New Map");
		String[] list=new String[fileNames.size()];
		list=fileNames.toArray(list);
		int chosenFile=JOptionPane.showOptionDialog(null, "What map would you like to edit?", "Loading a Map", JOptionPane.INFORMATION_MESSAGE,0, logo, list, 0);
		if(chosenFile!=0){
		String loadFile=list[chosenFile];
		Map tempDomainMap=new Map("savedMaps/"+loadFile);
		Value.userInputName=tempDomainMap.name;
		Value.setWindowWidth(tempDomainMap.getHeight()*Value.pathCellSize);
		Value.setWindowHeight(tempDomainMap.getWidth()*Value.pathCellSize);
		}
		else{
			Value.mapMode=0;
			newMap();
		}
	}
}
