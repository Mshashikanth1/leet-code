2348. Number of Zero-Filled Subarrays.java
problem:https://leetcode.com/problems/number-of-zero-filled-subarrays/editorial/
class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long subArray=0,ans=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                subArray+=1;
                ans+=subArray;
            }
            else{
                subArray=0;
            }
        }
        return ans;
    }
}
