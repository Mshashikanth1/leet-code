1480. Running Sum of 1d Array.java
problem : https://leetcode.com/problems/running-sum-of-1d-array/?envType=study-plan&id=level-1
class Solution {
    public int[] runningSum(int[] nums) {
        if(nums.length==1){return nums;}
        int[] runningSum= new int[nums.length];
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            runningSum[i]=sum;
        }
        return runningSum;
        
    }
}
