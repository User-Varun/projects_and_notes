## note:- Refer to PDF for each topic (to learn in detail )

## To implement DI (dependency injection )

- use @Component to show spring u want this obj to be a bean
- use context return from run method
- use the .getBean(your class ) to have your object

## usage of AutoWired

- if we have object that is dependent of other object, to configure the inner object , we use AutoWired
    
- use @AutoWired in the usage of inner object ( Ex. below )
    
    ```java
    @Component
    public class Alien {
    
        @Autowired
        Laptop lap;
    
        public void code(){
            lap.compile();
            System.out.println("coding...");
        }
    }
    
    ```
    

## 3 ways to configure spring app

- XML based configuration `ClassPathXmlApplicationContext();`
- java based configuration
- annotations based configuration

&nbsp;

### Scopes

- we have different type of scopes for our bean (object )
- 1\. singleton  2.prototype ( there are others but that's for other time )
- by default singleton is applied ( this makes, so only one object is created on the load )
- use scope="prototype" , this will make so, every time u use .getBean() a new obj will be created , and obj will be created only when u .getBean();

## Setter injection ( in xml based config

- to set value by setter (in spring.xml ) &lt;property&gt;
- ref = for passing an object

&nbsp;