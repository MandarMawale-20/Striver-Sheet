import java.io.*;
import java.util.*;
class Solution {
    static ArrayList<Integer> leaders(int arr[]) {
         int n = arr.length;
         int max =  arr[n-1];
         ArrayList<Integer> ans = new ArrayList<>();
         ans.add(arr[n-1]);
         
         for(int i = n-2 ;i>=0;i--){
             
             if(arr[i]>=max){
                max = arr[i];
                ans.add(arr[i]);
             }
         }
        Collections.reverse(ans);

         return ans;
    }
}

//Time Complexity: O(n)
//Space Complexity: O(1) for the array, O(n) for the list