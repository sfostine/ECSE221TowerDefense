package presentation;
//Xu Ji 260562839

import javax.swing.*;
import java.awt.*;

public class GameFrame{
 
 //Declare variables
 static int windowWidth = 1000;
 static int windowHeight = 618;
 final static JFrame frame = new JFrame("Welcome");
 static MapPanel mapPanel;
 static ButtonPanel buttonPanel;
 
 //Constructor
 public GameFrame(){
  //Build a JFrame which contains JPanels and JButtons to compose the main GUI
  frame.setSize(windowWidth, windowHeight);
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
  mapPanel = new MapPanel();
  mapPanel.setPreferredSize(new Dimension(windowWidth-200, windowHeight));

  buttonPanel = new ButtonPanel();
  buttonPanel.setPreferredSize(new Dimension(200, windowHeight));


  frame.add(mapPanel, BorderLayout.WEST);
  frame.add(buttonPanel, BorderLayout.EAST);
    
  frame.setVisible(true);
  
    
 }
}

 
