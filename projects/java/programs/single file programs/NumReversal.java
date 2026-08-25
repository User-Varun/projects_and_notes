import java.util.Stack;

class NumReversal {

  public static void main(String[] args) {

    int num = 1234;

    StringBased(num);
    StringBasedManual(num);
    usingMath(num);
    handlingNegAndSign(-1234);
    usingStack(num);
    int res = usingRecursion(num, 0);
    System.out.println(res);

  }

  // this is inefficient
  static void StringBased(int num) {
    String str = new StringBuilder(String.valueOf(num)).reverse().toString();

    int reverse = Integer.parseInt(str);

    System.out.println(reverse);
  }

  // manualy reversing
  static void StringBasedManual(int num) {
    String str = String.valueOf(num);
    String rev = "";

    for (int i = str.length() - 1; i >= 0; i--) {
      rev += str.charAt(i);
    }

    System.out.println(rev);
  }

  // using math (efficient)
  static void usingMath(int num) {
    // num % 10 (extracting last digit)
    // num / 10 (removing last digit)

    int rev = 0;

    while (num != 0) {
      int digit = num % 10;
      rev = rev * 10 + digit;
      num = num / 10;
    }

    System.out.println(rev);
  }


  // handling negative sign and overflow 
  static void handlingNegAndSign(int num){
    int sign = num < 0 ? -1 : 1;
    int numAbs = Math.abs(num);
    int rev = 0;

    
    while(numAbs != 0){
       int digit = numAbs % 10; // gives last digit
       
       // catching one digit before overflow
       if(rev > Integer.MAX_VALUE / 10){
        System.out.println("overflow");
        return;
       }

       rev = rev * 10  + digit;
       numAbs /= 10;
    }
    int result = rev * sign;
    System.out.println(result);
  }


  // using stack 
  static void usingStack(int num){

    Stack<Integer> s = new Stack<>();
    int rev = 0;
    int place = 1;

    while(num != 0){
      s.push(num % 10);
      num = num / 10;
    }

    while (!s.isEmpty()) {
      rev += place * s.pop();
      place *=10;
    }
    
    System.out.println(rev);
  }

  // using recursion
  static int usingRecursion(int num , int rev){
     // base case 
     if(num == 0) return rev;
      
     // num % 10 is equals to digit , rev * 10 (number place )
    rev = usingRecursion((num / 10), rev * 10 + (num % 10));

    return rev;
     
  }
}