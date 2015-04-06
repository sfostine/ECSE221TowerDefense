package presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Domain.PathCell;
import Domain.Cell;
import Domain.Map;
import Domain.Value;
import MapEditorDriver.InitializeMapEditor;
public class Menu {
	private ArrayList<Cell> tempPath;

	public ArrayList<Cell> getTempPath() {
		return tempPath;
	}

	public static ImageIcon logo = new ImageIcon("src/repo/logo.jpg");

	public Menu() {
		final JFrame mainMenu = new JFrame("Menu");
		mainMenu.setSize(600, 500);
		mainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLayeredPane layers = new JLayeredPane();

		try {
			JLabel label = new JLabel(new ImageIcon(ImageIO.read(
					GameFrame.class
							.getResource("/Image/crazy_defence_logo.jpg"))
					.getScaledInstance(600, 500, Image.SCALE_SMOOTH)));
			label.setPreferredSize(new Dimension(600, 500));
			label.setBounds(0, 0, 600, 500);
			layers.add(label, new Integer(1));
		} catch (IOException e) {

		}

		JButton menuButton = new JButton("New Game");
		JButton mapEditorButton = new JButton("Design map");

		ActionListener menuButtonAction = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainMenu.setVisible(false);
				System.out.println("new game called");
				ArrayList<String> fileNames = getFileNamesInFolder("savedMaps");
				String[] list = new String[fileNames.size()];
				list = fileNames.toArray(list);
				int chosenFile = JOptionPane.showOptionDialog(null,
						"What map would you like to edit?", "Loading a Map",
						JOptionPane.INFORMATION_MESSAGE, 0, logo, list, 0);
				String loadFile = list[chosenFile];
				Map tempDomainMap = new Map("savedMaps/" + loadFile);
				Value.userInputName = tempDomainMap.name;
				Value.setWindowWidth(tempDomainMap.getHeight()
						* Value.pathCellSize);
				Value.setWindowHeight(tempDomainMap.getWidth()
						* Value.pathCellSize);
				new GameFrame();
			}
		};

		menuButton.addActionListener(menuButtonAction);
		ActionListener mapEditorButtonAction = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new InitializeMapEditor();
				mainMenu.setVisible(false);
				System.out.println("map editor called");
			}
		};
		mapEditorButton.addActionListener(mapEditorButtonAction);

		menuButton.setBounds(250, 400, 100, 20);
		mapEditorButton.setBounds(360, 400, 100, 20);

		layers.add(menuButton, new Integer(2));
		layers.add(mapEditorButton, new Integer(2));

		mainMenu.add(layers);
		mainMenu.setVisible(true);

	}

	public static ArrayList<String> getFileNamesInFolder(String folder) {
		File folderA = new File(folder);
		File[] listOfFiles = folderA.listFiles();
		ArrayList<String> files = new ArrayList<String>();
		for (int i = 0; i < listOfFiles.length; i++) {
			if (!listOfFiles[i].isHidden()) {
				files.add(listOfFiles[i].getName());
			}
		}
		return files;
	}
}
