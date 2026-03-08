/**
 * Find the Index of the First Occurrence in a String (strStr)
 * 
 * Given two strings needle and haystack, return the index of the first occurrence
 * of needle in haystack, or -1 if needle is not part of haystack.
 */

class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }
        return haystack.indexOf(needle);
    }

    public int strStrBrute(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }
        if (needle.length() > haystack.length()) {
            return -1;
        }

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            boolean match = true;
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    match = false;
                    break;
                }
            }
            if (match) {
                return i;
            }
        }
        return -1;
    }
}

public class indexOfFirstOccurence {
    public static void main(String[] args) {
        Solution sol = new Solution();

        String haystack1 = "sadbutsad";
        String needle1 = "sad";
        System.out.println("Optimal Result: " + sol.strStr(haystack1, needle1));
        System.out.println("Brute Force Result: " + sol.strStrBrute(haystack1, needle1));
    }
}
