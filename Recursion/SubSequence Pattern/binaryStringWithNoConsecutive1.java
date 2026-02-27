import java.util.*;

/*
 * Problem: Binary String With No Consecutive Ones
 * 
 * Given a positive integer n, you need to find the count of all possible distinct 
 * binary strings of length n such that there is no consecutive 1's.
 * 
 * Also return all such strings.
 * 

 */

class Solution {
    
    public static List<String> generateString(int n) {
        List<String> result = new ArrayList<>();
        helper(n, "", result);
        return result;
    }

    public static void helper(int n, String str, List<String> ans) {

        if (str.length() == n) {
            ans.add(str);
            return;
        }
        
        helper(n, str + "0", ans);
        
        if (str.isEmpty() || str.charAt(str.length() - 1) != '1') {
            helper(n, str + "1", ans);
        }
    }
}

public class binaryStringWithNoConsecutive1 {

    public static void main(String[] args) {
                
        int n = 3;
        List<String> result = Solution.generateString(n);
            
        for(String binaryString : result) {
            System.out.println(binaryString);
        }
        
    }
}
