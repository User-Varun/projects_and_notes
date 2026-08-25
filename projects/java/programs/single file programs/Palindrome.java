public class Palindrome {
    
    public static void main(String[] args){
        
        int userInput = 121;
        int num = userInput;
        int rev = 0;

        while(num != 0){
            int digit = num % 10; 
            rev = rev * 10 + digit;
            num = num / 10;
        }

        if(userInput == rev){
            System.out.println("Number " + userInput + " is Palindrome");
        }else{
             System.out.println("Number " +  userInput + " is not a Palindrome");
        }
    }
}
