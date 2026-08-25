public class Rectangle {
  // variables
  int length;
  int breadth;

  // constructors
  Rectangle(int length , int breadth){
    this.length = length;
    this.breadth = breadth;
  }

  // methods 
  void area(){
    System.out.println(length * breadth);
  }

  public static void main(String[] args){
    Rectangle r1 = new Rectangle(10 , 10);
    r1.area();
    
  }
}
