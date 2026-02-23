import java.util.*;

/*
 * Problem: Number of Subsequences That Satisfy the Given Sum Condition
 * 
 * You are given an array of integers nums and an integer target.
 * 
 * Return the number of non-empty subsequences of nums such that the sum of the minimum 
 * and maximum element on the subsequence is less than or equal to target.
 * 
 * Since the answer may be too large, return it modulo 10^9 + 7.
 */

class Solution {
    int mod = 1_000_000_007;

    private int combination(int i, int n, int[] nums, int currMin, int currMax, boolean taken, int target) {
        if (i == n) {
            if (taken && currMin + currMax <= target) {
                return 1;
            }
            return 0;
        }

        int newMin = taken ? Math.min(currMin, nums[i]) : nums[i];
        int newMax = taken ? Math.max(currMax, nums[i]) : nums[i];
        
        int include = combination(i + 1, n, nums, newMin, newMax, true, target);
        int exclude = combination(i + 1, n, nums, currMin, currMax, taken, target);

        return (include + exclude) % mod;
    }

    public int numSubseq(int[] nums, int target) {
        return combination(0, nums.length, nums, 0, 0, false, target);
    }
}

public class NoOfSubsequenceWithSumK {

    public static void main(String[] args) {
        
        Solution sol = new Solution();
        
        int nums1[] = {3, 5, 6, 7};
        int target1 = 9;
        int result1 = sol.numSubseq(nums1, target1);
        System.out.println("Number of subsequences: " + result1);

    }
}
