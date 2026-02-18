import java.util.*;

/*
 * Problem: Subsets
 * 
 * Given an integer array nums of unique elements, return all possible subsets 
 * (the power set).
 * 
 * The solution set must not contain duplicate subsets. You may return the solution 
 * in any order.
 */

class Solution {
    
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        subset(0, nums, ans, new ArrayList<>());
        return ans;
    }

    public void subset(int left, int[] nums, List<List<Integer>> ans, List<Integer> temp) {
        ans.add(new ArrayList<>(temp));

        for(int i = left; i < nums.length; i++) {
            temp.add(nums[i]);
            subset(i + 1, nums, ans, temp);
            temp.remove(temp.size() - 1);
        }
    }
}

public class Subset1 {

    public static void main(String[] args) {
        
        Solution sol = new Solution();
        
        int[] nums = {1, 2, 3};

        List<List<Integer>> result = sol.subsets(nums);
        
        for(List<Integer> subset : result) {
            System.out.println(subset);
        }
    }
}

