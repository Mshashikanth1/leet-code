class Solution {
    public int findMaxK1(int[] nums) {
        Arrays.sort(nums);
        Set<Integer> hset=new HashSet<>();
        for(int i: nums){
            hset.add(i);
        }

        for(int i=nums.length-1; i>=0; i--) {
            if(hset.contains(-1*nums[i])){
                return nums[i];
            }
        }
        return -1;
    }

     public int findMaxK(int[] nums) {
        int max=Integer.MIN_VALUE;
        Set<Integer> hset=new HashSet<>();
        for(int i: nums){

            if(hset.contains(-1*i)){
                max=Math.max(max,Math.abs(i));
            }
            hset.add(i);
        }

        return max==Integer.MIN_VALUE? -1:max;
    }
}