import java.util.*;

/*
 * Problem: Letter Combinations of a Phone Number
 * 
 * Given a string containing digits from 2-9 inclusive, return all possible letter 
 * combinations that the number could represent. Return the answer in any order.
 * 
 * A mapping of digits to letters (just like on the telephone buttons):
 * 2 -> "abc"
 * 3 -> "def"
 * 4 -> "ghi"
 * 5 -> "jkl"
 * 6 -> "mno"
 * 7 -> "pqrs"
 * 8 -> "tuv"
 * 9 -> "wxyz"
 */

class Solution {
    
    private final String[] map;

    public Solution() {
        map = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    }

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();

        if(digits.length() == 0) return ans;

        combinations(digits, ans, 0, "");

        return ans;
    }

    public void combinations(String digits, List<String> ans, int index, String temp) {
        if(index == digits.length()) {
            ans.add(temp);
            return;
        }

        String s = map[digits.charAt(index) - '0'];

        for(int i = 0; i < s.length(); i++) {
            combinations(digits, ans, index + 1, temp + s.charAt(i));
        }
    }
}

public class letterCombinationofPhoneNumber {

    public static void main(String[] args) {
        
        Solution sol = new Solution();
        
        String digits = "23";
        
        List<String> result = sol.letterCombinations(digits);
        
        for(String combination : result) {
            System.out.println(combination);
        }
    }
}
