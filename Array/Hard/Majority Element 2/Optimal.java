class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> majority = new ArrayList<>();
        int n =nums.length;
        int cnt1=0;
        int cnt2=0;
        int ele1 = Integer.MIN_VALUE;
        int ele2 = Integer.MIN_VALUE;


        for(int i = 0;i<n;i++){
            if(cnt1 == 0 && ele2 !=nums[i]){
                cnt1 = 1;;
                ele1=nums[i];
            }
            else if(cnt2 == 0 && ele1 !=nums[i]){
                cnt2 = 1;;
                ele2 = nums[i];
            }
            else if(ele1 == nums[i]) cnt1++;
            else if(ele2 == nums[i]) cnt2++;
            else{
                cnt1--;
                cnt2--;
            }
        }
        
        cnt1 = 0; cnt2 = 0;
        for(int i = 0;i<n;i++){
            if(nums[i]==ele1) cnt1++;
            if(nums[i]==ele2) cnt2++;
        }

        if(cnt1>=(n/3+1)) majority.add(ele1);
        if(cnt2>=(n/3+1)) majority.add(ele2);

        return majority;
    }
}

// Time Complexity: O(N)
// Space Complexity: O(1)
// Note: This solution uses the Boyer-Moore Voting Algorithm to find the majority elements in linear time and constant space.