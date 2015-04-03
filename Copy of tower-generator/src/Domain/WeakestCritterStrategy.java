package Domain;

public class WeakestCritterStrategy implements StrategyIObserver{

	@Override
	public void performStrategy() {
		System.out.println("WeakestCritterStrategy now set");		
	}

}
