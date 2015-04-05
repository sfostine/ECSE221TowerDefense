package Domain;

import java.util.ArrayList;


public class CritterFactory {
	
	// arrayList of critters for the first level
	private ArrayList<CritterFirstWave> crit1 = new ArrayList<CritterFirstWave>();
	private ArrayList<CritterSecondWave> crit2 = new ArrayList<CritterSecondWave>();
	private ArrayList<CritterThirdWave> crit3 = new ArrayList<CritterThirdWave>();
	
	/**
	 * @return the crit1
	 */
	public ArrayList<CritterFirstWave> getCrit1() {
		return crit1;
	}


	/**
	 * @return the crit2
	 */
	public ArrayList<CritterSecondWave> getCrit2() {
		return crit2;
	}


	/**
	 * @return the crit3
	 */
	public ArrayList<CritterThirdWave> getCrit3() {
		return crit3;
	}


	/***
	 * Create an arraylist of critters for everyLevel
	 * @param level
	 */
	public void CreateCritters(int level)
	{
		// create a set of critters for the first level
		if(level == 1)
		{
			int previous = -25;
			for (int i = 0; i < CritterFirstWave.getNUMCRITTER() ; i++)
			{
				crit1.add(new CritterFirstWave());
				crit1.get(i).setX(crit1.get(i).getX() + previous);
				crit1.get(i).setDistance(previous);
				previous -= Value.getPathCellSize();
				
			}
		}
		
		// create a set of critters for the second level
		if(level == 2)
		{
			int previous = -25;
			for (int i = 0; i <CritterSecondWave.getNUMCRITTER() ; i++)
			{
				crit2.add(new CritterSecondWave());
				crit2.get(i).setX(crit2.get(i).getX() + previous);
				crit2.get(i).setDistance(previous);
				previous -= Value.getPathCellSize();
				
			}
		}
		
		// create a set of critters for the third level
		if(level == 3)
		{
			int previous = -25;
			for (int i = 0; i < CritterThirdWave.getNUMCRITTER(); i++)
			{
				crit3.add(new CritterThirdWave());
				crit3.get(i).setX(crit3.get(i).getX() + previous);
				crit3.get(i).setDistance(previous);
				previous -= Value.getPathCellSize();
				
			}
		}
	}
	
	/***
	 * get the Number of critter for the first wave
	 * @return int NUMCRITTER
	 */
	public int getNumCrittersWave1()
	{
		return CritterFirstWave.getNUMCRITTER();
	}

	/***
	 * get the Number of critter for the second wave
	 * @return int NUMCRITTER
	 */
	public int getNumCrittersWave2()
	{
		return CritterSecondWave.getNUMCRITTER();
	}
	

	/***
	 * get the Number of critter for the third wave
	 * @return int NUMCRITTER
	 */
	public int getNumCrittersWave3()
	{
		return CritterThirdWave.getNUMCRITTER();
	}
	

	public static void main(String [] args)
	{
		Value.setWindowHeight(700);
		Value.setWindowWidth(700);
		CritterFactory c = new CritterFactory();
		c.CreateCritters(2);
//		for(int i=0; i< 7; i++)
//			System.out.println(c.crit2.get(i).getX());
	}

}
