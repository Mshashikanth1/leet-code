2460. Apply Operations to an Array.java
problem:https://leetcode.com/problems/apply-operations-to-an-array/description/
class Solution {
    public int[] applyOperations(int[] nums) {
        int i=0;
        while (i<nums.length-1){
            if (nums[i]==nums[i+1]){
                nums[i]*=2;
                nums[i+1]=0;
            }
            i++;
        }
        i=0;
        while(i<nums.length-1){
        
        if(nums[i]==0){
            int j=i+1;
            while (nums[j]==0 && j<nums.length-1){j++; }
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
        }
        i++;
        
        }
                        System.out.println(Arrays.toString(nums));

        return nums;
    }
}
