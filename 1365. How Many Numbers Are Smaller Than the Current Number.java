/*
1365. How Many Numbers Are Smaller Than the Current Number.java
problem :https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/
 */
class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n=nums.length;
        int[] ans=new int[n];
    int countOFNSTC;
    for(int i=0;i<n;i++){
        countOFNSTC=0;
        for(int j=0;j<n;j++){
            if(i!=j && nums[i]>nums[j]){
                countOFNSTC++;
            }
        }
        ans[i]=countOFNSTC;
    }
    return ans;  
    }
}
