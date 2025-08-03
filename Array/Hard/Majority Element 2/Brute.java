class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> majority = new ArrayList<>();
        int n =nums.length;
        for(int i = 0;i<n;i++){
            int count = 1;
            for(int j =i+1;j<n;j++){
                if(nums[i]==nums[j]){
                    count++;
                }
            }

            if(count>(n/3)){
                if(!majority.contains(nums[i])){
                    majority.add(nums[i]);
                }
            }
        }

        return majority;
    }
}

//Time Complexity: O(N^2)
//Space Complexity: O(1)