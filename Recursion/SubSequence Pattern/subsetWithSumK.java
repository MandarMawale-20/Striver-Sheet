import java.util.*;
/*
 * Problem: Count Subsets with Sum K
 * 
 * You are given an array 'arr' of size 'n' containing positive integers 
 * and a target sum 'k'.
 * 
 * Find the number of ways of selecting the elements from the array such that 
 * the sum of chosen elements is equal to the target 'k'.
 */

class Solution {
    
    public static int findWays(int num[], int tar) {
        return count(0, tar, num);
    }

    public static int count(int index, int tar, int num[]) {
        if(tar == 0) return 1;

        if(tar < 0 || index == num.length) return 0;

        return count(index + 1, tar - num[index], num) +  count(index + 1, tar, num);
    }


}

public class subsetWithSumK {

    public static void main(String[] args) {
        
        int arr[] = {1, 2, 2, 3};
        int target = 5;
        

        
        int bruteForcResult = Solution.findWays(arr, target);
        System.out.println( bruteForcResult);

    }
}
