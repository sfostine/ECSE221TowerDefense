package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Domain.FireTower;
import Domain.IObserver;
import Domain.Tower;

public class FireTowerButton extends JButton implements ActionListener,IObserver {
	String newline = System.getProperty("line.separator");// Create new line
	ImageIcon X,O;
	static byte value = 0;
	private Tower Observer;
	public FireTowerButton(Tower Observer){
		super();
		X = new ImageIcon(this.getClass().getResource("image/Fire1.jpg"));// upload the image from source folder
		O = new ImageIcon(this.getClass().getResource("image/Fire2.jpg"));
		this.addActionListener(this);
	
	}
	@Override

	public void actionPerformed(ActionEvent e){
		value++;
		value%=4;// It will never pass 4 
		final JButton UpdateButton = new JButton();
		switch(value){
		case 0:// starting image 
			setIcon(null);
			break;
		case 1:// second image 
			setIcon(X);// creating a tower in the GUI
			Tower Tower1 = new FireTower();
			FireTowerButton ObserverTower = new FireTowerButton(Tower1);
			Tower1.addObserver(ObserverTower);
			System.out.println("1 Fire Tower has been added");
			System.out.println("The initial Fire Tower power is "+Tower1.getPower());
			System.out.println("The initial Fire Tower range is "+Tower1.getRange());
			break;
			
		case 2:
			setIcon(O);// Upgrading the range of the tower
			Tower Upgrade = new FireTower();
			FireTowerButton ObserverTower2 = new FireTowerButton(Upgrade);
			Upgrade.addObserver(ObserverTower2);
			Upgrade.update();// Updating the Tower then Updating the IObserver 
			System.out.println("The upgraded Fire Tower power is "+Upgrade.getPower());
			System.out.println("The upgraded Fire Tower range is "+Upgrade.getRange());
			break;
		case 3:// Selling the tower 
			System.out.println("you just sold your Fire Tower");
			setIcon(null);
		}
	}
	public static byte getValue() {
		return value;
	}
	public void update() {// The Updating method that is linked to IObserver 
	JOptionPane.showMessageDialog(null, "This Tower is more Powerful"+newline+"The range&power have increase by 1");
	System.out.println("IObserver  is working");	
		
	}

}
