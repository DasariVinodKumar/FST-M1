package Activity;

public class Car  {
	//public class car {
		 int make;
		 String color;
		 String transmission;
		int tyres = 4;
	    int doors = 4 ;
		public void displayCharacterstics() {
			// TODO Auto-generated method stub
			System.out.println("Color of the Car: " + this.color);
	    	System.out.println("Make of the Car: " + this.make);
	    	System.out.println("Transmission of the Car: " + this.transmission);
	    	System.out.println("Number of doors on the car: " + this.doors);
	        	System.out.println("Number of tyres on the car: " + this.tyres);
		}
		public void accelerate() {
			// TODO Auto-generated method stub
				System.out.println("Car is moving forward.");	
		}
		public void brake() {
			// TODO Auto-generated method stub
			System.out.println("Car has stopped.");	
		}
	}