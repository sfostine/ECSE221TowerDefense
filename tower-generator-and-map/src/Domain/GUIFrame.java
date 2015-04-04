package Domain;

import javax.swing.*;


import java.awt.*;

public class GUIFrame extends JFrame {
	private final static String TITLE = "CrazzieeDefenceOfOurOwn";
	private Dimension size;

	public GUIFrame() {
		init();
	}

	public void init() {
		size = new Dimension(Value.getWindowWidth(), Value.getWindowHeight());
		add(GUIScreen.getGuiScreen());
		setTitle(TITLE);
		setSize(size);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
