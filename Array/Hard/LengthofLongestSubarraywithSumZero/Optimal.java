import java.io.*;
import java.util.* ;

import java.util.ArrayList;

public class Optimal {

	public static int LongestSubsetWithZeroSum(ArrayList<Integer> arr) {

		// Write your code here.
		HashMap<Integer,Integer> map = new HashMap<>();
		 int n = arr.size();
		 int max = 0;
		 int sum =0;

		 for(int i =0;i<n;i++){
			 sum+= arr.get(i);

			 if(sum == 0){
				 max = i+1;
			 }
			 else{
				 if(map.get(sum) != null){
					 max = Math.max(max, i - map.get(sum)); 
				 }
				 else{
					 map.put(sum,i);
				 }
			 }
		 }
		 return max;
	}
}
// Time Complexity: O(N)
// Space Complexity: O(N)
// Note: This code finds the length of the longest subarray with a sum of zero using a hash map to store cumulative sums and their indices, allowing for efficient lookups.