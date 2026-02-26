import java.util.*;

/*
 * Problem: Number of Steps to Reduce a Number in Binary Representation to One
 * 
 * Given a number s in their binary representation. In one step, you can subtract 1 from it.
 * 
 * Two cases:
 * - If the last digit is 0, you directly divide the number by 2 (remove the last digit)
 * - If the last digit is 1, you first subtract 1 and then remove the last digit
 * 
 * Your task is to count the number of steps it takes to reduce the number to 1.
 * 
 */

class Solution {
    
    public int numSteps(String s) {
        int steps = 0;
        StringBuilder num = new StringBuilder(s);
        
        while (num.length() > 1) {
            if (num.charAt(num.length() - 1) == '0') {
                num.deleteCharAt(num.length() - 1);
            } 
            else {
                int i = num.length() - 1;
                
                while (i >= 0 && num.charAt(i) == '1') {
                    num.setCharAt(i, '0');
                    i--;
                }
                
                if (i >= 0) {
                    num.setCharAt(i, '1');
                } else {
                    num.insert(0, '1');
                }
            }
            steps++;
        }
        
        return steps;
    }
}

public class reduceBinaryToOne {

    public static void main(String[] args) {
        
        Solution sol = new Solution();
        
        String s1 = "1101";
        String s2 = "10";
        String s3 = "1";
        
        System.out.println("Steps: " + sol.numSteps(s1));
        System.out.println("Steps: " + sol.numSteps(s2));
        System.out.println("Steps: " + sol.numSteps(s3));

}
