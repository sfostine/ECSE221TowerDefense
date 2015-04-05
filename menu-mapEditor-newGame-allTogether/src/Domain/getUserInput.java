package Domain;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class getUserInput {
	private static ImageIcon logo = new ImageIcon("src/repo/logo.jpg");
	public static int getInput(String typeOfInput, String message, int minVal, int maxVal) {
		boolean failure = true;
		int intValue = 0;
		
		while (failure) {
			try {
				String width = (String) JOptionPane.showInputDialog(null,message,typeOfInput,JOptionPane.INFORMATION_MESSAGE,logo,null,"");
				if(width==null){
					System.exit(-1);
				}
				intValue = Integer.parseInt(width);
				if((intValue>=minVal)&&(intValue<=maxVal)){
					failure=false;
				}
				else{
					JOptionPane.showMessageDialog(null,"Please make sure to enter the appropriate range for "+typeOfInput+ ". ("+minVal+"-"+maxVal+")","Wrong Input",JOptionPane.INFORMATION_MESSAGE,logo);
					failure=true;
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null,
						"Please enter a integer number");
				failure = true;
			}

		}
		return intValue;
	}
}
