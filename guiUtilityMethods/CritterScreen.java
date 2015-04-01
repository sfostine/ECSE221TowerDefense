package guiUtilityMethods;

import java.awt.Graphics;

import javax.swing.*;

import observerCritter.CompleteCritterObserver;

public class CritterScreen extends JPanel implements Runnable{
	protected  CompleteCritterObserver cr1;
	private int level;
	Thread th;
	
	private static CritterScreen cr;
	private CritterScreen()
	{
		//this.add(GUIScreen.getGuiScreen());
		level = 2;
		cr1 = new CompleteCritterObserver(level, "src/repo/enemy1.png");
		th = new Thread(this);
		th.start();
	}
	
	public static CritterScreen getCritterScreen()
	{
		if(cr == null)
			cr = new CritterScreen();
		return cr;
	}
	
	private void updatePosition() {
		cr1.move();
	}


	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		cr1.drawCritters(g);
	}
	
	@Override
	public void run() {
		while (true)
		{
			repaint();
			updatePosition();
			try {
				th.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
	}
	
	

}
