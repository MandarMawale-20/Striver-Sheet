import java.util.*;

/**
 * Longest Substring Without Repeating Characters
 * 
 * Given a string s, find the length of the longest substring without repeating characters.
 */

class Solution {
    // Brute Force Approach
    public int lengthOfLongestSubstringBrute(String s) {
        int n = s.length();
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            int[] hash = new int[256];

            for (int j = i; j < n; j++) {
                char ch = s.charAt(j);

                if (hash[ch] == 1) {
                    break;
                }

                hash[ch] = 1;

                int len = j - i + 1;
                maxLen = Math.max(maxLen, len);
            }
        }

        return maxLen;
    }

    // Optimal Approach
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);

            if (map.containsKey(ch) && map.get(ch) >= left) {
                left = map.get(ch) + 1;
            }

            int len = right - left + 1;
            maxLen = Math.max(maxLen, len);

            map.put(ch, right);
        }

        return maxLen;
    }
}

public class longestSubstringWithoutRepetition {
    public static void main(String[] args) {
        Solution sol = new Solution();

        String s1 = "abcabcbb";
        System.out.println("Brute Force :" + sol.lengthOfLongestSubstringBrute(s1));
        System.out.println("Optimal : " + sol.lengthOfLongestSubstring(s1));
    }
}
