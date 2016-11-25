package ua.javatests;

public class MyFirstProgram {

  public static void main(String[] args) {
  
  System.out.println("Hello, world!!");

      hello("user");
      hello("friend");

      double l = 111.1;
      System.out.println("square with side length "+l+" equals "+area(l));
      double a = 2;
      double b = 3;
      System.out.println("square with side length "+a+"and "+b+ " equals "+area(a,b));
 }

    private static void hello(String user) {
        System.out.println("Hello, "+user);
    }

    public static double area(double length){
        return length* length;
    }

    public static double area(double l1, double l2){
        return l1*l2;
    }

}
