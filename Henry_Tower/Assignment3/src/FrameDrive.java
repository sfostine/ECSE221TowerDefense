import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class FrameDrive extends JFrame{
	JPanel p = new JPanel();
	
	public static void main(String args[]){
		new FrameDrive();
	}
	public FrameDrive(){
		super("Assignment2");
		setSize(900,300);// The size of the frame
		setResizable(false);// The size of the frame is fixe
		setDefaultCloseOperation(EXIT_ON_CLOSE);// close the window when clicked on the X 
		int result = JOptionPane.showConfirmDialog(null, "Do you want to Create Towers",null, JOptionPane.YES_NO_OPTION);// The start of the game 
		if(result == JOptionPane.YES_OPTION){
			p.setLayout(new GridLayout(1, 3, 3, 3));
			FireTowerButton button1 = new FireTowerButton();// button to create Fire Tower
			FireTowerButton button2 = new FireTowerButton();// button to create Laser Tower
			FireTowerButton button3 = new FireTowerButton();// button to create Missile Tower
			p.add(button1);// Add the button onto the panel
			p.add(button2);
			p.add(button3);
			add(p);// Add the panel onto the frame
		}
		if(result == JOptionPane.NO_OPTION){// Exit the game
			JOptionPane.showMessageDialog(null, "You will exit the game");
			System.exit(0);
		}
		setVisible(true);
		
	}
}