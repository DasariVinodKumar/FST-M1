package Activity;

//Parent Class
class Teacher {
   //Parent class Members
   String designation = "Teacher";
   String collegeName = "LVC";

   //Parent class Methods
   void does() {
       System.out.println("Teaching");
   }
}

//Child Class
public class Inheritance extends Teacher{
   //Child class member
   String mainSubject = "Physics";
   
   public static void main(String args[]) {
       //Instantiation
	   Inheritance obj = new Inheritance();
       
       //Usage of parent and child properties
       System.out.println(obj.collegeName);
       System.out.println(obj.designation);
       System.out.println(obj.mainSubject);
       
       obj.does();
   }
}
