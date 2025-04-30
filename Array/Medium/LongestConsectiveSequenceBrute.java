class Solution {
    public int longestConsecutive(int[] nums) {
     int n =  nums.length;
     if(n==0){
        return 0;
     }
     int longest = 1;
       for(int i = 0;i<n;i++){
        int curr = nums[i];
        int count = 1;

        while(linearsearch(nums,curr+1)==true){
            count++;
            curr++;
        }
        longest = Math.max(longest,count);
       } 
       return longest;
    }

    public static boolean linearsearch(int[] nums,int curr){
            int n =  nums.length;
            for(int i = 0;i<n;i++){
                if(nums[i] == curr){
                    return true;
                }
            }
        return false;
    }

}
//Time Complexity: O(n^2) for traversing the array and linear search
//Space Complexity: O(1) for the array, O(n) for the list