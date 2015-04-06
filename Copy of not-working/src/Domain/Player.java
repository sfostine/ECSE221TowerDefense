package Domain;

public class Player {
	private static  Player player;
	private int health;
	private int currency;
	private Player(){
		super();
		this.health=3; //3 lives
		this.currency=250; //amount of initial cash. 
	}
	
	//singleton pattern implemented for Player
	public static Player getInstance(){
		if(player==null){
			player=new Player();
		}
			return player;
	}
	
	public int getHealth() {
		return health;
	}
	public boolean canAfford(int cost){
		if(cost>this.currency){
			return false;
		}
		else{
			return true;
		}
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public void addHealth(int health){
		this.health+=health;
	}
	public void removeHealth(int health){
		this.health-=health;
	}
	public int getCurrency() {
		return currency;
	}
	public void setCurrency(int currency) {
		this.currency = currency;
	}
	public void addCurrency(int amount){
		this.currency+=amount;
	}
	public void removeCurrency(int amount){
		this.currency-=amount;
	}
	public boolean isAlive() {
		if(health>0){
			return true;
		}
		return false;
	}
	
}
