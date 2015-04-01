package guiUtilityMethods;

import javax.swing.JOptionPane;

public class getUserInput {
public static int getInput(String message){
	boolean failure=true;
	int intWidth=0;
	while(failure){
	try{
		String width=JOptionPane.showInputDialog(message);
		intWidth=Integer.parseInt(width);
		failure=false;
	}
	catch(NumberFormatException e){
		JOptionPane.showMessageDialog(null, "Please enter a integer number");
		failure=true;
	}
	
	}
	return intWidth;
}
}
	