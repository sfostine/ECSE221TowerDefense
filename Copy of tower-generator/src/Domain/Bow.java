package Domain;
//Xu Ji 260562839

public class Bow extends Tower {
 
 public Bow(int level) {
  //Declare a Bow object by using Tower constructor
  super(level);
  this.setPower(25);
  this.setRange(2);
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
	 return "Bow";
 }
 
@Override
public int cost() {
	return 250;
}

}
