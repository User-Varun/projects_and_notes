- poly-morphism :- many-behaviors (methods)
- 2 types of polymorphism (compile time , runtime)
- method overloading is example of compile time polymorphism
- method overriding is example of runtime polymorphism
- dynamic method dispatch (we don't no which method will be called at compile time , changing the object in middle (only works when there is inheritance setup ))
- example :-
    
    ```java
    // Dynamic method dispatch
    A obj = new B();
    
    obj = new C(); // this works if C is inheriting from a or b
    obj = new D(); // if this is not inheriting , we can assign to obj
    
    ```