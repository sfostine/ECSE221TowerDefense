package presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class Menu {
	
	public Menu(){
		JFrame mainMenu = new JFrame("Menu");
		mainMenu.setSize(600, 500);
		mainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLayeredPane layers = new JLayeredPane();
		
		try{
			JLabel label = new JLabel(new ImageIcon(ImageIO.read(GameFrame.class.getResource("/Image/crazy_defence_logo.jpg")).getScaledInstance( 600, 500, Image.SCALE_SMOOTH )));
			label.setPreferredSize(new Dimension(600, 500));
			label.setBounds(0,0,600,500);
			layers.add(label, new Integer(1));
		} catch(IOException e){
			
		}
		
		JButton menuButton = new JButton("New Game");
		JButton mapEditorButton = new JButton("Design map");
		
		ActionListener menuButtonAction = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.out.println("new game called");
		  	}
		};
		menuButton.addActionListener(menuButtonAction);
		ActionListener mapEditorButtonAction = new ActionListener(){
			public void actionPerformed(ActionEvent e){
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
}
