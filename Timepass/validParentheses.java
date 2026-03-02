import java.util.Stack;

/*
 * Problem: Valid Parentheses
 * 
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', 
 * determine if the input string is valid.
 * 
 * An input string is valid if:
 * 1. Open brackets must be closed by the same type of brackets
 * 2. Open brackets must be closed in the correct order
 * 3. Every close bracket has a corresponding open bracket of the same type
 */

class Solution {
    
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            // Push opening brackets onto stack
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } 
            // Handle closing brackets
            else {
                // If stack is empty, no matching opening bracket
                if (stack.isEmpty()) return false;
                
                // Check if the top bracket matches the closing bracket
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                    (c == '}' && top != '{') ||
                    (c == ']' && top != '[')) {
                    return false;
                }
            }
        }
        
        // All brackets must be closed
        return stack.isEmpty();
    }
}

public class validParentheses {

    public static void main(String[] args) {
        
        Solution sol = new Solution();
        
        String[] testCases = {
            "()",
            "()[]{}", 
            "([)]",
            "{",
            "()[]{}",
            "([{}])",
            "[({})]",
            "([)]",
            "{[}]"
        };

        for (String test : testCases) {
            boolean result = sol.isValid(test);
            System.err.println("Input: " + test + " -> Output: " + result);
        }
    }
}
