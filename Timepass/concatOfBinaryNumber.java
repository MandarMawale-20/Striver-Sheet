import java.util.*;

/*
 * Problem: Concatenation of Consecutive Binary Numbers
 * 
 * Given an integer n, you need to concatenate the binary representations of 1 to n.
 * Return the decimal value of the concatenated binary number modulo 10^9 + 7.
 */

class Solution {
    
    public int concatenatedBinary(int n) {
        long ans = 0;
        long MOD = 1000000007;
        int length = 0;

        for (int i = 1; i <= n; i++) {

            if ((i & (i - 1)) == 0) {  
                length++;
            }

            ans = ((ans << length) | i) % MOD;  
        }

        return (int) ans;
    }
}

public class concatOfBinaryNumber {

    public static void main(String[] args) {

        Solution sol = new Solution();
        int test1 = 5;
        System.out.println("Output: " + sol.concatenatedBinary(test1));

    }
}
