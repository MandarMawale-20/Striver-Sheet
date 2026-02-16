import java.util.*;

/*
 * Problem: Combination Sum II
 * 
 * Given a collection of candidate numbers (candidates) and a target number (target),
 * find all unique combinations in candidates where the candidate numbers sum to target.
 * 
 * Each number in candidates may only be used once in the combination.
 */

class Solution {
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        combinations(0, candidates, target, ans, new ArrayList<>());
        return ans;
    }

    public void combinations(int index, int[] arr, int target, List<List<Integer>> ans, List<Integer> temp) {
        if (target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = index; i < arr.length; i++) {
            if (i > index && arr[i] == arr[i - 1]) 
                continue;

            if (arr[i] > target) 
                break;

            temp.add(arr[i]);
            combinations(i + 1, arr, target - arr[i], ans, temp);
            temp.remove(temp.size() - 1);
        }
    }
}

public class Combination2 {

    public static void main(String[] args) {
        
        Solution sol = new Solution();
        
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        
        List<List<Integer>> result = sol.combinationSum2(candidates, target);
        
        for(List<Integer> combination : result) {
            System.out.println(combination);
        }
    }
}
