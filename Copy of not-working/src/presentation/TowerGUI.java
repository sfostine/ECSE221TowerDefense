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
import Domain.Value;
import Domain.WeakestCritterStrategy;
import Domain.nearestCritterExitPointStrategy;
import Domain.nearestCritterStrategy;
import presentation.GameFrame;

public abstract class TowerGUI implements IObserver {

	// Declare variables
	private Tower observedTower;
	private JButton buttonUpgrade;
	private JButton buttonSell;
	private JButton buttonStrategy;
	private JButton tower;

	// Constructor
	public TowerGUI(final Tower observedTower, int x, int y) {
		super();
		this.observedTower = observedTower;

		// Declare towerGUI as a JButton and add ActionListener on it
		ActionListener towerButtonAction = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane
				.showMessageDialog(GameFrame.mapPanel,
						observedTower.toString());
				GameFrame.buttonPanel.label1
						.setText("<html>Upgrade or sell <br> your tower</html>");
				GameFrame.buttonPanel.buttonCannon.setVisible(false);
				GameFrame.buttonPanel.buttonRocket.setVisible(false);
				GameFrame.buttonPanel.buttonBow.setVisible(false);
				addUpdateButton();
				addSellButton();
				addStrategyButton();
				GameFrame.buttonPanel.add(buttonUpgrade);
				GameFrame.buttonPanel.add(buttonSell);
				GameFrame.buttonPanel.add(buttonStrategy);
			}
		};
		tower = new JButton();
		tower.addActionListener(towerButtonAction);

		// Initial button image
		try {
			Image img = ImageIO.read(
					GameFrame.class.getResource("/Image/tower1.jpeg"))
					.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
			tower.setIcon(new ImageIcon(img));
		} catch (IOException e) {
			System.out.println("no image founded");
		}

		// Add button to the map at a specific position
		GameFrame.mapPanel.add(tower);
		tower.setBounds(x, y, Value.pathCellSize, Value.pathCellSize);
		GameFrame.buttonPanel.label1.setText("Choose your tower");
		GameFrame.buttonPanel.buttonCannon.setVisible(true);
		GameFrame.buttonPanel.buttonRocket.setVisible(true);
		GameFrame.buttonPanel.buttonBow.setVisible(true);

		// Disable isBuildTower
		ButtonPanel.isBuildCannon = false;
		ButtonPanel.isBuildRocket = false;
		ButtonPanel.isBuildBow = false;
		JOptionPane.showMessageDialog(GameFrame.mapPanel,
				"Click the tower to upgrade or sell.");
	}

	// Create a update button under tower button and add is to the mainWindow
	public void addUpdateButton() {
		ActionListener upgradeButtonAction = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int n = JOptionPane.showConfirmDialog(null,
						"Are you sure you want to upgrade?", "Confirm",
						JOptionPane.YES_NO_OPTION);
				if (n == 0) {
					observedTower = observedTower.upgrade();
					System.out.println(observedTower.getDescription());
					System.out.println("upgrade yes");
				} else {
					System.out.println("upgrade no");
				}
				GameFrame.buttonPanel.label1.setText("Choose your tower");
				GameFrame.buttonPanel.buttonCannon.setVisible(true);
				GameFrame.buttonPanel.buttonRocket.setVisible(true);
				GameFrame.buttonPanel.buttonBow.setVisible(true);
				buttonUpgrade.setVisible(false);
				buttonSell.setVisible(false);
				buttonStrategy.setVisible(false);
			}
		};
		buttonUpgrade = new JButton("Upgrade");
		buttonUpgrade.addActionListener(upgradeButtonAction);
		buttonUpgrade.setVisible(true);
	}

	// Create a update sell under tower button and add is to the mainWindow
	public void addSellButton() {
		ActionListener SellButtonAction = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int n = JOptionPane.showConfirmDialog(null,
						"Are you sure you want to sell it?", "Confirm",
						JOptionPane.YES_NO_OPTION);
				if (n == 0) {
					System.out.println("sell yes");
					tower.setVisible(false);
				} else {
					System.out.println("sell no");
				}
				GameFrame.buttonPanel.label1.setText("Choose your tower");
				GameFrame.buttonPanel.buttonCannon.setVisible(true);
				GameFrame.buttonPanel.buttonRocket.setVisible(true);
				GameFrame.buttonPanel.buttonBow.setVisible(true);
				buttonUpgrade.setVisible(false);
				buttonSell.setVisible(false);
				buttonStrategy.setVisible(false);
			}
		};
		buttonSell = new JButton("Sell");
		buttonSell.addActionListener(SellButtonAction);
		buttonSell.setVisible(true);
	}

	public void addStrategyButton() {
		ActionListener StrategyButtonAction = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JList<?> list = new JList<Object>(new String[] {
						"Nearest strategy",
						"nearest critter to the exit point",
						" strongest critter", "weakest critter" });
				JOptionPane.showMessageDialog(null, list,
						"Choose tower strategy", JOptionPane.PLAIN_MESSAGE);
				String temp = Arrays.toString(list.getSelectedIndices());
				if (temp.equals("[0]")) {
					observedTower.setStrategy(new nearestCritterStrategy());
					observedTower.performStrategy();
				} else if (temp.equals("[1]")) {
					observedTower
							.setStrategy(new nearestCritterExitPointStrategy());
					observedTower.performStrategy();
				}
				if (temp.equals("[2]")) {
					observedTower.setStrategy(new StrongestCritterStrategy());
					observedTower.performStrategy();
				}
				if (temp.equals("[3]")) {
					observedTower.setStrategy(new WeakestCritterStrategy());
					observedTower.performStrategy();
				}

				GameFrame.buttonPanel.label1.setText("Choose your tower");
				GameFrame.buttonPanel.buttonCannon.setVisible(true);
				GameFrame.buttonPanel.buttonRocket.setVisible(true);
				GameFrame.buttonPanel.buttonBow.setVisible(true);
				buttonUpgrade.setVisible(false);
				buttonSell.setVisible(false);
				buttonStrategy.setVisible(false);
			}
		};
		buttonStrategy = new JButton("Strategy");
		buttonStrategy.addActionListener(StrategyButtonAction);
		buttonStrategy.setVisible(true);
	}

	// Get notified and update graphic
	@Override
	public void update() {
		try {
			Image img = null;
			if (observedTower.getLevel() == 1) {
				img = ImageIO.read(
						GameFrame.class.getResource("/Image/tower1.jpeg"))
						.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
			} else if (observedTower.getLevel() == 2) {
				img = ImageIO.read(
						GameFrame.class.getResource("/Image/tower2.jpeg"))
						.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
			} else {
				img = ImageIO.read(
						GameFrame.class.getResource("/Image/tower3.jpeg"))
						.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
				;

			}
			tower.setIcon(new ImageIcon(img));
		} catch (IOException e) {
		}

		System.out.println("observer works" + observedTower.getRange());
	}

}
