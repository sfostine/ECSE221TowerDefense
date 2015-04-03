package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import Domain.FireTower;
import Domain.IObserver;
import Domain.MissileTower;
import Domain.Tower;

public class MissileTowerButton extends JButton implements ActionListener, IObserver {
	String newline = System.getProperty("line.separator");
	ImageIcon X,O;
	static byte value = 0;
	private Tower Observer;
	public MissileTowerButton(Tower Observer){
		super();
		X = new ImageIcon(this.getClass().getResource("image/Missile1.jpg"));
		O = new ImageIcon(this.getClass().getResource("image/Missile2.jpg"));
		this.addActionListener(this);
	
	}
	@Override

	public void actionPerformed(ActionEvent e){
		value++;
		value%=4;
		final JButton UpdateButton = new JButton();
		switch(value){
		case 0:
			setIcon(null);
			break;
		case 1:
			setIcon(X);
			Tower Tower1 = new MissileTower();
			MissileTowerButton ObserverTower = new MissileTowerButton(Tower1);
			Tower1.addObserver(ObserverTower);
			System.out.println("1 Missile Tower is added");
			System.out.println("Inicial Missile Tower power is " +Tower1.getPower());
			System.out.println("Inicial Missile Tower range is " +Tower1.getRange());
			break;
			
		case 2:
			setIcon(O);
			Tower Upgrade = new MissileTower();
			FireTowerButton ObserverTower2 = new FireTowerButton(Upgrade);
			Upgrade.addObserver(ObserverTower2);
			Upgrade.update();// Updating the Tower then Updating the IObserver
			System.out.println("The new upgraded Missile Power is "+Upgrade.getPower());
			System.out.println("The new upgraded Missile Range is "+Upgrade.getRange());
			break;
		case 3:
			System.out.println("you just sold your Missile Tower");
			setIcon(null);
		}
	}
	public static byte getValue() {
		return value;
	}
	public void update() {// The Updating method that is linked to IObserver 
	JOptionPane.showMessageDialog(null, "This Tower is more Powerful"+newline+"The range&power have increase by 1");
	System.out.println("IObserver is working");	
		
	}

}