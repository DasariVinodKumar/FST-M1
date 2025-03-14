package Activity;

//Abstract parent class
abstract class Animal{
  //Abstract method
  //Has no function definition
  public abstract void sound();
}

//Dog class extends Animal class
public class Dog extends Animal{
  //Function definition for sound()
  public void sound() {
      System.out.println("Woof");
  }
  
  public static void main(String args[]) {
  	//Instantiation
      Dog timmy = new Dog();
      timmy.sound();
  }
}
