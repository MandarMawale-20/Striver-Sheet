class Solution {
    public int longestConsecutive(int[] nums) {
    int n =  nums.length;
     if(n==0){
        return 0;
     }

     Arrays.sort(nums);
     int lastSmaller = Integer.MIN_VALUE;
        int cnt = 1;
        int longest = 1;

 
        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1]) {
                continue; 
            } else if (nums[i] == nums[i - 1] + 1) {
                cnt++;
            } else {
                cnt = 1; 
            }

            longest = Math.max(longest, cnt);
        }
        return longest;
    

    }
}


//Time Complexity: O(nlogn) for sorting, O(n) for traversing the array
//Space Complexity: O(1) for the array, O(n) for the list