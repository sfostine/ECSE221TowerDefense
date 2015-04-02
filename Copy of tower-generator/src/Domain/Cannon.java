package Domain;
//Xu Ji 260562839

public class Cannon extends Tower {

	 public Cannon(int level) {
		 //Declare a Cannon object by using Tower constructor
		  super(level);
		  this.setPower(20);
		  this.setRange(5);
		  this.setRateOfFire(0.5);
	 }
	 
	 //Implement upgrade method
	 public Tower upgrade(){
		 if (this.getLevel() == 1){
			 this.setLevel(getLevel() + 1);
			 return new FireBall(this);
		 }else if(this.getLevel() == 2){
			 this.setLevel(getLevel() + 1);
			 return new SilverBullet(this);
		 }else{
			 return this;
		 }
	 }
	 
	 
	 public String getDescription(){ 
		 return "Cannon";
	 }
	 
	 @Override
	 public int cost() {
		return 300;
	 }

}
