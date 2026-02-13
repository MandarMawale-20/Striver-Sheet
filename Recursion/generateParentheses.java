import java.util.*;

/*
 * Problem: Generate Parentheses
 * 
 * Given n pairs of parentheses, write a function to generate all combinations 
 * of well-formed parentheses.
 * 
 * Example:
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 */

class Solution {
    
    //Optimal Solution - Backtracking with Counter
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack("", 0, 0, n, result);
        return result;
    }

    public void backtrack(String curr, int opening, int closing, int n, List<String> result) {
        if(curr.length() == 2*n){
            result.add(curr);
            return;
        }

        if(opening < n) backtrack(curr + "(", opening+1, closing, n, result);
        if(opening > closing) backtrack(curr + ")", opening, closing+1, n, result);
    }

    //Brute Solution - Generate All and Validate
    public List<String> generateParenthesisBrute(int n) {
        List<String> result = new ArrayList<>();
        generateAll("", n, result);
        return result;
    }

    public void generateAll(String curr, int n, List<String> result) {
        if (curr.length() == 2 * n) {
            if (isValid(curr)) result.add(curr);
            return;
        }
        generateAll(curr + "(", n, result);
        generateAll(curr + ")", n, result);
    }

    public boolean isValid(String s) {
        int balance = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') balance++;
            else balance--;
            if (balance < 0) return false;
        }
        return balance == 0;
    }
}

public class generateParentheses {

    public static void main(String[] args) {
        
        Solution sol = new Solution();
        int n = 3;
        
        System.out.println("Optimal - Generate Parentheses (n=" + n + "):");
        List<String> result1 = sol.generateParenthesis(n);
        for(String s : result1) {
            System.out.println(s);
        }
        
        System.out.println("\nBrute - Generate Parentheses (n=" + n + "):");
        List<String> result2 = sol.generateParenthesisBrute(n);
        for(String s : result2) {
            System.out.println(s);
        }
    }
}
