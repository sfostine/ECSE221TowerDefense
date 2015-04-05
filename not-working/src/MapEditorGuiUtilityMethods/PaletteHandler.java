package MapEditorGuiUtilityMethods;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JOptionPane;

public class PaletteHandler implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent event) {
		String command=event.getActionCommand();
		String output=command.replaceAll("\\s", "");
		//trying to find method
		java.lang.reflect.Method method = null;
		try {
			method = this.getClass().getMethod(output);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
			try {
				method.invoke(this);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
	}
	public void HowTo(){
		JOptionPane.showMessageDialog(null, "The Map Editor allows you to create and save maps for Crazzie Defense.\n Choose your mode in the panel. The current mode is displayed in the bottom right corner.\n Click on a cell to set that cell.\n Do not forget to select an entry and exit cell on the edges of the map. \n The path must be a valid path. Save your map by clicking save map/exit","How To", JOptionPane.INFORMATION_MESSAGE,GUIFrame.logo);
	}
	public void SetScenery(){
		String mode="SetScenery";
		EditPalette.mode.setText(mode);
		GUIMap.mode=(mode);
	}
	public void SetPath(){
		String mode="SetPath";
		EditPalette.mode.setText(mode);
		GUIMap.mode=mode;
	}
	public void SetEntry(){
		String mode="SetEntry";
		EditPalette.mode.setText(mode);
		GUIMap.mode=mode;
	}
	public void SetExit(){
		String mode="SetExit";
		EditPalette.mode.setText(mode);
		GUIMap.mode=mode;
	}
	public void SaveMapandExit(){
		if(GUIMap.domainMap.verifyMap()){
		GUIMap.domainMap.saveMap();
		JOptionPane.showMessageDialog(null, "Sucessfully Saved!","Save Successful",JOptionPane.INFORMATION_MESSAGE,GUIFrame.logo);
		System.exit(0);
		}
		else{
			JOptionPane.showMessageDialog(null, "The map is not valid.  A valid map is a map that has an entry point and exit point on the edges of the map that are connected by path cells.","Save Unsuccessful",JOptionPane.INFORMATION_MESSAGE,GUIFrame.logo);
			EditPalette.mode.setText("Save Map And Exit");
		}
	}
}
