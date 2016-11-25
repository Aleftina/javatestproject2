package ua.javatests;

public class MyFirstProgram {

  public static void main(String[] args) {
  
  System.out.println("Hello, world!!");

      hello("user");
      hello("friend");

      Square square = new Square(2);
      Rectangle rec = new Rectangle(3,7);

     // square.l = 111.1;
      System.out.println("square with side length "+square.l+" equals "+square.area());
      System.out.println("square with side length "+rec.a+"and "+rec.b+ " equals "+rec.area());
 }

    private static void hello(String user) {
        System.out.println("Hello, "+user);
    }


}
