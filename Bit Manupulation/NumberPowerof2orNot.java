/*
 * Problem: Power of Two
 * 
 * Given an integer n, return true if it is a power of two. Otherwise, return false.
 * 
 * An integer n is a power of two, if there exists an integer x such that n == 2^x.
 */

import java.util.Scanner;

class Solution {
    
    public boolean isPowerOfTwoBrute(int n) {
        if (n <= 0) return false;
        
        while (n % 2 == 0) {
            n /= 2;
        }
        
        return n == 1;
    }
    
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}

public class NumberPowerof2orNot {

    public static void main(String[] args) {
        
        Solution sol = new Solution();
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter a number: ");
        int num = sc.nextInt();
        
       // long start1 = System.nanoTime();
        boolean brute = sol.isPowerOfTwoBrute(num);
        //long end1 = System.nanoTime();
        //double bruteTime = (end1 - start1) / 1000000.0;
        
        //long start2 = System.nanoTime();
        boolean optimal = sol.isPowerOfTwo(num);
        //long end2 = System.nanoTime();
        //double optimalTime = (end2 - start2) / 1000000.0;
        
        System.out.println("\nBrute Force Result: " + brute);
        //System.out.println("Time taken: " + bruteTime + " ms");
        
        System.out.println("\nBit Manipulation Result: " + optimal);
        //System.out.println("Time taken: " + optimalTime + " ms");
        
        if (brute) {
            System.out.println("\n" + num + " is a power of two");
        } else {
            System.out.println("\n" + num + " is not a power of two");
        }
        
    }
}

