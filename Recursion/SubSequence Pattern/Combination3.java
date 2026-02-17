import java.util.*;

/*
 * Problem: Combination Sum III
 * 
 * Find all valid combinations of k numbers that sum up to n such that the following 
 * conditions are satisfied:
 * - Only numbers 1 through 9 are used
 * - Each number is used at most once
 * 
 */

class Solution {
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        int[] candidates = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        combinations(0, candidates, n, k, ans, new ArrayList<>());
        return ans;
    }

    private void combinations(int index, int[] arr, int target, int k, List<List<Integer>> ans, List<Integer> temp) {
        if (target == 0 && temp.size() == k) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        if (temp.size() > k || target < 0) {
            return;
        }

        for (int i = index; i < arr.length; i++) {
            temp.add(arr[i]);
            combinations(i + 1, arr, target - arr[i], k, ans, temp);
            temp.remove(temp.size() - 1);
        }
    }
}

public class Combination3 {

    public static void main(String[] args) {
        
        Solution sol = new Solution();
        
        int k = 3;
        int n = 7;
        
        List<List<Integer>> result = sol.combinationSum3(k, n);
        
        for(List<Integer> combination : result) {
            System.out.println(combination);
        }
    }
}
