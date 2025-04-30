import java.io.*;
import java.util.*;

class Solution {
    static ArrayList<Integer> leaders(int arr[]) {
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i =0;i<n;i++){
            boolean lead = true; 
            for(int j = i+1;j<n;j++){
                if(arr[j]>arr[i]){
                    lead = false;
                    break;
                }
            }
            
            if(lead){
                ans.add(arr[i]);
            }
        }
        
        return ans;
    }
}

//Time Complexity: O(n^2)
//Space Complexity: O(1) for the array, O(n) for the list