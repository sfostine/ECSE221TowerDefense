package presentation;
//Xu Ji 260562839

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Domain.Bow;
import Domain.Cannon;
import Domain.Rocket;
import Domain.Tower;
import presentation.TowerCannonGUI;
import presentation.TowerRocketGUI;
import presentation.TowerBowGUI;

public class GameFrame implements MouseListener{
 
 //Declare variables
 static int windowWidth = 1000;
 static int windowHeight = 618;
 final static JFrame frame = new JFrame("Welcome");
 final JPanel mapPanel;
 final JPanel buttonPanel;
 final JLabel label1;
 final JButton buttonCannon;
 final JButton buttonRocket;
 final JButton buttonBow;
 boolean isBuildCannon = false;
 boolean isBuildRocket = false;
 boolean isBuildBow = false;
 
 //Constructor
 public GameFrame(){
  //Build a JFrame which contains JPanels and JButtons to compose the main GUI
  frame.setSize(windowWidth, windowHeight);
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
  this.mapPanel = new JPanel();
  this.buttonPanel = new JPanel();
  this.mapPanel.setPreferredSize(new Dimension(windowWidth-200, windowHeight));
  this.mapPanel.setLayout(null);
  this.mapPanel.setBackground(Color.YELLOW);
  this.mapPanel.addMouseListener(this);
  buttonPanel.setPreferredSize(new Dimension(200, windowHeight));
  buttonPanel.setBackground(Color.WHITE);
  
  label1 = new JLabel("Choose your tower");
  
  //Add Cannon button with its ActionListener
  buttonCannon = new JButton("Cannon");
  ActionListener button1Action = new ActionListener(){
   public void actionPerformed(ActionEvent e){
    label1.setText("<html>Please click on the map <br> to put your tower</html>");
    isBuildCannon = true;
   }
  };
  buttonCannon.addActionListener(button1Action);
  
  buttonRocket = new JButton("Rocket");
  ActionListener button2Action = new ActionListener(){
   public void actionPerformed(ActionEvent e){
    label1.setText("<html>Please click on the map <br> to put your tower</html>");
    isBuildRocket = true;
   }
  };
  buttonRocket.addActionListener(button2Action);
  
  buttonBow = new JButton("Bow");
  ActionListener button3Action = new ActionListener(){
   public void actionPerformed(ActionEvent e){
    label1.setText("<html>Please click on the map <br> to put your tower</html>");
    isBuildBow = true;
   }
  };
  buttonBow.addActionListener(button3Action);
  
  //Add those components on the GUI
  buttonPanel.add(label1);
  buttonPanel.add(buttonCannon);
  buttonPanel.add(buttonRocket);
  buttonPanel.add(buttonBow);
  label1.setBounds(38, 518, 124, 40);

  frame.add(mapPanel, BorderLayout.WEST);
  frame.add(buttonPanel, BorderLayout.EAST);
  
  label1.setLocation(0, 0);
  
  frame.setVisible(true);
  
    
 }

 
 //buildTower method takes two int which represents the position
 //build a tower object and towerGUI object
 //link towerGUI to tower as an observer
 public void buildTower(int x, int y){
  if (isBuildCannon){
   Tower a = new Cannon(1);
   TowerCannonGUI ag = new TowerCannonGUI(a, this, x, y);
   a.addObserver(ag);
  }else if (isBuildRocket){
   Tower a = new Rocket(1);
   TowerRocketGUI ag = new TowerRocketGUI(a, this, x, y);
   a.addObserver(ag);
  }else if (isBuildBow){
   Tower a = new Bow(1);
   TowerBowGUI ag = new TowerBowGUI(a, this, x, y);
   a.addObserver(ag);
  }else{
   System.out.println("wrong type of tower");
  }
 }
 

 @Override
 //Once the mapPanel detects a mouse click
 //it calls buildTower method if isBuildTower is also true
 public void mouseClicked(MouseEvent e) {
  // TODO Auto-generated method stub
  if(isBuildCannon || isBuildRocket || isBuildBow){
   this.buildTower(e.getX(), e.getY());
   System.out.println("mouse clicked " + e.getX() + e.getY());
  }
 }

 @Override
 public void mousePressed(MouseEvent e) {
  // TODO Auto-generated method stub
 }

 @Override
 public void mouseReleased(MouseEvent e) {
  // TODO Auto-generated method stub
  
 }

 @Override
 public void mouseEntered(MouseEvent e) {
  // TODO Auto-generated method stub
  
 }

 @Override
 public void mouseExited(MouseEvent e) {
  // TODO Auto-generated method stub
 }
}


