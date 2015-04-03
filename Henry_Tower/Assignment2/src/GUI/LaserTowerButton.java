package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import Domain.FireTower;
import Domain.IObserver;
import Domain.LaserTower;
import Domain.Tower;

public class LaserTowerButton extends JButton implements ActionListener, IObserver {
	String newline = System.getProperty("line.separator");// Create a new line
	ImageIcon X,O;
	static byte value = 0;
	private Tower Observer;
	public LaserTowerButton(Tower Observer){
		super();
		X = new ImageIcon(this.getClass().getResource("image/Laser1.jpg"));// upload the two images from the image folder inside 
		O = new ImageIcon(this.getClass().getResource("image/Laser2.jpg"));
		this.addActionListener(this);
	
	}
	@Override

	public void actionPerformed(ActionEvent e){
		value++;
		value%=4;// value will never pass 4 
		final JButton UpdateButton = new JButton();
		switch(value){
		case 0:// no image 
			setIcon(null);
			break;
		case 1:
			setIcon(X);
			Tower Tower2 = LaserTower.getInstance(); // create a new Laser Tower
			LaserTowerButton ObserverTower = new LaserTowerButton(Tower2);
			Tower2.addObserver(ObserverTower);
			System.out.println("1 Laser Tower has been added");
			System.out.println("The initial Laser tower power is " + Tower2.getPower());
			System.out.println("The initial Laser tower range is " + Tower2.getRange());
			break;
			
		case 2:
			setIcon(O);// Create a tower in GUI
			Tower Upgrade = LaserTower.getInstance();
			LaserTowerButton ObserverTower2 = new LaserTowerButton(Upgrade);
			Upgrade.addObserver(ObserverTower2);
			Upgrade.update();// Updating the Tower then Updating the IObserver
			System.out.println("The laser tower power is now "+Upgrade.getPower());
			System.out.println("The laser tower range is now "+Upgrade.getRange());
			break;
		case 3:// Sell the Tower
			System.out.println("you just sold your Laser Tower");
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
