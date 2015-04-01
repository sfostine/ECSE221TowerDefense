package guiUtilityMethods;

import javax.swing.*;

import domain.Value;

import java.awt.*;

public class GUIFrame extends JFrame {
	public static String title = "CrazzieeDefenceOfOurOwn";
	private Dimension size;


	public GUIFrame() {
		init();
	}

	public void init() {
		size = new Dimension(Value.getWindowWidth(), Value.getWindowHeight());
		add(GUIScreen.getGuiScreen());
		//add(CritterScreen.getCritterScreen());
		setTitle(title);
		setSize(size);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
