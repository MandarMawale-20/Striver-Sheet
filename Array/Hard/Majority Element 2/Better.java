class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> majority = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        int n =nums.length;

        for(int i = 0;i<n;i++){
            int value = map.getOrDefault(nums[i],0);
            map.put(nums[i],value+1);

            if(map.get(nums[i])==n/3+1){
                majority.add(nums[i]);
            }
            if(majority.size() == 2) break;
        }

        return majority;
    }
}
//Time Complexity: O(N*logN)
//Space Complexity: O(N)