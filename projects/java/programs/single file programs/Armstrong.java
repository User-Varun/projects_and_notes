public class Armstrong {
    public static void main(String[] args) {

        int userInput = 123;
        int num = userInput;
        String num_str = String.valueOf(num);
        int length = num_str.length();
        int total = 0;

        while (num != 0) {
            int digit = num % 10;
            total += (int) Math.pow(digit, length);
            num /= 10;
        }

        if (total == userInput) {
            System.out.println("Number " + userInput + " is Armstrong.");
        } else {
            System.out.println("Number " + userInput + " is not Armstrong.");

        }
    }
}
