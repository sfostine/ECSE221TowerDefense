package Domain;

import javax.swing.*;

import java.awt.*;

public class GUIFrame extends JFrame {
	public Dimension size;
	public static GUIFrame guiFrame;
	public static ImageIcon logo;
	private GUIFrame() {
		init();
	}
	public static GUIFrame getInstance(){
		if(guiFrame==null){
			guiFrame=new GUIFrame();
			guiFrame.setTitle(Value.userInputName);
		}
		return guiFrame;
	}
	public void init() {
		size = new Dimension((Value.getWindowWidth()), Value.getWindowHeight()+Value.paletteHeight);
		EditPalette editP=new EditPalette();
		logo = new ImageIcon("src/repo/logo.jpg");
		getContentPane();
		add(GUIScreen.getGuiScreen());
		add(editP, BorderLayout.SOUTH);
		this.setBackground(Color.BLACK);
		setSize(size);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}