package presentation;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ButtonPanel extends JPanel{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//	final JPanel buttonPanel;
	 final JLabel label1;
	 final JButton buttonCannon;
	 final JButton buttonRocket;
	 final JButton buttonBow;
	 static boolean isBuildCannon = false;
	 static boolean isBuildRocket = false;
	 static boolean isBuildBow = false;
	 
	 public ButtonPanel(){
		 
//		  this.buttonPanel = new JPanel();
		  this.setBackground(Color.WHITE);
		  
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
		  this.add(label1);
		  this.add(buttonCannon);
		  this.add(buttonRocket);
		  this.add(buttonBow);
		  label1.setBounds(38, 518, 124, 40);
	 }
	 
	 public ButtonPanel getButtonPanel(){ return this; }
}
