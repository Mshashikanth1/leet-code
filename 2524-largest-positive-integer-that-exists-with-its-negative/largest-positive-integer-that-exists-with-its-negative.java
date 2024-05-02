class Solution {
    public int findMaxK(int[] nums) {
        Arrays.sort(nums);
        Set<Integer> hset=new HashSet<>();
        for(int i: nums){
            hset.add(i);
        }

        for(int i=nums.length-1;i>=0;i--) {
            if(hset.contains(-1*nums[i])){
                return nums[i];
            }
        }
        return -1;
    }
}