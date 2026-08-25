package shape_system;

public class Shape {
    void area(){
        System.out.println("Area");
    }

    public static void main(String[] args){
        Shape r1 = new Rectangle();
        Shape r2 = new Circle();
        Shape r3 = new Triangle();

        r1.area();
        r2.area();
        r3.area();

    }
}


class Rectangle extends Shape{
  
    void area(){
        System.out.println("area of rect");
    }
}

class Circle extends Shape{
  void area(){
        System.out.println("area of circle");
    }
}

class Triangle extends Shape{
  void area(){
        System.out.println("area of triangle");
    }
}