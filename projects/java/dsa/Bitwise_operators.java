/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */

/**
 *
 * @author Varun
 */
public class Bitwise_operators {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
        
        int a = 12; // Binary: 1100
        int b = 5;  // Binary: 0101

        System.out.println("Operands: a = " + a + " (1100), b = " + b + " (0101)\n");

        // 1. Bitwise AND (&)
        // Returns 1 if both bits are 1
        int andResult = a & b; 
        System.out.println("a & b  = " + andResult + " (Binary: " + Integer.toBinaryString(andResult) + ")"); 
        // 1100 & 0101 = 0100 (4)

        // 2. Bitwise OR (|)
        // Returns 1 if at least one bit is 1
        int orResult = a | b;
        System.out.println("a | b  = " + orResult + " (Binary: " + Integer.toBinaryString(orResult) + ")");
        // 1100 | 0101 = 1101 (13)

        // 3. Bitwise XOR (^)
        // Returns 1 if bits are different
        int xorResult = a ^ b;
        System.out.println("a ^ b  = " + xorResult + " (Binary: " + Integer.toBinaryString(xorResult) + ")");
        // 1100 ^ 0101 = 1001 (9)

        // 4. Bitwise Complement (~)
        // Inverts all bits (Unary operator)
        int complementResult = ~a;
        System.out.println("~a     = " + complementResult + " (Binary: " + Integer.toBinaryString(complementResult) + ")");
        // ~1100... = 0011... (in 32-bit: -13)

        // 5. Left Shift (<<)
        // Shifts bits left, filling with 0 (Multiplies by 2^n)
        int leftShift = a << 2;
        System.out.println("a << 2 = " + leftShift + " (Binary: " + Integer.toBinaryString(leftShift) + ")");
        // 1100 << 2 = 110000 (48)

        // 6. Signed Right Shift (>>)
        // Shifts bits right, preserving sign bit (Divides by 2^n)
        int rightShift = a >> 2;
        System.out.println("a >> 2 = " + rightShift + " (Binary: " + Integer.toBinaryString(rightShift) + ")");
        // 1100 >> 2 = 11 (3)

        // 7. Unsigned Right Shift (>>>)
        // Shifts bits right, filling with 0 (ignores sign)
        int negNum = -16; 
        int unsignedShift = negNum >>> 2;
        System.out.println("-16 >>> 2 = " + unsignedShift + " (Large positive number)");
    }
}

