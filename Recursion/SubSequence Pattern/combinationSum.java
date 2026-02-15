import java.util.*;

/*
 * Problem: Combination Sum
 * 
 * Given an array of distinct integers candidates and a target integer target, 
 * return a list of all unique combinations of candidates where the chosen numbers sum to target.
 * 
 * You may return the combinations in any order.
 * The same number may be chosen from candidates an unlimited number of times.
 */

class Solution {
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        combinations(0, candidates, target, ans, new ArrayList<>());
        return ans;
    }

    public void combinations(int index, int[] arr, int target, List<List<Integer>> ans, List<Integer> temp) {
        if (index == arr.length) {
            if (target == 0) {
                ans.add(new ArrayList<>(temp));
            }
            return;
        }

        if(arr[index] <= target){
            temp.add(arr[index]);
            combinations(index, arr, target - arr[index], ans, temp);
            temp.remove(temp.size() - 1);
        }
        combinations(index + 1, arr, target, ans, temp);
    }
}

public class combinationSum {

    public static void main(String[] args) {
        
        Solution sol = new Solution();
        
        int[] candidates = {2, 3, 6, 7};
        int target = 7;

        List<List<Integer>> result = sol.combinationSum(candidates, target);
        
        for(List<Integer> combination : result) {
            System.out.println(combination);
        }
    }
}
