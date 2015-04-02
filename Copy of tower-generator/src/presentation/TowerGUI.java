package presentation;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;

import Domain.StrongestCritterStrategy;
import Domain.Tower;
import Domain.IObserver;
import Domain.WeakestCritterStrategy;
import Domain.nearestCritterExitPointStrategy;
import Domain.nearestCritterStrategy;
import presentation.GameFrame;

public abstract class TowerGUI implements IObserver{

 //Declare variables
 private Tower observedTower;
 private JButton buttonUpgrade;
 private JButton buttonSell;
 private JButton buttonStrategy;
 private JButton tower;
 
 //Constructor
 public TowerGUI(Tower observedTower, final GameFrame mainWindow, int x, int y){
  super();
  this.observedTower = observedTower;
  
  //Declare towerGUI as a JButton and add ActionListener on it
  ActionListener towerButtonAction = new ActionListener(){
   @Override
   public void actionPerformed(ActionEvent e){
    mainWindow.label1.setText("<html>Upgrade or sell <br> your tower</html>");
    mainWindow.buttonCannon.setVisible(false);
    mainWindow.buttonRocket.setVisible(false);
    mainWindow.buttonBow.setVisible(false);
    addUpdateButton(mainWindow);
    addSellButton(mainWindow);
    addStrategyButton(mainWindow);
    mainWindow.buttonPanel.add(buttonUpgrade);
    mainWindow.buttonPanel.add(buttonSell);
    mainWindow.buttonPanel.add(buttonStrategy);
   }
  };
  tower = new JButton();
  tower.addActionListener(towerButtonAction);
  
  //Initial button image
  try {
      Image img = ImageIO.read(GameFrame.class.getResource("/Image/tower1.jpeg")).getScaledInstance( 100, 100, Image.SCALE_SMOOTH );
      tower.setIcon(new ImageIcon(img));
    } catch (IOException e) {
     System.out.println("no image founded");
    }
  
  //Add button to the map at a specific position
  mainWindow.mapPanel.add(tower);
  tower.setBounds(x-25, y-25, 50, 50);
  mainWindow.label1.setText("Choose your tower");
  mainWindow.buttonCannon.setVisible(true);
  mainWindow.buttonRocket.setVisible(true);
  mainWindow.buttonBow.setVisible(true);
  
  //Disable isBuildTower
  mainWindow.isBuildCannon = false;
  mainWindow.isBuildRocket = false;
  mainWindow.isBuildBow = false;  
  JOptionPane.showMessageDialog(mainWindow.mapPanel, "Click the tower to upgrade or sell.");
 }
 
 //Create a update button under tower button and add is to the mainWindow
 public void addUpdateButton(final GameFrame mainWindow){
  ActionListener upgradeButtonAction = new ActionListener(){
   @Override
   public void actionPerformed(ActionEvent e){
    int n = JOptionPane.showConfirmDialog(null, "Are you sure you want to upgrade?", "Confirm", JOptionPane.YES_NO_OPTION);
    if(n == 0){
     observedTower = observedTower.upgrade();
     System.out.println(observedTower.getDescription());
     System.out.println("upgrade yes");
    }else{
     System.out.println("upgrade no");
    }
    mainWindow.label1.setText("Choose your tower");
    mainWindow.buttonCannon.setVisible(true);
    mainWindow.buttonRocket.setVisible(true);
    mainWindow.buttonBow.setVisible(true);
    buttonUpgrade.setVisible(false);
    buttonSell.setVisible(false);
    buttonStrategy.setVisible(false);
   }
  };
  buttonUpgrade = new JButton("Upgrade");
  buttonUpgrade.addActionListener(upgradeButtonAction);
  buttonUpgrade.setVisible(true);
 }
 
 //Create a update sell under tower button and add is to the mainWindow
 public void addSellButton(final GameFrame mainWindow){
  ActionListener SellButtonAction = new ActionListener(){
   @Override
   public void actionPerformed(ActionEvent e){
    int n = JOptionPane.showConfirmDialog(null, "Are you sure you want to sell it?", "Confirm", JOptionPane.YES_NO_OPTION);
    if(n == 0){
     System.out.println("sell yes");
     tower.setVisible(false);
    }else{
     System.out.println("sell no");
    }
    mainWindow.label1.setText("Choose your tower");
    mainWindow.buttonCannon.setVisible(true);
    mainWindow.buttonRocket.setVisible(true);
    mainWindow.buttonBow.setVisible(true);
    buttonUpgrade.setVisible(false);
    buttonSell.setVisible(false);
    buttonStrategy.setVisible(false);
   }
  };
  buttonSell = new JButton("Sell");
  buttonSell.addActionListener(SellButtonAction);
  buttonSell.setVisible(true);
 }
 
 public void addStrategyButton(final GameFrame mainWindow){
  ActionListener StrategyButtonAction = new ActionListener(){
   @Override
   public void actionPerformed(ActionEvent e){
    JList<?> list = new JList<Object>(new String[] {"Nearest strategy", "nearest critter to the exit point", " strongest critter", "weakest critter"});
    JOptionPane.showMessageDialog(
      null, list, "Choose tower strategy", JOptionPane.PLAIN_MESSAGE);
    String temp = Arrays.toString(list.getSelectedIndices());
    if(temp.equals("[0]")){
    	observedTower.setStrategy(new nearestCritterStrategy());
    	observedTower.performStrategy();
    }else if(temp.equals("[1]")){
    	observedTower.setStrategy(new nearestCritterExitPointStrategy());
    	observedTower.performStrategy();
    }if(temp.equals("[2]")){
    	observedTower.setStrategy(new StrongestCritterStrategy());
    	observedTower.performStrategy();
    }if(temp.equals("[3]")){
    	observedTower.setStrategy(new WeakestCritterStrategy());
    	observedTower.performStrategy();
    }
    
    mainWindow.label1.setText("Choose your tower");
    mainWindow.buttonCannon.setVisible(true);
    mainWindow.buttonRocket.setVisible(true);
    mainWindow.buttonBow.setVisible(true);
    buttonUpgrade.setVisible(false);
    buttonSell.setVisible(false);
    buttonStrategy.setVisible(false);
   }
  };
  buttonStrategy = new JButton("Strategy");
  buttonStrategy.addActionListener(StrategyButtonAction);
  buttonStrategy.setVisible(true);
 }
 
 //Get notified and update graphic
 @Override
 public void update(){
  try {
   Image img = null;
   if (observedTower.getLevel() == 1){
       img = ImageIO.read(GameFrame.class.getResource("/Image/tower1.jpeg")).getScaledInstance( 100, 100, Image.SCALE_SMOOTH ) ;
   }else if(observedTower.getLevel() == 2){
       img = ImageIO.read(GameFrame.class.getResource("/Image/tower2.jpeg")).getScaledInstance( 100, 100, Image.SCALE_SMOOTH ) ;
   }else{
       img = ImageIO.read(GameFrame.class.getResource("/Image/tower3.jpeg")).getScaledInstance( 100, 100, Image.SCALE_SMOOTH ) ; ;

   }
      tower.setIcon(new ImageIcon(img));
    } catch (IOException e) {
    }
  
  System.out.println("observer works" + observedTower.getRange());
 }

}










