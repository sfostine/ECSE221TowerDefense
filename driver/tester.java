package driver;

import guiUtilityMethods.GUIFrame;
import guiUtilityMethods.getUserInput;

import domain.Value;

public class tester {

	public static void main(String[] args) {
		// getting the input for the width.
		Value.setWindowHeight(getUserInput.getInput("Please enter the height"));
		Value.setWindowWidth(getUserInput.getInput("Please enter the width"));

		GUIFrame frame = new GUIFrame();
	}
}
