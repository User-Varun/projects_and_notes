- like we have concept of type casting ( changing the type of a data type )
- in the world of OOP we can also type cast between classes 
- example :-
- ```java
    class A{}
    class B extends A{
      public void show(){
       System.out.println("hi");
      }
    
    }
    
    public class Demo(){
      public static void main(String args[]){
         
         B obj = new B();
         obj.show(); // can access it no problem
         
         A obj2 = new A(); 
         obj2.show(); // can't access coz A don't what what B is ( parent (A) does not know B is their children ) 
         
         // Solution (upcasting)
         A obj3 = (A) new B();
         obj3.show(); // now obj has access, we type-casted ( or can say upcasting (child to parent))
         
         // Down casting 
         obj2.show() // can't access
         obj4 = (B) obj2; // we changed the reference of the obj2 which was A to now B
         obj2.show() // now can access
         
      } 
    }
    
    
    ```