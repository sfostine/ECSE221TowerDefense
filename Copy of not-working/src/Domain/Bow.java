package Domain;
//Xu Ji 260562839

public class Bow extends Tower {
 
 public Bow(int level) {
  //Declare a Bow object by using Tower constructor
  super(level);
  this.setPower(25);
  this.setRange(1);
  this.setRateOfFire(0.8);
  this.description = "Bow";
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

 
@Override
public int cost() {
	return 250;
}

//@Override
//public void attack(Critter c) {
//	c.hit(this.getPower());
//}

}
