import java.io.*;
import java.util.* ;

import java.util.ArrayList;

public class Brute {

	public static int LongestSubsetWithZeroSum(ArrayList<Integer> arr) {
		// Write your code here.
		int max = 0;
		int n = arr.size();
		for(int i =0;i<n;i++){
			int sum =0;
			for(int j =i;j<n;j++){
				sum +=arr.get(j);
				if(sum == 0){
					max=Math.max(max,j-i+1);
				}
			}
		}
		return max;

	}
}

// Time Complexity: O(N^2)
// Space Complexity: O(1)
// Note: This code finds the length of the longest subarray with a sum of zero using a brute force approach by checking all possible subarrays.