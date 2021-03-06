package presentation;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Domain.Bow;
import Domain.Cannon;
import Domain.Map;
import Domain.Rocket;
import Domain.Tower;
import Domain.Value;

public class MapPanel extends JPanel implements MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MapPanel() {

		this.setLayout(null);
		this.setBackground(Color.YELLOW);
		this.addMouseListener(this);
	}

	// buildTower method takes two int which represents the position
	// build a tower object and towerGUI object
	// link towerGUI to tower as an observer
	public void buildTower(int x, int y) {
		int cellNumberX = x/ Value.pathCellSize;
		int cellNumberY = y/ Value.pathCellSize;
		if (ButtonPanel.isBuildCannon) {
			Tower a = new Cannon(1);
			TowerCannonGUI ag = new TowerCannonGUI(a, x, y);
			GameFrame.getGUIScreen().getGUIMap().getDomainMap().getCell(cellNumberY, cellNumberX).setTower(a);
			a.addObserver(ag);
		} else if (ButtonPanel.isBuildRocket) {
			Tower a = new Rocket(1);
			TowerRocketGUI ag = new TowerRocketGUI(a, x, y);
			GameFrame.getGUIScreen().getGUIMap().getDomainMap().getCell(cellNumberY, cellNumberX).setTower(a);
			System.out.println("");
			a.addObserver(ag);
		} else if (ButtonPanel.isBuildBow) {
			Tower a = new Bow(1);
			TowerBowGUI ag = new TowerBowGUI(a, x, y);
			GameFrame.getGUIScreen().getGUIMap().getDomainMap().getCell(cellNumberY, cellNumberX).setTower(a);
			a.addObserver(ag);
		} else {
			System.out.println("wrong type of tower");
		}
	}

	@Override
	// Once the mapPanel detects a mouse click
	// it calls buildTower method if isBuildTower is also true
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

		int offSetX = GameFrame.getGUIScreen().getGUIMap().getOffSet().x;
		int offSetY = GameFrame.getGUIScreen().getGUIMap().getOffSet().y;
		int domainX = e.getX() - offSetX;
		int domainY = e.getY() - offSetY;

		if ((ButtonPanel.isBuildCannon || ButtonPanel.isBuildRocket || ButtonPanel.isBuildBow)
				&& (GameFrame.getGUIScreen().getGUIMap().getDomainMap()
						.isScenery(domainX / Value.pathCellSize, domainY
								/ Value.pathCellSize))) {
			this.buildTower((domainX / Value.pathCellSize * Value.pathCellSize)
					+ offSetX,
					(domainY / Value.pathCellSize * Value.pathCellSize)
							+ offSetY);
		} else if (ButtonPanel.isBuildCannon || ButtonPanel.isBuildRocket
				|| ButtonPanel.isBuildBow) {
			JOptionPane
					.showMessageDialog(GameFrame.mapPanel,
							"You can't put the tower on a path cell,\n try a scenery one.");
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

	public MapPanel getMapPanel() {
		return this;
	}
}
