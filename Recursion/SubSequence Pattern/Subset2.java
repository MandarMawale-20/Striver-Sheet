import java.util.*;

/*
 * Problem: Subsets II
 * 
 * Given an integer array nums that may contain duplicates, return all possible subsets 
 * (the power set).
 * 
 * The solution set must not contain duplicate subsets. You may return the solution 
 * in any order.
 */

class Solution {
    
    //Optimal Solution 
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        Arrays.sort(nums);
        subset(0, nums, ans, new ArrayList<>());
        return new ArrayList<>(ans);
    }

    public void subset(int index, int[] nums, Set<List<Integer>> ans, List<Integer> temp) {
        ans.add(new ArrayList<>(temp));

        for(int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) continue;

            temp.add(nums[i]);
            subset(i + 1, nums, ans, temp);
            temp.remove(temp.size() - 1);
        }
    }

    //Brute Solution
    public List<List<Integer>> subsetsWithDupBrute(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        Arrays.sort(nums);
        subsetBrute(0, nums, ans, new ArrayList<>());
        return new ArrayList<>(ans);
    }

    public void subsetBrute(int index, int[] nums, Set<List<Integer>> ans, List<Integer> temp) {
        if (index == nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        temp.add(nums[index]);
        subsetBrute(index + 1, nums, ans, temp);
        
        temp.remove(temp.size() - 1);
        subsetBrute(index + 1, nums, ans, temp);
    }
}

public class Subset2 {

    public static void main(String[] args) {
        
        Solution sol = new Solution();
        
        int[] nums = {1, 2, 2};
        
        System.out.println("Optimal :");
        
        List<List<Integer>> result1 = sol.subsetsWithDup(nums);
        for(List<Integer> subset : result1) {
            System.out.println(subset);
        }
        
        System.out.println("\nBrute:");
        
        List<List<Integer>> result2 = sol.subsetsWithDupBrute(nums);
        for(List<Integer> subset : result2) {
            System.out.println(subset);
        }

    }
}
