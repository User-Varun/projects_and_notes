
/*
Ways to create singleton 

 */
// 1. lazy init 
class lazyInit {

    //  private static lazyInit instance;
// egar loading 
    private static final lazyInit instance = new lazyInit();

    private lazyInit() {
    }

// thread safe
    //  public static synchronized lazyInit getInstance() {
    //      if (instance == null) {
    //          instance = new lazyInit();
    //      }
    //      return instance;
    //  }
// double check (make sure of one obj creation)
    //  public static lazyInit getInstance() {
    //      if (instance == null) {
    //          synchronized (lazyInit.class) {
    //              instance = new lazyInit();
    //          }
    //      }
    //      return instance;
    //  }
    //
// egar loading (at runtime)
    public static lazyInit geInstance() {
        return instance;
    }
}

// Enum 
enum singletonEnum {
    INSTANCE;

    // public method 
    public void doSomething() {
        // single logic here
    }
}
