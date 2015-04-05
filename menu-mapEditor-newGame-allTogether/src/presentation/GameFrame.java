package presentation;
//Xu Ji 260562839

import Domain.GUIFrame;
import Domain.getUserInput;

import javax.swing.*;

import Domain.GUIScreen;
import Domain.Value;

import java.awt.*;

public class GameFrame{
 
 //Declare variables
 static int windowWidth = 1000;
 static int windowHeight = 618;
 final static JFrame frame = new JFrame("Welcome");
// static MapPanel mapPanel;
 static GUIScreen mapPanel;
 static ButtonPanel buttonPanel;
 
 //Constructor
 public GameFrame(){
	 Value.setWindowHeight(Value.pathCellSize * getUserInput.getInput("String", "Please enter how many row you want", 3, 14));
		Value.setWindowWidth(Value.pathCellSize * getUserInput.getInput("String", "Please enter how many column you want", 4, 16));

  //Build a JFrame which contains JPanels and JButtons to compose the main GUI
  //frame.setSize(windowWidth, windowHeight);
		frame.setSize(Value.getWindowWidth()+160, Value.getWindowHeight()+22);
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
  mapPanel = GUIScreen.getGuiScreen();
  
  mapPanel.setPreferredSize(new Dimension(Value.getWindowWidth(), Value.getWindowHeight()));

  buttonPanel = new ButtonPanel();
  buttonPanel.setPreferredSize(new Dimension(160, Value.getWindowHeight()));

  frame.add(buttonPanel, BorderLayout.EAST);
  frame.add(mapPanel, BorderLayout.WEST);
    
  frame.setVisible(true);
  
    
 }
 
 public static GUIScreen getGUIScreen(){ return mapPanel; }
 
}

 
