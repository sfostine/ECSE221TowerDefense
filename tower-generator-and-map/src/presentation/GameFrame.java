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
	 Value.setWindowHeight(getUserInput.getInput("Please enter the height"));
		Value.setWindowWidth(getUserInput.getInput("Please enter the width"));

  //Build a JFrame which contains JPanels and JButtons to compose the main GUI
  //frame.setSize(windowWidth, windowHeight);
		frame.setSize(Value.getWindowWidth()+200, Value.getWindowHeight());
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
  mapPanel = GUIScreen.getGuiScreen();
  
  mapPanel.setPreferredSize(new Dimension(Value.getWindowWidth(), Value.getWindowHeight()));

  buttonPanel = new ButtonPanel();
  buttonPanel.setPreferredSize(new Dimension(200, Value.getWindowHeight()));

  frame.add(buttonPanel, BorderLayout.EAST);
  frame.add(mapPanel, BorderLayout.WEST);
    
  frame.setVisible(true);
  
    
 }
}

 
