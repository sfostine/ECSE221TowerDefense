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
// static int windowWidth = 1000;
// static int windowHeight = 618;
 final static JFrame frame = new JFrame("Welcome");
// static MapPanel mapPanel;
 static GUIScreen mapPanel;
 static ButtonPanel buttonPanel;
 
 //Constructor
 public GameFrame(){
	 //Value.setWindowHeight(getUserInput.getInput("Please enter the height you want"));
		//Value.setWindowWidth(getUserInput.getInput("Please enter the width you want"));

  //Build a JFrame which contains JPanels and JButtons to compose the main GUI
  frame.setSize(Value.getWindowWidth()+160, Value.getWindowHeight()+20);
		//frame.setSize(Value.getWindowWidth()+160, Value.getWindowHeight()+22);
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
  mapPanel = GUIScreen.getGuiScreen();
  
  mapPanel.setPreferredSize(new Dimension(Value.getWindowWidth(), Value.getWindowHeight()));

  buttonPanel = new ButtonPanel();
  buttonPanel.setPreferredSize(new Dimension(160, Value.getWindowHeight()));

  frame.add(buttonPanel, BorderLayout.EAST);
  frame.add(mapPanel, BorderLayout.WEST);
    
  frame.setVisible(true);  
 }
 
 public GameFrame(int width, int height){
	 
	 frame.setSize(width, height);
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

 
