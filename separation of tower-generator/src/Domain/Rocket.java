package Domain;
//Xu Ji 260562839

public class Rocket extends Tower {
 
 public Rocket(int level){
  //Declare a Rocket object by using Tower constructor
  super(level);
  this.setPower(30);
  this.setRange(3);
  this.setRateOfFire(0.8);
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
	 return "Rocket";
 }
 
@Override
public int cost() {
	return 350;
}

@Override
public void attack(Critter c) {
	c.hit(this.getPower());	
}

}
