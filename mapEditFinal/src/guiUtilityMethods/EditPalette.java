package guiUtilityMethods;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.plaf.metal.MetalBorders.ToolBarBorder;

import domain.Value;

public class EditPalette extends JPanel {
	static JButton howToCreate;
	static JButton setScenery;
	static JButton setPath;
	static JButton setEntry;
	static JButton setExit;
	static JButton saveMap;
	static JButton loadMap;
	static JLabel mode;
	ArrayList<JButton> buttons =new ArrayList();
	public EditPalette(){
		super();
		//initializing JButtons
		howToCreate=new JButton("How To");
		setScenery=new JButton("Set Scenery");
		setPath =new JButton("Set Path");
		setEntry=new JButton("Set Entry");
		setExit=new JButton("Set Exit");
		saveMap=new JButton("Save Map and Exit");
		mode=new JLabel("Map Editor");
		
		//placing them into an arraylist to allow for easy reference.
		buttons.add(howToCreate);
		buttons.add(setScenery);
		buttons.add(setPath);
		buttons.add(setEntry);
		buttons.add(setExit);
		buttons.add(saveMap);
		this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
		//some aesthetics
		mode.setHorizontalAlignment(SwingConstants.CENTER);
        mode.setFont(new Font("Tahoma", Font.BOLD, 12));
		this.setBackground(Color.WHITE);
		//organizing handlers and action listeners. Adding HandlerClass as action listener
		Iterator<JButton> itr = buttons.iterator();
		PaletteHandler handle=new PaletteHandler();
		while(itr.hasNext()){
			JButton temp= itr.next();
			temp.addActionListener(handle);
			temp.setMaximumSize(new Dimension(Value.getWindowWidth()/7,Value.paletteHeight));
	        temp.setFont(new Font("Tahoma", Font.BOLD, 12));
		}
		//setting layout and adding buttons
		this.add(howToCreate);
		this.add(setScenery);
		this.add(setPath);
		this.add(setEntry);
		this.add(setExit);
		this.add(saveMap);
		this.add(mode);
	}
}