/**
 * Zigzag Conversion
 * 
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 * 
 * Input is  "PAYPALISHIRING", numRows = 3
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * Output will be  "PAHNAPLSIIGYR"

 */

import java.util.*;
class Solution {
    // Optimal Approach
    public String convertOptimal(String s, int numRows) {
        if (numRows <= 1) {
            return s;
        }

        StringBuilder res = new StringBuilder();
        int n = s.length();
        int inc = 2 * (numRows - 1);

        for (int r = 0; r < numRows; r++) {
            for (int i = r; i < n; i += inc) {
                res.append(s.charAt(i));
                int mid = i + inc - 2 * r;
                if (r > 0 && r < numRows - 1 && mid < n) {
                    res.append(s.charAt(mid));
                }
            }
        }
        return res.toString();
    }

    // Brute Force Approach
    public String convert(String s, int numRows) {
        if (numRows <= 1 || s.length() <= numRows) {
            return s;
        }

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }

        int cur = 0;
        int dir = -1;

        for (char c : s.toCharArray()) {
            rows.get(cur).append(c);
            if (cur == 0 || cur == numRows - 1) {
                dir *= -1;
            }
            cur += dir;
        }

        StringBuilder res = new StringBuilder();
        for (StringBuilder row : rows) {
            res.append(row);
        }
        return res.toString();
    }
}

public class zigzagConversion {
    public static void main(String[] args) {
        Solution sol = new Solution();


        String s1 = "PAYPALISHIRING";
        int numRows1 = 3;
        System.out.println("Optimal : " + sol.convertOptimal(s1, numRows1));
        System.out.println("Brute Force: " + sol.convert(s1, numRows1));

        String s2 = "PAYPALISHIRING";
        int numRows2 = 4;
        System.out.println("Optimal : " + sol.convertOptimal(s2, numRows2));
        System.out.println("Brute Force: " + sol.convert(s2, numRows2));
    }
}
